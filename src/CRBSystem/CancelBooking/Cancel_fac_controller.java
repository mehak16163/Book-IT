package CRBSystem.CancelBooking;

import java.awt.TextArea;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import Backend.Request;
import CRBSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Cancel_fac_controller {
	@FXML 
	private Label result;
	@FXML
	private TextField id;
	@FXML
	private TextArea reason;
	@FXML
	private Label warning;
   @FXML
   public void goBack() throws IOException {
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
		   String x = x1[i];
		   Request req = Request.deserialise("./src/Database/requests/"+x1[i]+".txt");
		   if (req.getId()==Integer.parseInt(id.getText())) {
			   File f1 = new File("./src/Database/requests/"+x1[i]+".txt");
			   f1.delete();
			   result.setText("Request has been cancelled");
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
