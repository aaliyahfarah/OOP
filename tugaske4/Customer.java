package tugaske4;

public class Customer{
    private Integer id;
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;

    public static Integer customerCount = 1;
   
    public Customer(String firstName, String lastName, String telephone, String address) {
        this.id = customerCount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" + 
            " firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }    
}