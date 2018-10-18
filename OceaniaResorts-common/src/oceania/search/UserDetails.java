/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.search;

import javax.ejb.Remote;
import oceania.entities.Users;

/**
 *
 * @author mdsha
 */
@Remote
public interface UserDetails {
    public Users getUserDetails(String emailID) throws Exception;
}
