package Domain;

import java.text.SimpleDateFormat;

public class AgendaValidator {
    String errors="";
    public void validate(Agenda agenda){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");
        try {
            simpleDateFormat.parse(agenda.getDay());
        } catch (Exception e){
            throw new AgendaValidatorExceptions(errors);
        }
    }

}
