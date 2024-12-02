package tugaske4;

import java.util.Scanner;

public class PurchaseDetail extends Purchase{
    private String vehicleId;
    private Double afterTaxPrice;
    
    public PurchaseDetail(){
        super();
    }

    public PurchaseDetail(String vehicleId, Double afterTaxPrice) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public double getAfterTaxPrice() {
        return afterTaxPrice;
    }

    public void setAfterTaxPrice(double afterTaxPrice) {
        this.afterTaxPrice = afterTaxPrice;
    }

    public static void displayAddDetail(Integer inputPurchaseId){
        Scanner detailScanner = new Scanner(System.in);
        displayVehicle();

        System.out.println("Masukkan ID Vehicle yang ingin dibeli: " );
        String inputVehicleId = detailScanner.nextLine();
        
        String message = addDetail(inputVehicleId, inputPurchaseId);
        System.out.println(message);
    }

    public static String addDetail(String inputVehicleId, Integer inputPurchaseId){
        String message = "Tidak ada data purchase";
        Double afterTax;
        
        //untuk dapet id array kurangi 1
        detailPurchaseId[detailCount] = inputPurchaseId;
        detailVehicleId[detailCount] = inputVehicleId;
        afterTax = countTax(inputVehicleId);
        if(afterTax == -2){
            return "Kendaraan tidak tersedia";
        }
        else{
            detailAfterTaxPrice[detailCount] = countTax(inputVehicleId);
            //delete kendaraan
            deleteVehicle(inputVehicleId);
            //displayVehicle();
        }
        // update total price juga
        purchaseTotalPrice[inputPurchaseId-1] = countTotalPrice(inputPurchaseId);
        detailCount++;
        message = "Data detail berhasil ditambahkan";      
            
        return message;
    }

    public static Double countTax(String inputVehicleId) {
        Double after_tax_price = 0.0;
        //get tax
        //pake looping -> idvehicle
        for (int i = 0; i < vehicleCount; i++) {
            //System.out.println(inputVehicleId + "==" + vehicleId[i]);
            if(inputVehicleId.equals(vehicleId[i])){
                after_tax_price = vehiclePrice[i] * 1.1;
                //System.out.println(after_tax_price);
                return after_tax_price;
            }
            else{
                after_tax_price = -2.0;
            }
        }

        return after_tax_price;
    }

    public static Double countTotalPrice(Integer inputPurchaseId) {
        Double total_price = purchaseTotalPrice[inputPurchaseId-1];
    
        total_price += detailAfterTaxPrice[detailCount];
        //System.out.println(total_price);
        return total_price;
    }
}
