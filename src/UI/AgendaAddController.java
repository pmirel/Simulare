package UI;

import Service.AgendaService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AgendaAddController {
    public Spinner spnId;
    public TextField txtAgendaName;
    public TextField txtAgendaDay;
    public TextField txtAgendaDuration;
    public TextField txtAgendaStartHour;
    public Button btnAddAgenda;
    public Button btnCancel;
    private AgendaService service;

    public void setService(AgendaService service) {
        this.service = service;
    }

    public void btnAddClick(ActionEvent actionEvent) {
        try {
            String id = String.valueOf(spnId.getValue());
            String agendaName = txtAgendaName.getText();
            String day = txtAgendaDay.getText();
            String duration = txtAgendaDuration.getText();
            String startHour = txtAgendaStartHour.getText();
            service.insert(id, agendaName, day, duration,startHour);
            btnCancelClick(actionEvent);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }

    }


    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
