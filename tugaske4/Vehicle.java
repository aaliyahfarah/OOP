package tugaske4;

public class Vehicle extends BaseModel{
    //private String id;
    private String type;
    private Double price; 

    public Vehicle(String id, String type, Double price) {
        super(id);
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", type='" + getType() + "'" +
            ", price='" + String.format("%.2f", getPrice()) + "'" +
            "}";
    }
}