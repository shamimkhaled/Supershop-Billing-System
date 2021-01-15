
package supershop;


public class Customer {
    private int customerId;
    private String customerName;
    private String productName;
    private double costPerUnit;
    private String qty;

    public Customer(int customerId, String customerName, String productName, double costPerUnit, String qty) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.productName = productName;
        this.costPerUnit = costPerUnit;
        this.qty = qty;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
    
    
    
    
    
    
}
