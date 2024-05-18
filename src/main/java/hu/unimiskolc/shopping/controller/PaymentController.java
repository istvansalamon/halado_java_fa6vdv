package hu.unimiskolc.shopping.controller;

import hu.unimiskolc.shopping.DTO.PaymentDTO;
import hu.unimiskolc.shopping.exception.PaymentNotFoundException;
import hu.unimiskolc.shopping.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{id}")
    public PaymentDTO getPaymentById(@PathVariable String id) throws PaymentNotFoundException {
        return paymentService.findById(id);
    }

    @PostMapping
    public void createPayment( @Valid @RequestBody PaymentDTO paymentDTO) {
        paymentService.createPayment(paymentDTO);
    }

    @PutMapping("/{id}")
    public void updatePayment(@PathVariable String id, @Valid @RequestBody PaymentDTO paymentDTO) throws PaymentNotFoundException {
        paymentDTO.setPaymentId(id);
        paymentService.updatePayment(paymentDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable String id) throws PaymentNotFoundException {
        paymentService.deletePaymentById(id);
    }

    @GetMapping
    public List<PaymentDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }
}
