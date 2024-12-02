package tugaske4;

public abstract class Purchase {
    protected Integer purchaseId;
    protected Integer purchaseCustomerId;
    protected String purchaseDate;
    protected String purchasePaymentMethod;
    protected Double purchaseTotalPrice;

    public Purchase(Integer purchaseId, Integer purchaseCustomerId, String purchaseDate, String purchasePaymentMethod, Double purchaseTotalPrice) {
        this.purchaseId = purchaseId;
        this.purchaseCustomerId = purchaseCustomerId;
        this.purchaseDate = purchaseDate;
        this.purchasePaymentMethod = purchasePaymentMethod;
        this.purchaseTotalPrice = purchaseTotalPrice;
    }


    public Integer getPurchaseId() {
        return this.purchaseId;
    }

    public Integer getPurchaseCustomerId() {
        return this.purchaseCustomerId;
    }

    public String getPurchaseDate() {
        return this.purchaseDate;
    }

    public String getPurchasePaymentMethod() {
        return this.purchasePaymentMethod;
    }

    public Double getPurchaseTotalPrice() {
        return this.purchaseTotalPrice;
    }

    public void updateTotalPrice(Double additionalPrice) {
        this.purchaseTotalPrice += additionalPrice;
    }
}