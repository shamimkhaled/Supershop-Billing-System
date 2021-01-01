
package supershop;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class ProductManagementController implements Initializable {

    @FXML
    private TableView<Product> productTableView;
    @FXML
    private TableColumn<Product, Integer> idColumn;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, Double> costColumn;
    @FXML
    private TableColumn<Product, String> companyColumn;
    @FXML
    private TableColumn<Product, String> categoryColumn;
    @FXML
    private TextField productId;
    @FXML
    private TextField productName;
    @FXML
    private TextField costPerUnit;
    @FXML
    private TextField category;
    @FXML
    private TextField companyName;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    static ObservableList <Product> productList = FXCollections.observableArrayList();

    @FXML
    private void saveProductAction(ActionEvent event) {
        //save product Button Action
        int pId = Integer.parseInt(productId.getText());
        String pName = productName.getText();
        double cost = Double.parseDouble(costPerUnit.getText());
        String cName = companyName.getText();
        String Category = category.getText();
        
        if(productId.equals("") && productName.equals("") && costPerUnit.equals("") && companyName.equals("") 
           && category.equals("")) {
            return;
        }
        
        Product product = new Product (pId, pName, cost, cName, Category);
        productList.add(product);
        
        productId.clear();
        productName.clear();
        costPerUnit.clear();
        companyName.clear();
        category.clear();
        
        //save product in table
        idColumn.setCellValueFactory(new PropertyValueFactory <Product, Integer> ("productId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory <Product, String> ("productName"));
        costColumn.setCellValueFactory(new PropertyValueFactory <Product, Double> ("costPerUnit"));
        companyColumn.setCellValueFactory(new PropertyValueFactory <Product, String> ("companyName"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory <Product, String> ("category"));
        productTableView.setItems(productList);
        
        

    }

    @FXML
    private void cancelButtonAction(ActionEvent event) {
    }
    
}
