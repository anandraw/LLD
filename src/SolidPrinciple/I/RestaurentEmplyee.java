package SolidPrinciple.I;

// I:interface segmented principle
// means interfaces should be such that client should be implemented unnecessary function they do not need

public interface RestaurentEmplyee {
    void washDishes();
    void serveCustomers();
    void cookFood();
}
class Waiter implements RestaurentEmplyee {

    @Override
    public void washDishes() {
        // waiter said this is not my job
    }

    @Override
    public void serveCustomers() {
        System.out.println("Serving Customers"); // this is my job
    }

    @Override
    public void cookFood() {
       // said this is not my job sp unnecessary this are adding
    }
}

// solution : to avoid the unnecessary work

// this is for waiter
interface WaiterInterface{
    void serveCustomers();
    void takeOrder();
}

// this for chef
interface ChefInterface{
    void cockFood();
    void decideMenu();
}

class Waiteer implements WaiterInterface{

    @Override
    public void serveCustomers() {
        System.out.println("Serving Customers");
    }

    @Override
    public void takeOrder() {
      System.out.println("Taking Order");
    }
}

class Chef implements ChefInterface{

    @Override
    public void cockFood() {
        System.out.println("Cocking Food");
    }

    @Override
    public void decideMenu() {
      System.out.println("Deciding Menu");
    }
}