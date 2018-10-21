/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.validation.constraints.Pattern;
import oceania.entities.Users;
import oceania.manageusers.UsersManagement;

/**
 *
 * @author mdsha
 */
@Named(value = "registrationBean")
@SessionScoped
public class RegistrationBean implements Serializable {

    @Pattern(regexp = "[A-Za-z]*",message = "Alphabets are only accepted")
    private String fname;
    @Pattern(regexp = "[A-Za-z]*",message = "Alphabets are only accepted")
    private String lname;
    @Pattern(regexp = ".+@.+\\.[A-Za-z]+",message = "Email Id format is only accepted")
    private String emailId;
    private String password;
    private String address;
    @EJB
    private UsersManagement userManagement;
    private Users user;
    private String hashedPassword;
    
    public RegistrationBean() {
    }
   
    public String register()
   {
    
    try{
        
            user= new Users();
            user.setEmail(emailId);
            user.setUserName(fname);
            user.setUserNameLast(lname);
            user.setUserRole('P');
            user.setAddress(address);
           
            
            hashedPassword=password;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash_bytes = digest.digest(hashedPassword.getBytes(StandardCharsets.UTF_8));
        
            StringBuilder hash = new StringBuilder();
              for (byte b : hash_bytes) {
                 hash.append(String.format("%02x", b));
               }
              System.out.println("hash");
            user.setPassword(hash.toString());
            userManagement.create(user);
            return "sucessregistration";
    }
            catch (Exception ex) {
                 Logger.getLogger(BookingBean.class.getName()).log(Level.SEVERE, null, ex);
                 return "register";
             }
           
  
   }
    
    public void validateLName(FacesContext f, UIComponent c, Object obj){
        String s=(String)obj;
        if(s.length()==0)
            throw new ValidatorException(new FacesMessage("Name cannot be empty."));        
    }
     public void validateFName(FacesContext f, UIComponent c, Object obj){
        String s=(String)obj;
        if(s.length()==0)
            throw new ValidatorException(new FacesMessage("Name cannot be empty."));        
    }
    public void validateEmailId(FacesContext f, UIComponent c, Object obj){
        String s=(String)obj;
        if(s.length()==0)
            throw new ValidatorException(new FacesMessage("User Email cannot be empty."));        
    }
    public void validateAddress(FacesContext f, UIComponent c, Object obj){
        String s=(String)obj;
        if(s.length()==0)
            throw new ValidatorException(new FacesMessage("Address cannot be empty."));        
    }
    public void validatePassword(FacesContext f, UIComponent c, Object obj){
        String s=(String)obj;
        if(s.length()<8)
            throw new ValidatorException(new FacesMessage("Password must be >= 8 characters. "));        
    }
    
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
  
  
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
   
 
}
