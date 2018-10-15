/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author mdsha
 */
@Named(value = "logoutController")
@RequestScoped
public class LogoutController {

    /**
     * Creates a new instance of LogoutController
     */
    public LogoutController() {
    }
    public void logout() {
  try{
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("http://localhost:8080/OceaniaResorts-web/faces/index.xhtml");
  
   }
    catch (Exception ex) {
                 Logger.getLogger(BookingDetailsSearchBean.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
