package tugaske4;

import java.util.ArrayList;
import tugaske4.repo.PurchaseInterface;

public class PurchaseDetail implements PurchaseInterface{
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Purchase> purchases;
    VehicleManager vehicleManage;

    private String vehicleId;
    private Double afterTaxPrice;
    private String inputPurchaseId;  

    public PurchaseDetail(String vehicleId, VehicleManager vehicleManage, String inputPurchaseId) {
        this.inputPurchaseId = inputPurchaseId;
        this.vehicleManage = vehicleManage;
        this.vehicles = vehicleManage.getVehicles(); 
        this.vehicleId = vehicleId;
        this.afterTaxPrice = getAfterTaxPrice(vehicleId);
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public Double getAfterTaxPrice() {
        return afterTaxPrice;
    }

    public Double getAfterTaxPrice(String inputVehicleId) {
        Double after_tax_price = 0.0;
        for (Vehicle v : vehicles) {
            if(v.getId().equals(inputVehicleId)){
                after_tax_price = v.getPrice() * 1.1;
                return after_tax_price;
            }
            else{
                after_tax_price = -2.0;
            }
        }
        return after_tax_price;
    }

    @Override
    public String toString() {
        return "{" +
            "vehicleId='" + getVehicleId() + "'" +
            ", afterTaxPrice='" + String.format("%.2f", getAfterTaxPrice()) + "'" +
            ", inputPurchaseId='" + inputPurchaseId + "'" +
            "}";
    }

}
