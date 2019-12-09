import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public void start(Stage arg0) throws Exception {
		Parent prnt = FXMLLoader.load(getClass().getResource("gui.fxml"));
		Scene sn = new Scene(prnt);
		arg0.setScene(sn);
		arg0.show();
	}
	
	public static void main(String args[]) {
		launch(args);
	}
	
	
}
