package CRBSystem;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage primarystage;
	private static VBox mainLayout;
	@Override
	public void start(Stage primaryStage) throws IOException {
		primarystage = primaryStage;
		primarystage.setTitle("BookIT - Classroom Booking Application IIIT-Delhi");
		showMainPage();
	}
	public static void showMainPage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/IntroPage.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setScene(scene);
		primarystage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
