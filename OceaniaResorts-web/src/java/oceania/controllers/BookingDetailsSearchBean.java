/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.controllers;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import oceania.search.BookingDetailsSearch;

/**
 *
 * @author Sharuq
 */
@Named(value = "bookingDetailsSearchBean")
@RequestScoped
public class BookingDetailsSearchBean {

    @EJB
    private BookingDetailsSearch bookingDetailsSearch;
    
    public BookingDetailsSearchBean() {
    }
    
}
