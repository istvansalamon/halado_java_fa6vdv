package hu.unimiskolc.shopping.service;

import hu.unimiskolc.shopping.DTO.PaymentDTO;
import hu.unimiskolc.shopping.exception.PaymentNotFoundException;
import hu.unimiskolc.shopping.model.Payment;
import hu.unimiskolc.shopping.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public PaymentDTO findById(String paymentId) throws PaymentNotFoundException {
        Payment payment = paymentRepository.findById(paymentId);
        if (payment == null) {
            throw new PaymentNotFoundException("Payment not found with ID: " + paymentId);
        }
        return convertToDTO(payment);
    }

    @Override
    public void createPayment(PaymentDTO paymentDTO) {
        Payment payment = convertToEntity(paymentDTO);
        paymentRepository.save(payment);
    }

    @Override
    public void updatePayment(PaymentDTO paymentDTO) throws PaymentNotFoundException {
        Payment payment = paymentRepository.findById(paymentDTO.getPaymentId());
        if (payment == null) {
            throw new PaymentNotFoundException("Payment not found with ID: " + paymentDTO.getPaymentId());
        }
        payment.setAmount(paymentDTO.getAmount());
        payment.setDate(paymentDTO.getDate());
        payment.setMethod(paymentDTO.getMethod());
        paymentRepository.save(payment);
    }

    @Override
    public void deletePaymentById(String paymentId) throws PaymentNotFoundException {
        if (!paymentRepository.existsById(paymentId)) {
            throw new PaymentNotFoundException("Payment not found with ID: " + paymentId);
        }
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PaymentDTO convertToDTO(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setPaymentId(payment.getPaymentId());
        paymentDTO.setAmount(payment.getAmount());
        paymentDTO.setDate(payment.getDate());
        paymentDTO.setMethod(payment.getMethod());
        return paymentDTO;
    }

    private Payment convertToEntity(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setPaymentId(paymentDTO.getPaymentId());
        payment.setAmount(paymentDTO.getAmount());
        payment.setDate(paymentDTO.getDate());
        payment.setMethod(paymentDTO.getMethod());
        return payment;
    }
}
