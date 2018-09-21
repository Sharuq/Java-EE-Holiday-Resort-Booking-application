/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.search;

import java.rmi.RemoteException;
import java.util.List;
import javax.ejb.CreateException;
import javax.ejb.Remote;
import oceania.entities.Booking;
import oceania.entities.Bookingtype;
/**
 *
 * @author mdsha
 */
@Remote
public interface BookingDetailsSearch {
    
    public List<Booking> getAllBookingProperties() throws Exception;
    
    public Booking bookingDetails(int BookingID) throws Exception;
    
    public List<Booking> searchByBookingNo(int BookingID) throws Exception;
    
    public List<Booking> searchByBookingType(int typeId) throws Exception;
    
    public List<Booking> searchByBookingName(String BookingName) throws Exception;
    
   
    
    
    
}
