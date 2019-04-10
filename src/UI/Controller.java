package UI;

import Domain.Agenda;
import Service.AgendaService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {


    public TableView tableViewAgendas;
    public TableColumn tableColumnId;
    public TableColumn tableColumnName;
    public TableColumn tableColumnDay;
    public TableColumn tableColumnDuration;
    public TableColumn tableColumnStartHour;
    public TextField txtLongestEvent;
    public Label name;

    public AgendaService service;


    private ObservableList<Agenda> agendas = FXCollections.observableArrayList();


    public void setServices(AgendaService service) {
        this.service = service;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            agendas.addAll(service.getAll());
            tableViewAgendas.setItems(agendas);
        });
    }


    public void btnAgendaAddClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("agendaAdd.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 200);
            Stage stage = new Stage();
            stage.setTitle("Add agenda");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            AgendaAddController controller = fxmlLoader.getController();
            controller.setService(service);
            stage.showAndWait();
            agendas.clear();
            agendas.addAll(service.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window: Agenda.", e);
        }

    }

    public void btnAgendaLongestEventClick(ActionEvent actionEvent) {
        String a = txtLongestEvent.getText();

        try {
            if (a.charAt(2) != '.' || a.charAt(5) != '.') {
                throw new RuntimeException("Date format should be dd.mm.yyy\n");
            }
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }

        int minutes = Integer.MIN_VALUE;
        List<Agenda> all = service.getAll();
        for (Agenda i : all) {
            int temp = Integer.parseInt(i.getDuration());
            if (temp>minutes && i.getDay().equals(a)) {
                minutes=temp;
            }
        }
        name.setText(minutes+"");
    }
}