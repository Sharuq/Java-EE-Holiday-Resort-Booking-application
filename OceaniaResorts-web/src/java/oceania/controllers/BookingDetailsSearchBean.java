/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import oceania.entities.Booking;
import oceania.entities.Bookingtype;
import oceania.search.BookingDetailsSearch;
import oceania.search.BookingTypeDropdown;

/**
 *
 * @author Sharuq
 */
@Named(value = "bookingDetailsSearchBean")
@RequestScoped
public class BookingDetailsSearchBean implements Serializable {

    @EJB
    private BookingDetailsSearch bookingDetailsSearch;
    @EJB
    private BookingTypeDropdown bookingTypeDropdown;
    
    private String optionSelected;
    private String searchKeyword;
    private List<Booking> searchResultList;
    private List<Bookingtype> bookingTypeList;
    private String selectedType;
    private Map<String,String> bookingTypeMap;
   
    
     public BookingDetailsSearchBean()  {
         
     }

    public String getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(String selectedType) {
        this.selectedType = selectedType;
    }
     @PostConstruct
     private void init()
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
     
     public void searchBooking() {
        
        try {
             
        if(optionSelected.equals("Booking Number"))
        {
           searchResultList =  bookingDetailsSearch.searchByBookingNo(Integer.parseInt(searchKeyword));
        }    
            
         
        else if(optionSelected.equals("Booking Type"))
            {
             searchResultList =  bookingDetailsSearch.searchByBookingType(Integer.parseInt(selectedType));
            }
         
        else 
         {
             searchResultList =  bookingDetailsSearch.searchByBookingName(searchKeyword);
             
         }
         }
        catch (Exception ex) {
                 Logger.getLogger(BookingDetailsSearchBean.class.getName()).log(Level.SEVERE, null, ex);
            }
         
     }

    public List<Bookingtype> getBookingTypeList() {
        return bookingTypeList;
    }

    public void setBookingTypeList(List<Bookingtype> bookingTypeList) {
        this.bookingTypeList = bookingTypeList;
    }

    public Map<String, String> getBookingTypeMap() {
        return bookingTypeMap;
    }

    public void setBookingTypeMap(Map<String, String> bookingTypeMap) {
        this.bookingTypeMap = bookingTypeMap;
    }

     
    
    
    public String getOptionSelected() {
        return optionSelected;
    }

    public void setOptionSelected(String optionSelected) {
        this.optionSelected = optionSelected;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public List<Booking> getSearchResultList() {
        return searchResultList;
    }

    public void setSearchResultList(ArrayList<Booking> searchResultList) {
        this.searchResultList = searchResultList;
    }
    
  
}
