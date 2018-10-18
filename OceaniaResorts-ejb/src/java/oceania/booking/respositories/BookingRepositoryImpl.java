/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.booking.respositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import oceania.entities.Booking;
import oceania.repositories.BookingRepository;

/**
 *
 * @author mdsha
 */
@Stateless
public class BookingRepositoryImpl implements BookingRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addBooking(Booking booking) throws Exception {
      entityManager.persist(booking);
    }
   
    
}
