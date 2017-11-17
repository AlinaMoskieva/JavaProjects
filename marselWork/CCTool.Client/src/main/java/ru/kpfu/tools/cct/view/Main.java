package ru.kpfu.tools.cct.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;


    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Tasks");

        initRootLayout();

        showTasksView();
    }

    private void showTasksView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("TasksView.fxml"));
            AnchorPane personOverview = (AnchorPane)loader.load();
            rootLayout.setCenter(personOverview);

            TasksSimpleController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }


    private void initRootLayout() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("RootLayout.fxml"));
        try {
            rootLayout = (BorderPane)loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}