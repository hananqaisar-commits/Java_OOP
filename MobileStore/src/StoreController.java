
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class StoreController {

    @FXML
    private Label storeNameLabel;
    @FXML
    private Label storeLocationLabel;
    @FXML
    private Label storeCountLabel;
    @FXML
    private TableView<Phone> phoneTable;
    @FXML
    private TableColumn<Phone, String> brandCol;
    @FXML
    private TableColumn<Phone, String> modelCol;
    @FXML
    private TableColumn<Phone, Double> priceCol;
    @FXML
    private TableColumn<Phone, String> batteryCol;

    private Store currentStore;

    public void setStore(Store store) {
        this.currentStore = store;
        loadStoreData();
    }

    private void loadStoreData() {
        storeNameLabel.setText(currentStore.getName());
        storeLocationLabel.setText("Location: " + currentStore.getLocation());
        storeCountLabel.setText("Total Phones: " + currentStore.count);

        brandCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getBrand()));
        modelCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getModel()));
        priceCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrice()).asObject());
        batteryCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getBattery().toString()));

        ObservableList<Phone> list = FXCollections.observableArrayList(currentStore.phones);
        phoneTable.setItems(list);
    }

    @FXML
    private void handleAddPhone(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("resources/addphone.fxml"));
        Stage stage = (Stage) phoneTable.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        AddPhoneController controller = loader.getController();
        controller.setStore(currentStore);
        stage.setTitle("Add Phone");
        stage.show();
    }

    @FXML
    private void handleShowDetail(ActionEvent e) {
        Phone selected = phoneTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Phone Detail");
            alert.setHeaderText(selected.getBrand() + " " + selected.getModel());
            alert.setContentText(
                    "Price: " + selected.getPrice() +
                            "\nBattery: " + selected.getBattery().toString());
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please select a phone first!");
            alert.show();
        }
    }

    @FXML
    private void handleBack(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("resources/main.fxml"));
        Stage stage = (Stage) phoneTable.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Mobile Store");
        stage.show();
    }
}