package View;

import ViewModel.MyViewModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;

public class Controller {

    MyViewModel viewModel;

    // No constructor because it is abstract class

    /**
     * set the viewModel
     * @param viewModel
     */
    public void setViewModel(MyViewModel viewModel) {
        this.viewModel = viewModel;
    }

    /**
     *  close the program with confirming
     *  close the servers
     */
    protected void closeProgram() {
        viewModel = Main.getViewModel();
        Stage s = Main.getStage();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "אתה בטוח שאתה רוצה לצאת?", ButtonType.YES, ButtonType.NO);
        alert.setHeaderText("תגיד לי השתגעת??");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            s.close();
        }
    }




    protected void jumpToOtherPage(String mode) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        viewModel.setMode(mode);
        Stage s = Main.getStage();
        String url = "/View/general.fxml";
        Parent root = fxmlLoader.load(getClass().getResource(url).openStream());
        Scene scene = new Scene(root,900,550);
        scene.getStylesheets().add(getClass().getResource("/View/General.css").toExternalForm());
        s.setScene(scene);
        GeneralController gc = fxmlLoader.getController();
        viewModel=Main.getViewModel();
        gc.setViewModel(viewModel);

        gc.getLabelsAndButtons();
        gc.setLabelsAndButtons();

        Main.setStage(s);
        s.show();
    }

    protected void goToLanding() throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        Stage s = Main.getStage();
        Parent root = fxmlLoader.load(getClass().getResource("/View/Landing.fxml").openStream());
        Scene scene = new Scene(root,900,550);
        scene.getStylesheets().add(getClass().getResource("/View/Landing.css").toExternalForm());
        s.setScene(scene);
        LandingController lc = fxmlLoader.getController();
        viewModel=Main.getViewModel();
        lc.setViewModel(viewModel);

        Main.setStage(s);
        s.show();
    }

    protected void jumpToMore() throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        Stage s = Main.getStage();
        Parent root = fxmlLoader.load(getClass().getResource("/View/more.fxml").openStream());
        Scene scene = new Scene(root,900,550);
        scene.getStylesheets().add(getClass().getResource("/View/General.css").toExternalForm());
        s.setScene(scene);
        moreController mc = fxmlLoader.getController();
        viewModel=Main.getViewModel();
        mc.setViewModel(viewModel);

        Main.setStage(s);
        s.show();
    }

    protected void jumpToSummary() throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        Stage s = Main.getStage();
        Parent root = fxmlLoader.load(getClass().getResource("/View/summary.fxml").openStream());
        Scene scene = new Scene(root,1300,700);
        scene.getStylesheets().add(getClass().getResource("/View/General.css").toExternalForm());
        s.setScene(scene);
        summaryController sc = fxmlLoader.getController();
        viewModel=Main.getViewModel();
        sc.setViewModel(viewModel);

        Main.setStage(s);
        s.show();
    }
}
