
package supershop;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static supershop.ProductManagementController.productList;


public class ProductReportController implements Initializable {

    @FXML
    private TableView<Product> productTableView;
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


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //ProductManagementController.productList.clear();

        File files = new File("product_report.txt");
        if (files.exists()) {
            try {
                files.createNewFile();
                Scanner scan = new Scanner(files);
                while (scan.hasNext()) {
                    String str = scan.nextLine();
                    String arr[] = str.split("#");

                    Product products = new Product(Integer.parseInt(arr[0]), arr[1], Double.parseDouble(arr[2]), arr[3] , arr[4]);
                    ProductManagementController.productList.add(products);
                }
            } catch (IOException ex) {
                Logger.getLogger(ProductReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
        productTableView.setEditable(true);

        
        
        pidColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        costColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("costPerUnit"));
        companyColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("companyName"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
        productTableView.setItems(ProductManagementController.productList);
    }    

    @FXML
    private void deleteButton(ActionEvent event) {
         ObservableList <Product> selectedItem = FXCollections.observableArrayList();
        selectedItem = productTableView.getSelectionModel().getSelectedItems();
        ProductManagementController.productList.removeAll(selectedItem);
    }
    
}
