/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.controllers;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import oceania.entities.Bookingtype;
import oceania.entities.Packages;
import oceania.entities.Resort;
import oceania.search.BookingTypeDropdown;
import oceania.search.PackageTypeDropDown;
import oceania.search.ResortTypeDropDown;

/**
 *
 * @author mdsha
 */
@Named(value = "bookingCartController")
@SessionScoped
public class BookingCartController implements Serializable{

    @EJB
    private  ResortTypeDropDown resortTypeDropDown;
    @EJB
    private  PackageTypeDropDown packageTypeDropDown;
    @EJB
    private BookingTypeDropdown bookingTypeDropdown;
    
    private int resortID;
    private Resort resort;
    private int packageID;
    private Packages newPackage;
    private String option1;
    private String option2;
    private String bookingDate;
    private String bookingName;
    private int price=0;
    private int surcharge=0;
    private float total=0;
     private List<Bookingtype> bookingTypeList;
    private String selectedType;
    private Map<String,String> bookingTypeMap;
    
    
    /**
     * Creates a new instance of BookingCartController
     */
    public BookingCartController() {
        
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
    public String outcome(){
        try{
        resortID=Integer.parseInt(option1);
        resort= resortTypeDropDown.resortDetails(resortID);
        packageID=Integer.parseInt(option2);
        newPackage= packageTypeDropDown.packageDetails(packageID);
        price=newPackage.getPackageCharge();
        surcharge= resort.getSurCharge();
        total=(float)(price+((price/100)*surcharge));
        bookingDate="";
        bookingName="";
        }
        catch (Exception ex) {
                 Logger.getLogger(BookingCartController.class.getName()).log(Level.SEVERE, null, ex);
             }
	return "bookingCart";
	}

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public int getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(int surcharge) {
        this.surcharge = surcharge;
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

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public int getResortID() {
        return resortID;
    }

    public void setResortID(int resortID) {
        this.resortID = resortID;
    }

    public Resort getResort() {
        return resort;
    }

    public void setResort(Resort resort) {
        this.resort = resort;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public Packages getNewPackage() {
        return newPackage;
    }

    public void setNewPackage(Packages newPackage) {
        this.newPackage = newPackage;
    }
    
}
