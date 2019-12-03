package View;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LandingController extends Controller implements Initializable {
    public void shaharPressed(ActionEvent actionEvent) throws IOException {
        viewModel.setKid("Shahar");
        viewModel.setKidHebrow("שחר");
        viewModel.createSenDataBase("Shahar");

        jumpToOtherPage("general");
    }

    public void davidPressed(ActionEvent actionEvent) throws IOException {
        viewModel.setKid("david");
        viewModel.setKidHebrow("דוד");
        viewModel.createSenDataBase("david");
        jumpToOtherPage("general");
    }

    public void liamPressed(ActionEvent actionEvent) throws IOException {
        viewModel.setKid("liam");
        viewModel.setKidHebrow("ליאם");
        viewModel.createSenDataBase("liam");
        jumpToOtherPage("general");
    }



    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewModel = Main.getViewModel();
    }

    public void refaelPressed(ActionEvent actionEvent) throws IOException {
        viewModel.setKid("refael");
        viewModel.setKidHebrow("רפאל");
        viewModel.createSenDataBase("refael");
        jumpToOtherPage("general");
    }

    public void osherPressed(ActionEvent actionEvent) throws IOException {
        viewModel.setKid("osher");
        viewModel.setKidHebrow("אושר");
        viewModel.createSenDataBase("osher");
        jumpToOtherPage("general");
    }

    public void ilaiPressed(ActionEvent actionEvent) throws IOException {
        viewModel.setKid("ilai");
        viewModel.setKidHebrow("הילאי");
        viewModel.createSenDataBase("ilai");
        jumpToOtherPage("general");
    }

    public void lironPressed(ActionEvent actionEvent) throws IOException {
        viewModel.setKid("liron");
        viewModel.setKidHebrow("לירון");
        viewModel.createSenDataBase("liron");
        jumpToOtherPage("general");
    }

    public void dannyPressed(ActionEvent actionEvent) throws IOException {
        viewModel.setKid("danny");
        viewModel.setKidHebrow("דני");
        viewModel.createSenDataBase("danny");
        jumpToOtherPage("general");
    }
}
