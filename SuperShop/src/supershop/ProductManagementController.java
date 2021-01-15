
package supershop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;


public class ProductManagementController implements Initializable {

    @FXML
    private TextField productId;
    @FXML
    private TextField productName;
    @FXML
    private TextField costPerUnit;
    @FXML
    private TextField companyName;
    @FXML
    private TextField category;
    @FXML
    private TableColumn<Product, Integer> pidColumn;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, Double> costColumn;
    @FXML
    private TableColumn<Product, String> companyColumn;
    @FXML
    private TableColumn<Product, String> categoryColumn;
    @FXML
    private TableView<Product> productTableView;
    @FXML
    private Button addButton;
    @FXML
    private Button updateButton;

   
    static ObservableList <Product> productList = FXCollections.observableArrayList();
    @FXML
    private Label notificationLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //showProducts();
    }    
    
    
   
    
    @FXML
    private void addProduct(ActionEvent event) throws IOException {
        
        int pId = Integer.parseInt(productId.getText());
        String pName = productName.getText();
        double cost = Double.parseDouble(costPerUnit.getText());
        String company = companyName.getText();
        String Category = category.getText();

        if (event.getSource() == addButton) {
            if (productId.getText().equals("") || productName.getText().equals("") || costPerUnit.getText().equals("") || companyName.getText().equals("")
                    || category.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "you didn't enter text in textfield! ");
                //System.out.println("empty textfield");
                //return;
            } else {
                productTableView.setEditable(true);

                Product product = new Product(pId, pName, cost, company, Category);
                productList.add(product);

                productId.clear();
                productName.clear();
                costPerUnit.clear();
                companyName.clear();
                category.clear();
                
                //save in file
                File file = new File("product_report.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWrite = new FileWriter(file, true);
                fileWrite.write(pId + "#" + pName + " #" + cost + " #" + company + " #" + Category + "\n");
                fileWrite.close();

                //save product in table
                pidColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));
                productNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
                costColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("costPerUnit"));
                companyColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("companyName"));
                categoryColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
                productTableView.setItems(productList);

            }
        }

    }
   
    @FXML
    private void updateProduct(ActionEvent event) {
        //ObservableList <Product> list = FXCollections.observableArrayList();
        //list =  productTableView.getSelectionModel().getSelectedItems();
        
        int pId = Integer.parseInt(productId.getText());
        String pName = productName.getText();
        double cost = Double.parseDouble(costPerUnit.getText());
        String company = companyName.getText();
        String Category = category.getText();
        
        Product pList = productTableView.getSelectionModel().getSelectedItem();
        productId.setText(String.valueOf(pList.getProductId()));
        productName.setText(pList.getProductName());
        costPerUnit.setText(String.valueOf(pList.getCostPerUnit()));
        companyName.setText(pList.getCompanyName());
        category.setText(pList.getCategory());
        
        pidColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        costColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("costPerUnit"));
        companyColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("companyName"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
        productTableView.setItems(ProductManagementController.productList);
        
        
        
        
        
    }

    @FXML
    private void deleteProduct(ActionEvent event) {
        ObservableList <Product> selectedItem = FXCollections.observableArrayList();
        selectedItem = productTableView.getSelectionModel().getSelectedItems();
        ProductManagementController.productList.removeAll(selectedItem);
    }

    @FXML
    private void pIdFieldAction(KeyEvent event) {
        notificationLabel.setText("");
        String id = productId.getText();
        for(Product pid : productList){
            if(pid.getProductId() == Integer.parseInt(id)){
                JOptionPane.showMessageDialog(null, "this id already exist!");
                notificationLabel.setText("this id already exist");
                break;
            }
        }
    }
    
}
