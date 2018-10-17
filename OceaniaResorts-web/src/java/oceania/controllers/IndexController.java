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
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import oceania.entities.Packages;
import oceania.entities.Resort;
import oceania.search.PackageTypeDropDown;
import oceania.search.ResortTypeDropDown;

/**
 *
 * @author mdsha
 */
@Named(value = "indexController")
@SessionScoped
public class IndexController implements Serializable {

    @EJB
    private PackageTypeDropDown packageTypeDropdown;
    
    @EJB
    private ResortTypeDropDown resortTypeDropdown;
    
    
    private List<Resort> resortTypeList;
    private String selectedType1;
    private Map<String,String> resortTypeMap;
    private List<Packages> packageTypeList;

    private String selectedType2;
    private Map<String,String> packageTypeMap;
    /**
     * Creates a new instance of IndexController
     */
    public IndexController() {
    }
    
    
    @PostConstruct
     private void allBookingTypes()
     {
        
         resortTypeMap=new LinkedHashMap<String,String>();
         packageTypeMap=new LinkedHashMap<String,String>();
         try{
                resortTypeList = resortTypeDropdown.getAllResortType();
                packageTypeList = packageTypeDropdown.getAllPackageType();
                for (Resort b: resortTypeList){
                    resortTypeMap.put(b.getResortName(),b.getResortId().toString());
                }
                for (Packages b: packageTypeList){
                    packageTypeMap.put(b.getPackageName(),b.getPackageId().toString());
                }
           }
         catch (Exception ex) {
                 Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
             }
     }

     
    public String getSelectedType1() {
        return selectedType1;
    }

    public void setSelectedType1(String selectedType1) {
        this.selectedType1 = selectedType1;
    }

    public String getSelectedType2() {
        return selectedType2;
    }

    public void setSelectedType2(String selectedType2) {
        this.selectedType2 = selectedType2;
    }
    public List<Resort> getResortTypeList() {
        return resortTypeList;
    }

    public void setResortTypeList(List<Resort> resortTypeList) {
        this.resortTypeList = resortTypeList;
    }

    public Map<String, String> getResortTypeMap() {
        return resortTypeMap;
    }

    public void setResortTypeMap(Map<String, String> resortTypeMap) {
        this.resortTypeMap = resortTypeMap;
    }

    public List<Packages> getPackageTypeList() {
        return packageTypeList;
    }

    public void setPackageTypeList(List<Packages> packageTypeList) {
        this.packageTypeList = packageTypeList;
    }

    public Map<String, String> getPackageTypeMap() {
        return packageTypeMap;
    }

    public void setPackageTypeMap(Map<String, String> packageTypeMap) {
        this.packageTypeMap = packageTypeMap;
    }
}
