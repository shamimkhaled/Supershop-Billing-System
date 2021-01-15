
package supershop;

public class Product {
    private int productId;
    private String productName;
    private double costPerUnit;
    private String companyName;
    private String Category;

    public Product(int productId, String productName, double costPerUnit, String companyName, String Category) {
        this.productId = productId;
        this.productName = productName;
        this.costPerUnit = costPerUnit;
        this.companyName = companyName;
        this.Category = Category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }
    
    

}
