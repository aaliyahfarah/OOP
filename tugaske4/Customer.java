package tugaske4;

import java.util.Scanner;

class Customer {
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;

    private static Integer customerCount = 0;
    private static Integer[] customerId = new Integer[50];
    private static String[] customerFirstName = new String[50];
    private static String[] customerLastName = new String[50];
    private static String[] customerTelephone = new String[50];
    private static String[] customerAddress = new String[50];


    public Customer(String firstName, String lastName, String telephone, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
    }

    public static int checkCustomerData(String telephone) {
        for (int i = 0; i < customerCount; i++) {
            if (customerTelephone[i].equals(telephone)) {
                return customerId[i];
            }
        }
        return -2; // Customer not found
    }

    public static String addCustomer(String firstName, String lastName, String telephone, String address) {
        customerId[customerCount] = customerCount + 1;
        customerFirstName[customerCount] = firstName;
        customerLastName[customerCount] = lastName;
        customerTelephone[customerCount] = telephone;
        customerAddress[customerCount] = address;
        customerCount++;
        return "Data customer berhasil ditambahkan";
    }

    public static void displayRegister() {
        Scanner custScanner = new Scanner(System.in);

        String[] atributCustomer = {"Nama Depan", "Nama Belakang", "Nomor Telepon", "Alamat"};
        String[] inputCustomer = new String[4];

        for (int i = 0; i < 4; i++) {
            System.out.println("Masukkan " + atributCustomer[i] + ": ");
            inputCustomer[i] = custScanner.nextLine();
        }

        int result = checkCustomerData(inputCustomer[2]);
        if (result == -2) {
            String message = addCustomer(inputCustomer[0], inputCustomer[1], inputCustomer[2], inputCustomer[3]);
            System.out.println(message);
        } else {
            System.out.println("Anda sudah pernah melakukan registrasi");
        }

    }

    // public static void printAllCustomers() {
    //     if (customerCount == 0) {
    //         System.out.println("No customers to display.");
    //     } else {
    //         System.out.println("----- Customer List -----");
    //         for (int i = 0; i < customerCount; i++) {
    //             System.out.println("ID: " + customerId[i]);
    //             System.out.println("First Name: " + customerFirstName[i]);
    //             System.out.println("Last Name: " + customerLastName[i]);
    //             System.out.println("Telephone: " + customerTelephone[i]);
    //             System.out.println("Address: " + customerAddress[i]);
    //             System.out.println("-------------------------");
    //         }
    //     }
    // }

}