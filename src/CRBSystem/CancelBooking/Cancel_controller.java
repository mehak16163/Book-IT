package CRBSystem.CancelBooking;

import java.awt.TextArea;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import Backend.Admin;
import Backend.Faculty;
import Backend.Request;
import Backend.Student;
import CRBSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Cancel_controller {
	@FXML 
	private Label result;
	@FXML
	private TextField id;
	@FXML
	private TextField reason;
	@FXML
	private Label warning;
   @FXML
   public void goBack() throws IOException {
	   if (Main.getCurr() instanceof Student)
		   Main.showStudentIntro();
	   else if (Main.getCurr() instanceof Admin )
		   Main.showAdminIntro();
	   else
		   Main.showFacultyIntro();
   }
   
   
   public void cancel() throws FileNotFoundException, ClassNotFoundException, IOException {
	   result.setVisible(false);
	   warning.setVisible(false);
	   if (id.getText().equals("") || reason.getText().equals("")) {
		   warning.setVisible(true);
		   return;
	   }
	   File f = new File("./src/Database/requests");
	   String[] x1 = f.list();
	   int i;
	   for ( i=0; i<x1.length;i++) {
		   Request req = Request.deserialise("./src/Database/requests/"+x1[i]);
		   if (req.getId()==Integer.parseInt(id.getText())) {
			   File f1 = new File("./src/Database/requests/"+x1[i]);
			   f1.delete();
			   result.setText("Request has been cancelled");
			   if(req.accepted==true) {
				   req.remove();
				   if (Main.getCurr() instanceof Student) {
					   Student s = req.getStudent();
						s.getRequests().remove(req.getId());
						s.serialise();
				   }
				   if (Main.getCurr() instanceof Faculty) {
					   Faculty fac = (Faculty)Main.getCurr();
					   fac.getRequest().remove(req.getId());
				   }
			   }
			   else {
				   if (Main.getCurr() instanceof Student) {
					   Student s = req.getStudent();
						s.getRequests().remove(id);
						s.serialise(); 
				   }
			   }
			   result.setVisible(true);
			   break;
		   }
	   }
	   if (i==x1.length) {
		   result.setText("Enter correct Booking ID");
		   result.setVisible(true);
	   }
   }
   }
