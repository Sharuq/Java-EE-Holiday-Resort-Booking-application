/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.search;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import oceania.entities.Booking;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sharuq
 */
@Stateless
public class BookingSearchImpl implements BookingDetailsSearch {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Booking> searchByBookingNo(int BookingNo) throws Exception {
        Query query =entityManager.createNamedQuery("Booking.findByBookingNo");
        query.setParameter("bookingNo", BookingNo);
       return query.getResultList();
    }

    @Override
    public List<Booking> searchByBookingType(String BookingType) throws Exception {
       Query query =entityManager.createNamedQuery("Booking.findByBookingType");
        query.setParameter("bookingType", BookingType);
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
       //TypedQuery<Booking> query =entityManager.createNamedQuery("Booking.findAll",Booking.class);
       //query.setParameter("bookingNo", BookingNo);
       //return query.getSingleResult();
       // Booking result;
        //TypedQuery<Booking> query =entityManager.createNamedQuery("SELECT b FROM Booking b WHERE b.bookingNo = :BookingNo",Booking.class);
        //query.setParameter("bookingNo", BookingNo);
        //return query.getSingleResult();
        //result= query.getSingleResult();
       Booking booking = entityManager.find(Booking.class, BookingNo);
       return booking;
        
    }
 
    
}
