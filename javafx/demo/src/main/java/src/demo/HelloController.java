package src.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

public class HelloController {


    private Image myimageON= new Image(getClass().getResourceAsStream("41774.jpg"));
    private Image myimageOFF= new Image(getClass().getResourceAsStream("41849.jpg"));

    @FXML
    private ImageView image;

    @FXML
    private CheckBox button;


    @FXML
    protected void buttonclicked() {

        if (button.isSelected()){
            image.setImage(myimageON);
        }else{
            image.setImage(myimageOFF);
        }
    }


    @FXML
    protected void mouseEntered(MouseEvent e) {
        image.setImage(myimageON);
    }

    @FXML
    protected void mouseExited(MouseEvent e) {
        image.setImage(myimageOFF);
    }

}