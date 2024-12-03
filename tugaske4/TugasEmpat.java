package tugaske4;

import java.util.Scanner;

public class TugasEmpat {
// gunakan fitur transaksi dari use case yg sudah dibuat pada tugas sebelumnya
// transformasikan code program dari fitur use case yang sudah dibuat dengan menggunakan OOP
// wajib menggunakan Class & Object
// wajib menggunakan Inheritance
// wajib menggunakan Polimorphism (boleh pilih antara Override / Overload)
// wajib menggunakan Encapsulation
// wajib menggunakan Abstraction (boleh pilih antara Partial / Full)

    public static void main(String[] args) {
        System.out.println("///////////////////////////////Welcome!///////////////////////////////");

        CustomerManager custmanage = new CustomerManager();
        VehicleManager vehiclemanage = new VehicleManager();
        startProgram(custmanage, vehiclemanage);
        chooseMenu(custmanage, vehiclemanage);
        
        //displayAddPurchase(custmanage);
        
    }

    public static void startProgram(CustomerManager custmanage, VehicleManager vehiclemanage){
        Customer customer1 = new Customer("Jane", "Doe", "08123456789", "2894 Ferrell Street");
        custmanage.addInterface(customer1);
        Customer customer2 = new Customer("Betty", "Lange", "08123456789", "2590 Flower Street");
        custmanage.addInterface(customer2);
        Customer customer3 = new Customer("Betty", "Doe", "08123456780", "2890 Flower Street");
        custmanage.addInterface(customer3);
        custmanage.displayInterface();

        Vehicle vehicle1 = new Vehicle("1-72393282", "Vario", 19000000d);
        Vehicle vehicle2 = new Vehicle("2-77239325", "HRV", 300000000d);
        Vehicle vehicle3 = new Vehicle("3-47239323", "Ertiga", 200000000d);
        Vehicle vehicle4 = new Vehicle("1-72493282", "Vario", 19000000d);
        Vehicle vehicle5 = new Vehicle("2-77234425", "HRV", 300000000d);
        vehiclemanage.addInterface(vehicle1);
        vehiclemanage.addInterface(vehicle2);
        vehiclemanage.addInterface(vehicle3);
        vehiclemanage.addInterface(vehicle4);
        vehiclemanage.addInterface(vehicle5);

        Purchase purchase = new Purchase(1, "Credit");

        // Create PurchaseDetails
        purchase.checkPurchaseDetail("1-72393282", vehiclemanage);
        purchase.checkPurchaseDetail("2-77239325", vehiclemanage);

        purchase.displayPurchaseDetails();

        Purchase purchase1 = new Purchase(1, "Credit");

        // Create PurchaseDetails
        purchase1.checkPurchaseDetail("2-77239325", vehiclemanage);

        purchase1.displayPurchaseDetails();
    }

    public static void chooseMenu(CustomerManager custmanage, VehicleManager vehiclemanage) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n"+"-----     Menu     -----");

        Integer menu;
        do {
            System.out.println("Pilih menu (masukkan angka):");
            System.out.println("1. Registrasi");
            System.out.println("2. Pembelian");
            System.out.println("0. Keluar");
            System.out.println("Pilih: ");
            menu = scanner.nextInt();
        } while ((menu != 0) && (menu != 1) && (menu != 2)); 

        switch (menu) {
            case 1: displayRegister(custmanage, vehiclemanage);
                break;
            case 2: displayAddPurchase(custmanage, vehiclemanage);
                break;
            default: System.out.println("////////////////////////////Program selesai///////////////////////////");
                break;
        }
    }

    public static void displayRegister(CustomerManager custmanage, VehicleManager vehiclemanage) {
        Scanner custScanner = new Scanner(System.in);

        String[] atributCustomer = {"Nama Depan", "Nama Belakang", "Nomor Telepon", "Alamat"};
        String[] inputCustomer = new String[4];

        CustomerManager custmanage1 = new CustomerManager();

        for (int i = 0; i < 4; i++) {
            System.out.println("Masukkan " + atributCustomer[i] + ": ");
            inputCustomer[i] = custScanner.nextLine();
        }

        Integer checkId = custmanage.checkCustomerData(inputCustomer[2]);
        if(checkId == -2){
            Customer customer = new Customer(inputCustomer[0], inputCustomer[1], inputCustomer[2], inputCustomer[3]);
            custmanage1.addInterface(customer);
            custmanage1.displayInterface();
        }
        else{
            System.out.println("Customer gagal ditambahkan ");
        }
        
        chooseMenu(custmanage, vehiclemanage);
    }

    public static void displayAddPurchase(CustomerManager custmanage, VehicleManager vehiclemanage) {
        System.out.println("\n" + "----- Tambah Pembelian -----");

        Scanner purchaseScanner = new Scanner(System.in);

        System.out.println("Masukkan No Telephone: ");
        String inputCustomerTelephone = purchaseScanner.nextLine();
        Integer checkId = custmanage.checkCustomerData(inputCustomerTelephone);
        if(checkId == -2){
            System.out.println("Registrasi terlebih dahulu!");

        }
        else{
            System.out.println("Masukkan Payment Method (Debit/Credit card): ");
            String inputPaymentMethod = purchaseScanner.nextLine();

            Purchase purchase = new Purchase(checkId, inputPaymentMethod);

            Integer num;
            do {
                System.out.println("\nKetik 1 untuk menambahkan produk dan Ketik 0 untuk checkout:");
                num = purchaseScanner.nextInt();
                if (num == 1) {
                    displayAddDetail(purchase, vehiclemanage);
                }
            } while (num != 0);
            purchase.displayPurchaseDetails();
        }
        chooseMenu(custmanage, vehiclemanage);
    }

    public static void displayAddDetail(Purchase purchase, VehicleManager vehiclemanage) {
        Scanner detailScanner = new Scanner(System.in);
    
        vehiclemanage.displayInterface();
    
        System.out.println("Masukkan ID Vehicle yang ingin dibeli: ");
        String inputVehicleId = detailScanner.nextLine();

        PurchaseDetail purchaseDetail = new PurchaseDetail(inputVehicleId, vehiclemanage, purchase.getId());
        // purchase.addPurchaseDetail(inputVehicleId, vehiclemanage);

        Double afterTaxPrice = purchaseDetail.getAfterTaxPrice(inputVehicleId);

        if(afterTaxPrice == -2){
            System.out.println("Kendaraan tidak tersedia!");
        }
        else{

            purchase.checkPurchaseDetail(inputVehicleId, vehiclemanage);
        
            System.out.println("Detail berhasil ditambahkan!");
        }
    }

}
