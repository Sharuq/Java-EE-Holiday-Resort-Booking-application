/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.search.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import oceania.entities.Booking;
import javax.persistence.TypedQuery;
import oceania.entities.Bookingtype;
import oceania.search.BookingDetailsSearch;

/**
 *
 * @author Sharuq
 */
@Stateless
public class BookingSearchImpl implements BookingDetailsSearch {
     
    @PersistenceContext(unitName = "OceaniaResorts-ejbPU")
    
    private EntityManager entityManager;

    @Override
    public List<Booking> searchByBookingNo(int BookingNo) throws Exception {
        Query query =entityManager.createNamedQuery("Booking.findByBookingNo");
        query.setParameter("bookingNo", BookingNo);
       return query.getResultList();
    }

   
    @Override
    public List<Booking> searchByBookingName(String BookingName) throws Exception {
       
    Query query =entityManager.createNamedQuery("Booking.findByBookingName");
        query.setParameter("bookingName", BookingName);
       return query.getResultList();
    }

    @Override
    public List<Booking> getAllBookingProperties() throws Exception {
     Query query =entityManager.createNamedQuery("Booking.findAll");
        return query.getResultList();  
    }

    @Override
    public Booking bookingDetails(int BookingNo) throws Exception {
      
        TypedQuery<Booking> query =entityManager.createNamedQuery("Booking.findByBookingNo",Booking.class);
        query.setParameter("bookingNo", BookingNo);
        return query.getSingleResult();
        
    }

    @Override
    public List<Booking> searchByBookingType(int typeId) throws Exception {
        System.out.println(typeId);
     Query query =entityManager.createNamedQuery("Booking.findByBookingTypeId");
        query.setParameter("bookingTypeid",typeId);
       return query.getResultList();
    }

   
 
    
}
