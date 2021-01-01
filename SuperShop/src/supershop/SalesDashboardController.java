
package supershop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class SalesDashboardController implements Initializable {

    private TextField customerId;
    private TextField customerName;
    @FXML
    private VBox salesContent;
    @FXML
    private TextField tfCustomerId;
    @FXML
    private TextField tfCustomerName;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try{      
            String custId = tfCustomerId.getText();
            String custName = tfCustomerName.getText();
            if(custId.equals("") && custName.equals("")){
                System.out.println("you didn't enter  data in textfield");
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }    

    @FXML
    private void BillButtonAction(ActionEvent event) throws IOException {
      
        Parent root = FXMLLoader.load(getClass().getResource("BillingReport.fxml"));
        salesContent.getChildren().setAll(root);
        
    }
    
}
