package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.Main;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class GeneralController extends Controller implements Initializable {

    private List<Object> labels;
    private List<Object> buttons;
    private String[] words;

    @FXML
    private Label labelSugg1, labelSugg2, labelSugg3, labelSugg4, labelSugg5, labelSugg6,mainLabel;

    @FXML
    private Button sugg1, sugg2, sugg3, sugg4, sugg5, sugg6;

    @FXML
    private Button com1,com2,com3,com4,com5;

    //@FXML
    //private TextField textFeild;

    @FXML
    private TextArea textFeild;

    @FXML
    private RadioButton radioButton;

    private String word="";






    public void initialize(URL location, ResourceBundle resources) {
        Stage s = Main.getStage();


        s.setOnCloseRequest(e->{
            e.consume();
            closeProgram();
        });

        viewModel = Main.getViewModel();

    }

    public void getLabelsAndButtons() {
        switch (viewModel.getMode()){
            case "general":
                labels = new ArrayList<Object>(viewModel.getGeneralSen().keySet());
                buttons = new ArrayList<Object>(viewModel.getGeneralSen().values());
                mainLabel.setText("איך הייתה הקייטנה עבורו באופן כללי? (איך הילד הגיע? איך הוא ביחס לקייטנה קודמת)");
                if(viewModel.getGeneral()!=null){
                    textFeild.setText(viewModel.getGeneral());
                }
                break;
            case "positive":
                labels = new ArrayList<Object>(viewModel.getPositiveSen().keySet());
                buttons = new ArrayList<Object>(viewModel.getPositiveSen().values());
                mainLabel.setText("אירועים חיוביים משמעותיים שקרו:");
                if(viewModel.getPositive()!=null){
                    textFeild.setText(viewModel.getPositive());
                }
                break;
            case "negative":
                labels = new ArrayList<Object>(viewModel.getNegativeSen().keySet());
                buttons = new ArrayList<Object>(viewModel.getNegativeSen().values());
                mainLabel.setText("אירועים שליליים/קשים משמעותיים שקרו:");
                if(viewModel.getNegative()!=null){
                    textFeild.setText(viewModel.getNegative());
                }
                break;
            case "enjoy":
                labels = new ArrayList<Object>(viewModel.getEnjoySen().keySet());
                buttons = new ArrayList<Object>(viewModel.getEnjoySen().values());
                mainLabel.setText("ממה הילד נהנה במהלך הקייטנה? אילו כוחות זיהיתי בו?");
                if(viewModel.getEnjoy()!=null){
                    textFeild.setText(viewModel.getEnjoy());
                }
                break;
            case "discipline":
                labels = new ArrayList<Object>(viewModel.getDisciplineSen().keySet());
                buttons = new ArrayList<Object>(viewModel.getDisciplineSen().values());
                mainLabel.setText("איך הילד נענה למשמעת שלי כמדריך, התנהגות ומשמעת? כיצד התמודדתי עם זה?");
                if(viewModel.getDiscipline()!=null){
                    textFeild.setText(viewModel.getDiscipline());
                }
                break;
            case "social":
                labels = new ArrayList<Object>(viewModel.getSocialSen().keySet());
                buttons = new ArrayList<Object>(viewModel.getSocialSen().values());
                mainLabel.setText("איך הילד השתלב מבחינה חברתית?");
                if(viewModel.getSocial()!=null){
                    textFeild.setText(viewModel.getSocial());
                }
                break;
        }


    }

    public void setLabelsAndButtons(){
        switch (labels.size()){
            case 0:
                setLabelsAndButtons0();
                break;
            case 1:
                setLabelsAndButtons1();
                break;
            case 2:
                setLabelsAndButtons2();
                break;
            case 3:
                setLabelsAndButtons3();
                break;
            case 4:
                setLabelsAndButtons4();
                break;
            case 5:
                setLabelsAndButtons5();
                break;
            case 6:
                setLabelsAndButtons6();
                break;
        }
    }



    private void setLabelsAndButtons0() {
        labelSugg1.setText("לא נמצאו דוחות קודמים לילד זה");
    }

    private void setLabelsAndButtons1() {
        labelSugg1.setVisible(true);
        sugg1.setVisible(true);
        labelSugg1.setText((String) labels.get(0));
        sugg1.setText((String) buttons.get(0));
    }

    private void setLabelsAndButtons2() {
        setLabelsAndButtons1();
        labelSugg2.setVisible(true);
        sugg2.setVisible(true);
        labelSugg2.setText((String) labels.get(1));
        sugg2.setText((String) buttons.get(1));
    }

    private void setLabelsAndButtons3() {
        setLabelsAndButtons2();
        labelSugg3.setVisible(true);
        sugg3.setVisible(true);
        labelSugg3.setText((String) labels.get(2));
        sugg3.setText((String) buttons.get(2));
    }

    private void setLabelsAndButtons4() {
        setLabelsAndButtons3();
        labelSugg4.setVisible(true);
        sugg4.setVisible(true);
        labelSugg4.setText((String) labels.get(3));
        sugg4.setText((String) buttons.get(3));
    }

    private void setLabelsAndButtons5() {
        setLabelsAndButtons4();
        labelSugg5.setVisible(true);
        sugg5.setVisible(true);
        labelSugg5.setText((String) labels.get(4));
        sugg5.setText((String) buttons.get(4));
    }
    private void setLabelsAndButtons6() {
        setLabelsAndButtons5();
        labelSugg6.setVisible(true);
        sugg6.setVisible(true);
        labelSugg6.setText((String) labels.get(5));
        sugg6.setText((String) buttons.get(5));
    }


    public void checkNextWord(KeyEvent keyEvent) throws FileNotFoundException {
        if (!keyEvent.getText().equals("")){
            if(keyEvent.getText().charAt(0)==32){
                searchForNextWord();
            }else{
                word=word+keyEvent.getText();
            }
        }else{
            if(word.length()>0){
                word = word.substring(0,word.length()-1);
            }
        }
    }

    private void searchForNextWord() throws FileNotFoundException {
        words = viewModel.nextWord(word);
        List<String> wordsAlloc = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(words[i]!=null){
                wordsAlloc.add(words[i]);
            }
        }
        commonWordAllocation(wordsAlloc);
        word="";
    }

    private void commonWordAllocation(List<String> words) {
        switch (words.size()){
            case 0:
                setCommon0();
                break;
            case 1:
                setCommon1();
                break;
            case 2:
                setCommon2();
                break;
            case 3:
                setCommon3();
                break;
            case 4:
                setCommon4();
                break;
            case 5:
                setCommon5();
                break;

    }
}

    private void setCommon0() {
        com1.setText("----");
        com2.setText("----");
        com3.setText("----");
        com4.setText("----");
        com5.setText("----");
    }

    private void setCommon1() {
        setCommon0();
        com1.setText(words[0]);
    }
    private void setCommon2() {
        setCommon1();
        com2.setText(words[1]);
    }
    private void setCommon3() {
        setCommon2();
        com3.setText(words[2]);
    }
    private void setCommon4() {
        setCommon3();
        com4.setText(words[3]);
    }
    private void setCommon5() {
        setCommon4();
        com5.setText(words[4]);
    }

    public void openSugg1(ActionEvent actionEvent) {

        ButtonType yes = new ButtonType("יאללה קניתי", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("לא היום כפרה", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,sugg1.getText() ,yes,no);

        alert.setTitle("מידע נוסף");
        alert.setHeaderText(labelSugg1.getText());
        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(no) == yes) {
            textFeild.setText(sugg1.getText());
            textFeild.setWrapText(true);
        }
    }

    public void openSugg2(ActionEvent actionEvent) {
        ButtonType yes = new ButtonType("יאללה קניתי", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("לא היום כפרה", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,sugg2.getText() ,yes,no);

        alert.setTitle("מידע נוסף");
        alert.setHeaderText(labelSugg2.getText());
        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(no) == yes) {
            textFeild.setText(sugg2.getText());
            textFeild.setWrapText(true);
        }
    }


    public void openSugg3(ActionEvent actionEvent) {
        ButtonType yes = new ButtonType("יאללה קניתי", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("לא היום כפרה", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,sugg3.getText() ,yes,no);

        alert.setTitle("מידע נוסף");
        alert.setHeaderText(labelSugg3.getText());
        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(no) == yes) {
            textFeild.setText(sugg3.getText());
            textFeild.setWrapText(true);
        }
    }

    public void openSugg4(ActionEvent actionEvent) {
        ButtonType yes = new ButtonType("יאללה קניתי", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("לא היום כפרה", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,sugg4.getText() ,yes,no);

        alert.setTitle("מידע נוסף");
        alert.setHeaderText(labelSugg4.getText());
        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(no) == yes) {
            textFeild.setText(sugg4.getText());
            textFeild.setWrapText(true);
        }
    }


    public void openSugg5(ActionEvent actionEvent) {
        ButtonType yes = new ButtonType("יאללה קניתי", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("לא היום כפרה", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,sugg5.getText() ,yes,no);

        alert.setTitle("מידע נוסף");
        alert.setHeaderText(labelSugg5.getText());
        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(no) == yes) {
            textFeild.setText(sugg5.getText());
            textFeild.setWrapText(true);
        }
    }



    public void openSugg6(ActionEvent actionEvent) {
        ButtonType yes = new ButtonType("יאללה קניתי", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("לא היום כפרה", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,sugg6.getText() ,yes,no);

        alert.setTitle("מידע נוסף");
        alert.setHeaderText(labelSugg6.getText());
        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(no) == yes) {
            textFeild.setText(sugg6.getText());
            textFeild.setWrapText(true);
        }
    }

    public void jumpToOtherPage(ActionEvent actionEvent) throws IOException {
        switch (viewModel.getMode()){
            case "general":
                viewModel.setGeneral(textFeild.getText());
                super.jumpToOtherPage("positive");
                break;
            case "positive":
                viewModel.setPositive(textFeild.getText());
                super.jumpToOtherPage("negative");
                break;
            case "negative":
                viewModel.setNegative(textFeild.getText());
                super.jumpToOtherPage("enjoy");
                break;
            case "enjoy":
                viewModel.setEnjoy(textFeild.getText());
                super.jumpToOtherPage("discipline");
                break;
            case "discipline":
                viewModel.setDiscipline(textFeild.getText());
                super.jumpToOtherPage("social");
                break;
            case "social":
                viewModel.setSocial(textFeild.getText());
                super.jumpToMore();
                break;
        }



    }

    public void backToLastPage(ActionEvent actionEvent) throws IOException {
        switch (viewModel.getMode()){
            case "general":
                viewModel.setGeneral(textFeild.getText());
                super.goToLanding();
                break;
            case "positive":
                viewModel.setPositive(textFeild.getText());
                super.jumpToOtherPage("general");
                break;
            case "negative":
                viewModel.setNegative(textFeild.getText());
                super.jumpToOtherPage("positive");
                break;
            case "enjoy":
                viewModel.setEnjoy(textFeild.getText());
                super.jumpToOtherPage("negative");
                break;
            case "discipline":
                viewModel.setDiscipline(textFeild.getText());
                super.jumpToOtherPage("enjoy");
                break;
            case "social":
                viewModel.setSocial(textFeild.getText());
                super.jumpToOtherPage("discipline");
                break;
        }
    }

    public void showCommonWords(ActionEvent actionEvent) {
        if (radioButton.isSelected()){
            com1.setVisible(true);
            com2.setVisible(true);
            com3.setVisible(true);
            com4.setVisible(true);
            com5.setVisible(true);
        } else{
            com1.setVisible(false);
            com2.setVisible(false);
            com3.setVisible(false);
            com4.setVisible(false);
            com5.setVisible(false);
        }
    }

    public void addCommonWord1(ActionEvent actionEvent) throws FileNotFoundException {
        textFeild.appendText(com1.getText()+" ");
        textFeild.setWrapText(true);
        word=com1.getText();
        searchForNextWord();
    }

    public void addCommonWord2(ActionEvent actionEvent) throws FileNotFoundException {
        textFeild.appendText(com2.getText()+" ");
        textFeild.setWrapText(true);
        word=com2.getText();
        searchForNextWord();
    }

    public void addCommonWord3(ActionEvent actionEvent) throws FileNotFoundException {
        textFeild.appendText(com3.getText()+" ");
        textFeild.setWrapText(true);
        word=com3.getText();
        searchForNextWord();
    }

    public void addCommonWord4(ActionEvent actionEvent) throws FileNotFoundException {
        textFeild.appendText(com4.getText()+" ");
        textFeild.setWrapText(true);
        word=com4.getText();
        searchForNextWord();
    }

    public void addCommonWord5(ActionEvent actionEvent) throws FileNotFoundException {
        textFeild.appendText(com5.getText()+" ");
        textFeild.setWrapText(true);

        word=com5.getText();
        searchForNextWord();
    }
}

