package tugaske4;

public abstract class BaseModel {
    private String id;

    public BaseModel(String id){
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
