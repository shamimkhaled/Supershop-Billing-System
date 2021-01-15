package supershop;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import static supershop.ProductManagementController.productList;

public class SalesDashboardController implements Initializable {

    @FXML
    private TextField customerId;
    @FXML
    private TextField customerName;
    private ComboBox<String> productCombo;
    @FXML
    private TableView<Customer> salesTableView;
    @FXML
    private TableColumn<Customer, Integer> idColumn;
    @FXML
    private TableColumn<Customer, String> customerNameColumn;
    @FXML
    private TableColumn<Customer, String> productNameColumn;
    @FXML
    private TableColumn<Customer, Double> costColumn;
    @FXML
    private TableColumn<Customer, String> quantityColumn;
    @FXML
    private Label totalCost;
    ObservableList<String> option = FXCollections.observableArrayList();
    PreparedStatement statement;
    ResultSet result;
    Connection connection;
    @FXML
    private TextField quantity;
    @FXML
    private TextField costPerUnit;
    @FXML
    private TextField productName;

    static ObservableList<Customer> listItem = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //productCombo.setMaxHeight(30);

        /* databaseConnection();
        
        try {
            productComboList();
        } catch (SQLException ex) {
            Logger.getLogger(SalesDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    /*public Connection databaseConnection(){
           Connection connect;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/supershop", "root", "");
            return connect;
        }catch (Exception ex) {
            System.out.println("Error "+ex.getMessage());
            return null;
        }
        
        
    }*/
 /*public void productComboList() throws SQLException{
        productCombo = new ComboBox <> (option);

        try{
            String productQuery = "select productName from productlist";
            statement = connection.prepareStatement(productQuery);
            result = statement.executeQuery();
            
            while(result.next()){
                option.add(result.getString("productName"));
            }
            productCombo.setItems(option);
            //statement.close();
            //result.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }*/
    @FXML
    private void startBillingAction(ActionEvent event) {

        int cId = Integer.parseInt(customerId.getText());
        String cName = customerName.getText();
        String pName = productName.getText();
        double cost = Double.parseDouble(costPerUnit.getText());

        String qty = quantity.getText();

        if (customerId.equals("") || customerName.equals("") || productName.equals("") || costPerUnit.equals("")) {
            JOptionPane.showMessageDialog(null, "empty textfield");
        }

        Customer cust = new Customer(cId, cName, pName, cost, qty);
        listItem.add(cust);

        customerId.clear();
        customerName.clear();
        productName.clear();
        quantity.clear();

        idColumn.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("customerId"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerName"));

        productNameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("productName"));
        costColumn.setCellValueFactory(new PropertyValueFactory<Customer, Double>("costPerUnit"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("quantity"));
        salesTableView.setItems(SalesDashboardController.listItem);

    }

    @FXML
    private void billRecieptAction(ActionEvent event) {
    }

    @FXML
    private void deleteButtonAction(ActionEvent event) {
        ObservableList<Customer> selectedItem = FXCollections.observableArrayList();
        selectedItem = salesTableView.getSelectionModel().getSelectedItems();
        SalesDashboardController.listItem.removeAll(selectedItem);
    }

    @FXML
    private void totalCostAction(MouseEvent event) {
        ObservableList<Customer> selectedItem = FXCollections.observableArrayList();

        String qty = quantity.getText();
        double cost = Double.parseDouble(costPerUnit.getText());

        if (event.getSource() == selectedItem) {
            double total = cost * Double.parseDouble(qty);
            totalCost.setText(String.valueOf(total));
        }

    }

}
