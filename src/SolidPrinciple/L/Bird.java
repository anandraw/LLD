package SolidPrinciple.L;

// L: Liskov Substitution Principle
// subclass should be extended the capability of parent class not narrow it down

public class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Sparrow extends Bird {
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Ostrich extends Bird {
    public void fly() {
        // Ostriches can't fly, but not throwing an exception so here break the properties of parent
        throw new UnsupportedOperationException("Ostriches can't fly");
    }
}

//solution:
// Base class
abstract class Bird1{
    public abstract void fly();
}

// Derived class
class Sparrow1 extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

// Derived class
class Ostrich1 extends Bird {
    @Override
    public void fly() {
        // Ostriches can't fly, but not throwing an exception
        System.out.println("Ostrich can't fly");
    }
}
