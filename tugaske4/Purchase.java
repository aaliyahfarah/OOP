package tugaske4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Purchase extends BaseModel{
    protected String purchaseId;
    protected Integer customerId;
    protected String paymentMethod;
    protected Double totalPrice;
    protected String date;
    private ArrayList<PurchaseDetail> purchaseDetails;

    public Purchase(Integer customerId, String paymentMethod) {
        super(GenerateId());
        this.customerId = customerId;
        this.paymentMethod = paymentMethod;
        this.purchaseDetails = new ArrayList<>();
        this.totalPrice = 0.0;
        this.date = setDate();
    }
    
    public static String GenerateId(){
        String numberPart = String.format("%04d", 100 + (int)(Math.random() * 9900));
        return "P" + numberPart;
    }    

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDate() {
        return this.date;
    }

    private String setDate() {
        // Get current date in "yyyy-MM-dd" format
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDate.format(formatter);
    }

    public void addPurchaseDetail(PurchaseDetail detail) {
        purchaseDetails.add(detail);
        totalPrice += detail.getAfterTaxPrice();
    }

    public Boolean checkPurchaseDetail(String vehicleId, VehicleManager vehicleManage) {
        if(vehicleManage.findVehicle(vehicleId) == true){
            String inputId = getId();
            PurchaseDetail detail = new PurchaseDetail(vehicleId, vehicleManage, inputId);  
            addPurchaseDetail(detail);  
            //delete vehicle
            vehicleManage.deleteVehicle(vehicleId);
            //System.out.println("VehicleId " + vehicleId + " sudah dihapus");
            return true;
        }
        else{
            System.out.println("VehicleID " + vehicleId + " tidak ditemukan");
            return false;
        }  
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", customerId='" + getCustomerId() + "'" +
            ", date='" + getDate() + "'" +
            ", paymentMethod='" + getPaymentMethod() + "'" +
            ", totalPrice='" + String.format("%.2f",getTotalPrice()) + "'" +
            "}";
    }

    public void displayPurchaseDetails() {
        if (purchaseDetails.isEmpty()) {
            System.out.println("\nPurchase Failed");
        } else {
            System.out.println("\n-----     Invoice     -----");
            System.out.println("Purchase ID: " + getId());
            System.out.println("Customer ID: " + customerId);
            System.out.println("Date: " + date);
            System.out.println("Total Price: " + String.format("%.2f",getTotalPrice()));
            System.out.println("Purchase Details:");

            for (PurchaseDetail detail : purchaseDetails) {
                System.out.println(detail.toString());
            }
            System.out.println("\n");
        }
    }    
}