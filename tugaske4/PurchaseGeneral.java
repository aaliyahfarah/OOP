package tugaske4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PurchaseGeneral {

    public PurchaseGeneral(int par, Integer idCustomer, String inputPurchaseDate, String inputPurchasePaymentMethod, double par1) {
    }
    private static Integer purchaseCount = 0;
    private static Purchase[] purchases = new Purchase[100];

    public static void displayAddPurchase() {
        System.out.println("\n" + "----- Tambah Pembelian -----");

        Scanner purchaseScanner = new Scanner(System.in);

        System.out.println("Masukkan No Telephone: ");
        String inputPurchaseCustomerTelephone = purchaseScanner.nextLine();

        // Get the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
        LocalDate now = LocalDate.now();
        String inputPurchaseDate = now.format(formatter);

        System.out.println("Masukkan Payment Method (Debit/Credit card): ");
        String inputPurchasePaymentMethod = purchaseScanner.nextLine();

        String message = addPurchase(inputPurchaseCustomerTelephone, inputPurchaseDate, inputPurchasePaymentMethod);
        System.out.println(message);

        Integer num;
        do {
            System.out.println("\nKetik 1 untuk menambahkan produk dan Ketik 0 untuk checkout:");
            num = purchaseScanner.nextInt();
            if (num == 1) {
                PurchaseDetail.displayAddDetail(purchaseCount);
            }
        } while (num != 0);

        // displayInvoiceDetail(purchaseCount);
        // chooseMenu();
    }

    public static String addPurchase(String inputPurchaseCustomerTelephone, String inputPurchaseDate, String inputPurchasePaymentMethod) {
        String message;

        // Get customer ID
        Integer idCustomer = Customer.checkCustomerData(inputPurchaseCustomerTelephone);

        if (idCustomer == -2) {
            message = "Silahkan registrasi terlebih dahulu";
        } else {
            // Create a new purchase
            PurchaseGeneral newPurchase = new PurchaseGeneral(purchaseCount + 1, idCustomer, inputPurchaseDate, inputPurchasePaymentMethod, 0.0);
            purchaseCount++;
            message = "Data purchase berhasil ditambahkan";
        }
        return message;
    }

    // public static void displayAddDetail(Integer purchaseId) {
    //     // Implement this based on your requirements
    // }

    // public static void displayInvoiceDetail(Integer purchaseId) {
    //     // Implement this based on your requirements
    // }

    // public static void chooseMenu() {
    //     // Implement this based on your requirements
    // }
}
