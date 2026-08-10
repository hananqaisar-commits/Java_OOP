
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class AddPhoneController {

    @FXML
    private TextField brandField;
    @FXML
    private TextField modelField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField batteryTypeField;
    @FXML
    private TextField batteryCapacityField;
    @FXML
    private Label messageLabel;

    private Store currentStore;

    public void setStore(Store store) {
        this.currentStore = store;
    }

    @FXML
    private void handleAdd(ActionEvent e) throws Exception {
        // validate fields
        if (brandField.getText().isEmpty() ||
                modelField.getText().isEmpty() ||
                priceField.getText().isEmpty()) {
            messageLabel.setText("Please fill all fields!");
            return;
        }

        try {
            String brand = brandField.getText();
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            String batteryType = batteryTypeField.getText().isEmpty()
                    ? "Li-ion"
                    : batteryTypeField.getText();
            int batteryCapacity = batteryCapacityField.getText().isEmpty()
                    ? 4000
                    : Integer.parseInt(batteryCapacityField.getText());

            Phone phone = new Phone(brand, model, price);
            phone.getBattery().setType(batteryType);
            phone.getBattery().setCapacity(batteryCapacity);

            currentStore.addPhone(phone);
            goBack(e);

        } catch (NumberFormatException ex) {
            messageLabel.setText("Invalid price or capacity!");
        }
    }

    @FXML
    private void handleCancel(ActionEvent e) throws Exception {
        goBack(e);
    }

    private void goBack(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("resources/store.fxml"));
        Stage stage = (Stage) brandField.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        StoreController controller = loader.getController();
        controller.setStore(currentStore);
        stage.setTitle(currentStore.getName());
        stage.show();
    }
}