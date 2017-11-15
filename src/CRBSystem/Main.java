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
	
	public static void showTimeTable() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("viewTable/TimeTable.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("TimeTable");
		primarystage.setScene(scene);
		primarystage.show();
	}
	public static void showPrereq() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("student_intro/ViewPrereq.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("View Prerequisites");
		primarystage.setScene(scene);
		primarystage.show();
	}
	public static void showSignUpRequests() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Admin_Intro/Respond_signup.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("Signup Requests");
		primarystage.setScene(scene);
		primarystage.show();
	}
	public static void showSearchCourses() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("student_intro/Search_Courses.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("TimeTable");
		primarystage.setScene(scene);
		primarystage.show();
	}
	public static void book_cancel() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("student_intro/Book_Cancel.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("Book/Cancel Bookings");
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
	public static void showAvailability() throws IOException  {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("ViewRooms/CheckAvail.fxml"));
		mainLayout = loader.load();
		//setCurr(t);
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("Check Availability");
		primarystage.setScene(scene);
		primarystage.show();
	}
	public static void setCurr(User curr) {
		Main.curr = curr;
	}
	public static void showFacBooking() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("FacultyIntro/ViewBookings"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("Booking Requests");
		primarystage.setScene(scene);
		primarystage.show();
	}
	
	public static void showRequests() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Admin_Intro/Respond.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("Booking Requests");
		primarystage.setScene(scene);
		primarystage.show();
	}
	
	public static void showCancelStudent() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("CancelBooking/Cancel.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("Cancel Booking");
		primarystage.setScene(scene);
		primarystage.show();
	}
	
	public static void showReq() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("student_intro/View_Bookings.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("View Bookings");
		primarystage.setScene(scene);
		primarystage.show();
	}
	
	public static void gotobook() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("FacultyIntro/Fac_cancel.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("Room Booking");
		primarystage.setScene(scene);
		primarystage.show();
	}
	public static void showBookStudent() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("student_intro/BookRoom.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setTitle("Room Booking");
		primarystage.setScene(scene);
		primarystage.show();
	}
	
	public static void showCancel() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("CancelBooking/Cancel.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primarystage.setScene(scene);
		primarystage.show();
	}
}
