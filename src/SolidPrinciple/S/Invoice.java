package SolidPrinciple.S;


class Marker{
    String name;
    String colour;
    int price;
    int year;

    public Marker(String name, String colour, int price, int year) {
        this.name = name;
        this.colour = colour;
        this.price = price;
        this.year = year;
    }
}

public class Invoice {

    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    // suppose in feature GST will added and then calculate the price
    // here break the principle
    public int calculateTotal() {
        int price = ((marker.price) * this.quantity);
        return price;
    }

    // suppose another changes do in this invoice logic so print logic also change;
    public void printInvoice() {
        //print logic here
    }

    // also in feature we want ot store the data in the file
    public void savedToDB(){
        // write logic here
    }

    // so overall this class cannot perform single responsibility principle
    // so how to resolve this issue
}

// solution: make diff classes for the diff task
// break down the solution of this problem

// so i create separate classes for each sub-task
//step-I
class ModifiedInvoice{
    private Marker marker;
    private int quantity;

    public ModifiedInvoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }
    public int calculateTotal() {
        int price = ((marker.price) * this.quantity);
        return price;
    }
}

//step=II
class InvoiceDoa{
    Invoice invoice;

    public InvoiceDoa(Invoice invoice) {
        this.invoice = invoice;
    }
    public void saveToDB() {
        invoice.savedToDB();
    }
}

//step-III
class InvoicePrinter{

    private Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }
    public void printInvoice() {
        invoice.printInvoice();
    }
}