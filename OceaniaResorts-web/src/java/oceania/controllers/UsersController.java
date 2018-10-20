package oceania.controllers;

import oceania.entities.Users;
import oceania.controllers.util.JsfUtil;
import oceania.controllers.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import oceania.manageusers.UsersManagement;

@Named("usersController")
@SessionScoped
public class UsersController implements Serializable {

    private String hashedPassword;
    private char userRole;
    @EJB
    private UsersManagement userManagement;
    private List<Users> users = null;
    private Users user;

    public UsersController() {
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

   
    public Users prepareCreate() {
        user = new Users();
        initializeEmbeddableKey();
        return user;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UsersCreated"));
        if (!JsfUtil.isValidationFailed()) {
            users = null;    // Invalidate list of users to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UsersUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("UsersDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            user = null; // Remove selection
            users = null;    // Invalidate list of users to trigger re-query.
        }
    }

    public List<Users> getUsers() {
        if (users == null) {
            users = userManagement.findAll();
        }
        return users;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (user != null) {
            setEmbeddableKeys();
            try {
                if (persistAction == PersistAction.CREATE) {
                
                userRole='P';
                user.setUserRole(userRole);
                hashedPassword=user.getPassword();
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash_bytes = digest.digest(hashedPassword.getBytes(StandardCharsets.UTF_8));
        
                 StringBuilder hash = new StringBuilder();
                 for (byte b : hash_bytes) {
                 hash.append(String.format("%02x", b));
                 }
                    user.setPassword(hash.toString());
                    userManagement.create(user);
                  
                }
                else if (persistAction == PersistAction.UPDATE) {
                    userManagement.edit(user);
                }
                else {
                    userManagement.remove(user);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Users getUsers(java.lang.Integer id) {
        return userManagement.find(id);
    }

    public List<Users> getItemsAvailableSelectMany() {
        return userManagement.findAll();
    }

    public List<Users> getItemsAvailableSelectOne() {
        return userManagement.findAll();
    }

    @FacesConverter(forClass = Users.class)
    public static class UsersControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsersController controller = (UsersController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usersController");
            return controller.getUsers(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Users) {
                Users o = (Users) object;
                return getStringKey(o.getUserId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Users.class.getName()});
                return null;
            }
        }

    }

}
