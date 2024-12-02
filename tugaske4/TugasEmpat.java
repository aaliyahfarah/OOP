package tugaske4;

import java.util.Scanner;

public class TugasEmpat {
    static Customer[] customers = new Customer[50];
    static int customerCount = 0;
    static Vehicle[] vehicles = new Vehicle[50];
    static Purchase[] purchases = new Purchase[50];
    static Integer vehicleCount = 0;
    static Integer purchaseCount = 0;

    public static void main(String[] args) {
        System.out.println("///////////////////////////////Welcome!///////////////////////////////");

        startProgram();
        //chooseMenu();

        //Customer.displayRegister();
        //Vehicle.displayVehicle();
    }

    public static void startProgram(){
        Customer.addCustomer("Jane", "Doe", "08123456789", "2894 Ferrell Street");
        Customer.addCustomer("Betty", "Lange", "08123456789", "2590 Flower Street");

        //Customer.printAllCustomers();
        //System.out.println("success");
        Vehicle.addVehicle("1-72393282", "Vario", 19000000);
        Vehicle.addVehicle("2-77239325", "HRV", 300000000);
        Vehicle.addVehicle("3-47239323", "Ertiga", 200000000);


        //customer/tanggal/payment
        // addPurchase(1, "24-11-17", "Debit");
        // addPurchaseDetail(1, "1-72393282");
        // addPurchaseDetail(1, "2-72393282");
    }

    public static void chooseMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n"+"-----     Menu     -----");

        Integer menu;
        do {
            System.out.println("Pilih menu (masukkan angka):");
            System.out.println("1. Registrasi");
            System.out.println("2. Pembelian");
            System.out.println("3. Invoice");
            System.out.println("0. Keluar");
            System.out.println("Pilih: ");
            menu = scanner.nextInt();
        } while ((menu != 0) && (menu != 1) && (menu != 2) && (menu != 3)); 

        switch (menu) {
            case 1: Customer.displayRegister();
                break;
            case 2: //Purchase.displayAddPurchase();
                break;
            case 3: //displayInvoice();
                break;
            default: System.out.println("////////////////////////////Program selesai///////////////////////////");
                break;
        }
    }
       
    public static void addVehicle(String id, String type, double price) {
        Vehicle vehicle = new Vehicle(id, type, price);
        vehicles[vehicleCount++] = vehicle;
    }

}
