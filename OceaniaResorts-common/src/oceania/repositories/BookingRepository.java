/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.repositories;

import javax.ejb.Remote;
import oceania.entities.Booking;

/**
 *
 * @author mdsha
 */
@Remote
public interface BookingRepository {
    
     public void addBooking(Booking booking) throws Exception;

}
