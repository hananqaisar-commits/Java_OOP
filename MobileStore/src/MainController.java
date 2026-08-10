
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class MainController {

    @FXML
    private Label totalLabel;

    @FXML
    public void initialize() {
        totalLabel.setText("Total Mobiles in all stores: "
                + Store.getCountMobile());
    }

    @FXML
    private void handleMobileOyee(ActionEvent e) throws Exception {
        loadStore(DataManager.MobileOyee, e);
    }

    @FXML
    private void handleMobileWorld(ActionEvent e) throws Exception {
        loadStore(DataManager.MobileWorld, e);
    }

    private void loadStore(Store store, ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("resources/store.fxml"));
        Stage stage = (Stage) totalLabel.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        StoreController controller = loader.getController();
        controller.setStore(store);
        stage.setTitle(store.getName());
        stage.show();
    }
}