package SolidPrinciple.O;

import SolidPrinciple.S.Invoice;

//O: Open for extension but closed for modification
public class InvoiceDao {

    Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    // here in future we want to store the data in file instead of DB
    public void saveToDB(Invoice invoice) {
        //write the logic here
    }
}

// solution
interface InvoiceDaoo{

    public void save(Invoice invoice); // now we can save in anything like DB and also file
}

class DatabaseInvoiceDao implements InvoiceDaoo{

    @Override
    public void save(Invoice invoice) {
        //give the database saving logic
    }
}

class FileDataDao implements InvoiceDaoo{

    @Override
    public void save(Invoice invoice) {
        // give the file saved logic
    }
}