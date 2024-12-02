package tugaske4;

class Vehicle {
    private String id;
    private String type;
    private Double price;

    private static Integer count = 0;
    private static String[] vehicleId = new String[50];
    private static String[] vehicleType = new String[50];
    private static Double[] vehiclePrice = new Double[50];


    public Vehicle(String id, String type, Double price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }
   
    public static void addVehicle(String id, String type, double price) {
        vehicleId[count] = id;
        vehicleType[count] = type;
        vehiclePrice[count] = price;
        count++;
    }

    public static void deleteVehicle(String id) {
        for (int i = 0; i < count; i++) {
            if(id.equals(vehicleId[i])){
                vehicleId[i] = "-2";
                vehicleType[i] = "-2";
                vehiclePrice[i] = -2d;
            }
        }
    }

    public static void displayVehicle(){
        System.out.println("-----     Produk     -----");

        
        for (int i = 0; i < count; i++) {
            if(!vehicleId[i].equals("-2")){
                System.out.println("Vehicle ID: " + vehicleId[i] +
                               ", Type: " + vehicleType[i] +
                               ", Price: " + "Rp" +String.format("%.2f", vehiclePrice[i])) ;
            }
        }
    }

}