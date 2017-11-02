package CRBSystem;

import java.io.IOException;

import Backend.Admin;
import Backend.Faculty;
import Backend.Student;
import Backend.User;
import CRBSystem.Admin_Intro.Admin_IntroController;
import CRBSystem.FacultyIntro.Faculty_IntroController;
import CRBSystem.student_intro.Student_IntroController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage primarystage;
	private static VBox mainLayout;
	private static User curr = null;
	@Override
	public void start(Stage primaryStage) throws IOException {
		primarystage = primaryStage;
		primarystage.setTitle("BookIT - Classroom Booking Application");
		showMainPage();
	}
	public static void showMainPage() throws IOException {
		setCurr(null);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/IntroPage.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setScene(scene);
		primarystage.show();
	}
	
	public static void showLogin() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("login/LoginPage.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("Login");
		primarystage.setScene(scene);
		primarystage.show();
	}
	public static void showStudentIntro() throws IOException  {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("student_intro/StudentIntro.fxml"));
		mainLayout = loader.load();
		//curr = t;
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("Student DashBoard");
		primarystage.setScene(scene);
		Student_IntroController controller = loader.<Student_IntroController>getController();
		controller.setScreen(getCurr());
		primarystage.show();
	}

	public static void showSignUp() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("signup/SignUpPage.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("SignUp");
		primarystage.setScene(scene);
		primarystage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static User getCurr() {
		//System.out.println(curr.getName());
		return curr;
	}
	
	public static void gotoSignUp_2() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("signup/SignUp_2.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("Request sent to Admin");
		primarystage.setScene(scene);
		primarystage.show();
	}
	
	public static void showAdminIntro() throws IOException  {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Admin_Intro/Admin_Intro.fxml"));
		mainLayout = loader.load();
		//setCurr(t);
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("Admin DashBoard");
		primarystage.setScene(scene);
		Admin_IntroController controller = loader.<Admin_IntroController>getController();
		controller.setScreen(getCurr());
		primarystage.show();
	}
	public static void showFacultyIntro() throws IOException  {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("FacultyIntro/FacultyIntro.fxml"));
		mainLayout = loader.load();
		//setCurr(t);
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("Faculty DashBoard");
		primarystage.setScene(scene);
		Faculty_IntroController controller = loader.<Faculty_IntroController>getController();
		controller.setScreen(getCurr());
		primarystage.show();
	}
	public static void setCurr(User curr) {
		Main.curr = curr;
	}
	
}
