package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class moreController extends  Controller implements Initializable {


    @FXML
    private  TextField nigthText;

    @FXML
    private  TextField equipmentText;

    @FXML
    private  TextField drugsText;

    @FXML
    private  TextField healthText;
    @FXML
    private  TextField hygineText;

    @FXML
    private  TextField foodText;

    @FXML
    private  TextField summaryText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewModel = Main.getViewModel();

        if (viewModel.getNight()!=null){
            nigthText.setText(viewModel.getNight());
        }
        if (viewModel.getEquipment()!=null){
            equipmentText.setText(viewModel.getEquipment());
        }
        if (viewModel.getDrugs()!=null){
            drugsText.setText(viewModel.getDrugs());
        }
        if (viewModel.getHealth()!=null){
            healthText.setText(viewModel.getHealth());
        }
        if (viewModel.getHygine()!=null){
            hygineText.setText(viewModel.getHygine());
        }
        if (viewModel.getFood()!=null){
            foodText.setText(viewModel.getFood());
        }
        if (viewModel.getSummary()!=null){
            summaryText.setText(viewModel.getSummary());
        }
    }


    public void submitAndGoToSummary(ActionEvent actionEvent) throws IOException {

        setter();
        super.jumpToSummary();
    }

    public void backToSocial(ActionEvent actionEvent) throws IOException {
        setter();
        super.jumpToOtherPage("social");

    }

    private void setter (){
        viewModel.setNight(nigthText.getText());
        viewModel.setEquipment(equipmentText.getText());
        viewModel.setDrugs(drugsText.getText());
        viewModel.setHealth(healthText.getText());
        viewModel.setHygine(hygineText.getText());
        viewModel.setFood(foodText.getText());
        viewModel.setSummary(summaryText.getText());
    }
}
