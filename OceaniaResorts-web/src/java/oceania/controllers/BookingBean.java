/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import oceania.entities.Booking;
import oceania.entities.Bookingtype;
import oceania.entities.Packages;
import oceania.entities.Resort;
import oceania.entities.Users;
import oceania.repositories.BookingRepository;
import oceania.search.BookingTypeDropdown;
import oceania.search.PackageTypeDropDown;
import oceania.search.ResortTypeDropDown;
import oceania.search.UserDetails;

/**
 *
 * @author mdsha
 */
@Named(value = "bookingBean")
@SessionScoped
public class BookingBean implements Serializable {
    private String bookingDate;
    private String bookingName;
    private int resortID;
    private int packageID;
    private int totalPrice;
    private String selectedType;
    private String username;
    private Booking booking;
    private Resort resort;
    private Bookingtype bookingType;
    private Packages newPackage;
    private Users user;
    private int booking_no;
    
    @EJB
    private BookingRepository bookingRepository;
    @EJB
    private  ResortTypeDropDown resortTypeDropDown;
    @EJB
    private  PackageTypeDropDown packageTypeDropDown;
    @EJB
    private BookingTypeDropdown bookingTypeDropdown;
    @EJB
    private UserDetails userDeatils;
    
    public BookingBean() {
    }


     @PostConstruct
        public void init() {
         username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
      }
     
     public String outcome(){
         return "paymentGateway";
     }
     
     public String newOutcome(){
       try{
            SimpleDateFormat sdf1 = new SimpleDateFormat("mm/dd/yyyy");
            java.util.Date date_util = sdf1.parse(bookingDate);
            java.sql.Date sqlBookingDate = new java.sql.Date(date_util.getTime());
            resort= resortTypeDropDown.getResortDetails(resortID);
            newPackage= packageTypeDropDown.getPackageDetails(packageID);
            bookingType= bookingTypeDropdown.getBookingtypeDetails(Integer.parseInt(selectedType));
            user= userDeatils.getUserDetails(username);
            
            booking=new Booking();
            
            booking.setBookingName(bookingName);
            booking.setBookingDate(sqlBookingDate);
            booking.setBookingTypeid(bookingType);
            booking.setPackageId(newPackage);
            booking.setResortId(resort);
            booking.setUserId(user);
            booking.setTotalPrice(totalPrice);
            
            bookingRepository.addBooking(booking);
            //booking_no= booking.getBookingNo();
            return "sucess";
            
       }
       catch (Exception ex) {
                 Logger.getLogger(BookingBean.class.getName()).log(Level.SEVERE, null, ex);
                 return "paymentGateway";
             }
         
	
        
     }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getBooking_no() {
        return booking_no;
    }

    public void setBooking_no(int booking_no) {
        this.booking_no = booking_no;
    }

     
    public int getResortID() {
        return resortID;
    }

    public void setResortID(int resortID) {
        this.resortID = resortID;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }
     
     
    public String getBookingDate() {
        return bookingDate;
    }

    public Resort getResort() {
        return resort;
    }

    public void setResort(Resort resort) {
        this.resort = resort;
    }

    public Bookingtype getBookingType() {
        return bookingType;
    }

    public void setBookingType(Bookingtype bookingType) {
        this.bookingType = bookingType;
    }

    public Packages getNewPackage() {
        return newPackage;
    }

    public void setNewPackage(Packages newPackage) {
        this.newPackage = newPackage;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
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

   

    public String getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(String selectedType) {
        this.selectedType = selectedType;
    }

   
    
}
