/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.search.impl;

import java.util.List;
import javax.persistence.Query;
import oceania.entities.Bookingtype;
import oceania.search.BookingTypeDropdown;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author sharuq
 */
@Stateless
public class BookingTypeImpl implements BookingTypeDropdown{
    
    @PersistenceContext(unitName = "OceaniaResorts-ejbPU")
    private EntityManager entityManager;
    
     @Override
    public List<String> getAllBookingTypeName() throws Exception {
      Query query =entityManager.createNamedQuery("Bookingtype.findAllTypeName");
        return query.getResultList();  
    }

    @Override
    public List<Bookingtype> getAllBookingType() throws Exception {
     Query query =entityManager.createNamedQuery("Bookingtype.findAll");
        return query.getResultList(); 
    }
}
