package sample;

import Model.MyModel;
import View.LandingController;
import ViewModel.MyViewModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage primaryStage;
    private static MyViewModel viewModel;

    public static MyViewModel getViewModel(){return viewModel;}


    public static void setStage(Stage stage) {
        Main.primaryStage = stage;
    }

    public static Stage getStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        MyModel model = new MyModel();
        viewModel = new MyViewModel(model);
        setStage(primaryStage);
        FXMLLoader fxmlLoader = new FXMLLoader();


        primaryStage.setTitle("OR CAMP DOCS 2019");
        Parent root = fxmlLoader.load(getClass().getResource("/View/Landing.fxml").openStream());
        Scene scene = new Scene(root, 758, 454);
        scene.getStylesheets().add(getClass().getResource("/View/Landing.css").toExternalForm());
        primaryStage.setScene(scene);
        LandingController lc = fxmlLoader.getController();

        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
