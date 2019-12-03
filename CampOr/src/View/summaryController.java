package View;

import extractToWord.wordDuc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import sample.Main;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class summaryController extends Controller implements Initializable {

    @FXML
    private TextArea generalText,positiveText,negativeText,enjoyText,disText,socialText;

    @FXML
    private TextField healthText,foodText,hygineText,eqText,nightText,drugsText,summaryText;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        viewModel = Main.getViewModel();

        if (viewModel.getGeneral()!=null){
            generalText.setText(viewModel.getGeneral());
            generalText.setWrapText(true);

        }
        if (viewModel.getPositive()!=null){
            positiveText.setText(viewModel.getPositive());
            positiveText.setWrapText(true);
        }
        if (viewModel.getNegative()!=null){
            negativeText.setText(viewModel.getNegative());
            negativeText.setWrapText(true);
        }
        if (viewModel.getEnjoy()!=null){
            enjoyText.setText(viewModel.getEnjoy());
            enjoyText.setWrapText(true);
        }
        if (viewModel.getDiscipline()!=null){
            disText.setText(viewModel.getDiscipline());
            disText.setWrapText(true);
        }
        if (viewModel.getSocial()!=null){
            socialText.setText(viewModel.getSocial());
            socialText.setWrapText(true);
        }
        if (viewModel.getNight()!=null){
            nightText.setText(viewModel.getNight());
        }
        if (viewModel.getEquipment()!=null){
            eqText.setText(viewModel.getEquipment());
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


    public void submitTheForm(ActionEvent actionEvent) throws IOException {
        setter();
        wordDuc wordDuc = new wordDuc(viewModel);
        wordDuc.createWordDuc();
        super.goToLanding();
    }

    public void backToMore(ActionEvent actionEvent) throws IOException {
        setter();
        super.jumpToMore();
    }

    private void setter (){
        viewModel.setGeneral(generalText.getText());
        viewModel.setPositive(positiveText.getText());
        viewModel.setNight(negativeText.getText());
        viewModel.setEnjoy(enjoyText.getText());
        viewModel.setDiscipline(disText.getText());
        viewModel.setSocial(socialText.getText());
        viewModel.setNight(nightText.getText());
        viewModel.setEquipment(eqText.getText());
        viewModel.setDrugs(drugsText.getText());
        viewModel.setHealth(healthText.getText());
        viewModel.setHygine(hygineText.getText());
        viewModel.setFood(foodText.getText());
        viewModel.setSummary(summaryText.getText());
    }
}
