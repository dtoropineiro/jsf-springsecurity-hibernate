package licodipo.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class CaptchaView {
    
    public void submit() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");
        //hola asddas
        

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}