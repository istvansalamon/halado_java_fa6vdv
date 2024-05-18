package hu.unimiskolc.shopping.service;

import hu.unimiskolc.shopping.DTO.PaymentDTO;
import hu.unimiskolc.shopping.exception.PaymentNotFoundException;

import java.util.List;

public interface PaymentService {
    PaymentDTO findById(String paymentId) throws PaymentNotFoundException;
    void createPayment(PaymentDTO paymentDTO);
    void updatePayment(PaymentDTO paymentDTO) throws PaymentNotFoundException;
    void deletePaymentById(String paymentId) throws PaymentNotFoundException;
    List<PaymentDTO> getAllPayments();
}
