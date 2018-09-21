/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.search;

import java.util.List;
import javax.ejb.Remote;
import oceania.entities.Bookingtype;

/**
 *
 * @author mdsha
 */
@Remote
public interface BookingTypeDropdown {
    
     public List<Bookingtype> getAllBookingType() throws Exception;
    
    public List<String> getAllBookingTypeName() throws Exception;
}
