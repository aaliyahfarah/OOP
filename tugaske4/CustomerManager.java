package tugaske4;

import java.util.ArrayList;
import tugaske4.repo.CustomerInterface;

public class CustomerManager implements CustomerInterface{
    private ArrayList<Customer> customers;

    public CustomerManager() {
        this.customers = new ArrayList<>();
    }

    public Integer checkCustomerData(String telephone) {
        for (Customer c : customers) {
            //System.out.println(c.getTelephone() + " " + telephone);
            if (c.getTelephone().equalsIgnoreCase(telephone)) {
                return c.getId();
            }
        }
        return -2; //not found
    }

    @Override
    public void addInterface(Customer customer) {
        checkCustomerData(customer.getTelephone());

        if (checkCustomerData(customer.getTelephone()) == -2) {
            customers.add(customer);
            Customer.customerCount += 1;
            System.out.println("\nCustomer berhasil ditambahkan");
        }
        else 
            System.out.println("\nPenambahan data customer GAGAL!");
    }

    @Override
    public void displayInterface() {
        System.out.println("List Customers:");
        for (Customer c : customers) {
            System.out.println(c);
        }
    }
}
