/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author mdsha
 */
@Named(value = "navigationController")
@RequestScoped
public class NavigationController {

    /**
     * Creates a new instance of LogoutController
     */
    public NavigationController() {
    }
    
    public void logout() {
  try{
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("http://localhost:8080/OceaniaResorts-web/faces/index.xhtml");
  
   }
    catch (IOException ex) {
                 Logger.getLogger(BookingDetailsSearchBean.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void register()
    {
        try{
      
     FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("http://localhost:8080/OceaniaResorts-web/faces/register.xhtml");
        }
        catch (IOException ex) {
                 Logger.getLogger(BookingDetailsSearchBean.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void home()
    {
        try{
      
     FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("http://localhost:8080/OceaniaResorts-web/faces/index.xhtml");
        }
        catch (IOException ex) {
                 Logger.getLogger(BookingDetailsSearchBean.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void publichome()
    {
        try{
      
     FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("http://localhost:8080/OceaniaResorts-web/faces/public/index.xhtml");
        }
        catch (IOException ex) {
                 Logger.getLogger(BookingDetailsSearchBean.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
