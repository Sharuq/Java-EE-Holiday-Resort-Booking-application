/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.search;

import java.util.List;
import javax.ejb.Remote;
import oceania.entities.Resort;

/**
 *
 * @author mdsha
 */
@Remote
public interface ResortTypeDropDown {
          public List<Resort> getAllResortType() throws Exception;
          public Resort resortDetails(int ResortID) throws Exception;
    
}
