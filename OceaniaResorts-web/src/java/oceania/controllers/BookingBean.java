/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import oceania.entities.Bookingtype;
import oceania.search.BookingTypeDropdown;

/**
 *
 * @author mdsha
 */
@Named(value = "bookingBean")
@SessionScoped
public class BookingBean implements Serializable {
    private String bookingDate;
    private String bookingName;
    
    private List<Bookingtype> bookingTypeList;
    private String selectedType;
    private Map<String,String> bookingTypeMap;
    
    @EJB
    private BookingTypeDropdown bookingTypeDropdown;
    
    /**
     * Creates a new instance of BookingBean
     */
    public BookingBean() {
    }

     @PostConstruct
     private void allBookingTypes()
     {
         bookingTypeMap=new LinkedHashMap<String,String>();
         
         try{
                bookingTypeList = bookingTypeDropdown.getAllBookingType();
                
                for (Bookingtype b: bookingTypeList){
                    bookingTypeMap.put(b.getTypeName(),b.getTypeId().toString());
                }
           }
         catch (Exception ex) {
                 Logger.getLogger(BookingDetailsSearchBean.class.getName()).log(Level.SEVERE, null, ex);
             }
     }
    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public List<Bookingtype> getBookingTypeList() {
        return bookingTypeList;
    }

    public void setBookingTypeList(List<Bookingtype> bookingTypeList) {
        this.bookingTypeList = bookingTypeList;
    }

    public String getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(String selectedType) {
        this.selectedType = selectedType;
    }

    public Map<String, String> getBookingTypeMap() {
        return bookingTypeMap;
    }

    public void setBookingTypeMap(Map<String, String> bookingTypeMap) {
        this.bookingTypeMap = bookingTypeMap;
    }
    
    
}
