package SolidPrinciple.D;


//D:Dependency Inversion Principle (DIP)
// class should be depended on interface rather than concrete classes
//High-level modules ko low-level modules pe depend nahi karna chahiye
public class Main {
}

// Bad Example: DIP Violated

// Low-level module (Concrete implementation)
class CreditCardPayment {
    public void processPayment() {
        System.out.println("Processing credit card payment");
    }
}

// High-level module (Business logic)
class PaymentService {
    private CreditCardPayment creditCardPayment;

    public PaymentService() {
        creditCardPayment = new CreditCardPayment();  // Directly dependent on CreditCardPayment
    }

    public void makePayment() {
        creditCardPayment.processPayment();
    }
}


// Good Example: DIP Followed

// Abstraction (Interface)
interface PaymentGateway {
    void processPayment();
}

// Concrete implementation for CreditCardPayment
class CreditCardPayment1 implements PaymentGateway {
    public void processPayment() {
        System.out.println("Processing credit card payment");
    }
}

// Concrete implementation for PayPalPayment
class PayPalPayment implements PaymentGateway {
    public void processPayment() {
        System.out.println("Processing PayPal payment");
    }
}

// High-level module (Business logic)
class PaymentService1 {
    private PaymentGateway paymentGateway;

    // Constructor injection for flexibility
    public PaymentService1(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void makePayment() {
        paymentGateway.processPayment();
    }
}
