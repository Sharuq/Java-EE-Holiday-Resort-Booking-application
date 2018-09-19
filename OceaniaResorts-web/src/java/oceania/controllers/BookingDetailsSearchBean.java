/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import oceania.entities.Booking;
import oceania.search.BookingDetailsSearch;

/**
 *
 * @author Sharuq
 */
@Named(value = "bookingDetailsSearchBean")
@RequestScoped
public class BookingDetailsSearchBean implements Serializable {

    @EJB
    private BookingDetailsSearch bookingDetailsSearch;
   
    private String optionSelected;
    private String searchKeyword;
    private List<Booking> searchResultList;
    
    
     public BookingDetailsSearchBean()  {
         
     }
     public void searchBooking() {
        
         try {
        // searchResultList = new ArrayList<>();
         if(optionSelected.equals("Booking Number"))
         {
             searchResultList =  bookingDetailsSearch.searchByBookingNo(Integer.parseInt(searchKeyword));
             
         }
         else if(optionSelected.equals("Booking Type"))
         {
             searchResultList =  bookingDetailsSearch.searchByBookingType(searchKeyword);
             
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
