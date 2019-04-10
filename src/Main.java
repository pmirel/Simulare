import Domain.AgendaValidator;
import Repository.InMemoryRepository;
import Service.AgendaService;
import UI.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/sample.fxml"));
        Parent root = fxmlLoader.load();
        Controller controller =  fxmlLoader.getController();

        AgendaValidator validator = new AgendaValidator();
        InMemoryRepository repository = new InMemoryRepository(validator);
        AgendaService service = new AgendaService(repository);

        service.insert("1","school","11.11.2018","60","12.00");
        service.insert("2","gym","11.11.2018","30","13.00");
        service.insert("3","swim","12.11.2018","60","12.00");
        service.insert("4","shopping","13.11.2018","20","12.00");
        service.insert("5","travel","13.11.2018","40","13.00");
        service.insert("6","coding","13.11.2018","70","15.00");


        controller.setServices(service);


        primaryStage.setTitle("Agenda manager");
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
