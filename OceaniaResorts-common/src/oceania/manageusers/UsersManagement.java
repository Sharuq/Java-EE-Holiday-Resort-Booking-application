/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.manageusers;

import java.util.List;
import javax.ejb.Remote;
import oceania.entities.Users;

/**
 *
 * @author mdsha
 */
@Remote
public interface UsersManagement {
       
 public void create(Users user)throws Exception;
 
    public void edit(Users user) throws Exception;

    public void remove(Users entity);
    
    public Users find(Object id) ;

    public List<Users> findAll();

   
}

