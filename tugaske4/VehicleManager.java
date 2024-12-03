package tugaske4;

import java.util.ArrayList;
import tugaske4.repo.VehicleInterface;

public class VehicleManager implements VehicleInterface{
    private ArrayList<Vehicle> vehicles;

    public VehicleManager() {
        this.vehicles = new ArrayList<>();
    }
    
    // add vehicle
    @Override
    public void addInterface(Vehicle vehicle) {
        vehicles.add(vehicle);
        //System.out.println("\n"+vehicle + " ditambahkan");
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    //find vehicle
    public Boolean findVehicle(String inputId) {
        for (Vehicle v : vehicles) {
            if (v.getId().equals(inputId)) {
                return true;
            }
        }
        return false;
    }

    //find vehicle
    @Override
    public Boolean deleteVehicle(String inputId) {
        for (Vehicle v : vehicles) {
            if (v.getId().equals(inputId)) {
                vehicles.remove(v);
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayInterface(){
        System.out.println("\n-----     Produk     -----");
        for (Vehicle v : vehicles) {
            if(!v.getId().equals("-2")){
                System.out.println(v);
            }
        }
    }
}