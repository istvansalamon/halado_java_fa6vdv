package hu.unimiskolc.shopping.repository;

import hu.unimiskolc.shopping.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {
    private List<Payment> payments = new ArrayList<>();

    public Payment findById(String paymentId) {
        return payments.stream()
                .filter(payment -> payment.getPaymentId().equals(paymentId))
                .findFirst()
                .orElse(null);
    }

    public void save(Payment payment) {
        deleteById(payment.getPaymentId());
        payments.add(payment);
    }

    public void deleteById(String paymentId) {
        payments.removeIf(payment -> payment.getPaymentId().equals(paymentId));
    }

    public boolean existsById(String paymentId) {
        return payments.stream().anyMatch(payment -> payment.getPaymentId().equals(paymentId));
    }

    public List<Payment> findAll() {
        return new ArrayList<>(payments);
    }
}
