/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.controllers;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import oceania.entities.Packages;
import oceania.entities.Resort;
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
    
    
    private int resortID;
    private Resort resort;
    private int packageID;
    private Packages newPackage;
    private String option1;
    private String option2;
    
    private int price=0;
    private int surcharge=0;
    private float total=0;
    /**
     * Creates a new instance of BookingCartController
     */
    public BookingCartController() {
        
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

    public int getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(int surcharge) {
        this.surcharge = surcharge;
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
