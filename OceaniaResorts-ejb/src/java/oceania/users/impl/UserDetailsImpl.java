/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.users.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import oceania.entities.Users;
import oceania.search.UserDetails;

/**
 *
 * @author mdsha
 */
@Stateless
public class UserDetailsImpl implements UserDetails
{
  @PersistenceContext(unitName = "OceaniaResorts-ejbPU")
    private EntityManager entityManager;
    @Override
    public Users getUserDetails(String emailID) throws Exception {
        
      TypedQuery<Users> query =entityManager.createNamedQuery("Users.findByEmail",Users.class);
        query.setParameter("email", emailID);
        return query.getSingleResult();
    }

 }
    

