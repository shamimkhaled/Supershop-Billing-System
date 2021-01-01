
package supershop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SuperShopController implements Initializable {

    @FXML
    private VBox mainCOntent;
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void addProduct(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProductManagement.fxml"));
        Scene scene = new Scene (root);
        
        Stage stage = new Stage ();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void productReport(ActionEvent event) {
    }

    @FXML
    private void addSells(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SalesDashboard.fxml"));
        Scene scene = new Scene (root);
        
        Stage stage = new Stage ();
        stage.setScene(scene);
        stage.show();
    }
    
}
