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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Booking> searchByBookingName(String BookingName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
}
