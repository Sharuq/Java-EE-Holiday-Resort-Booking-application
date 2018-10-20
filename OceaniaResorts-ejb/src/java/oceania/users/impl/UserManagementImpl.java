/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.users.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import oceania.entities.Users;
import oceania.manageusers.UsersManagement;

/**
 *
 * @author mdsha
 */
@Stateless
public class UserManagementImpl implements UsersManagement{

    @PersistenceContext(unitName = "OceaniaResorts-ejbPU")
    private EntityManager entityManager;
    private String hashedPassword;

   
 @Override
    public void create(Users user) throws Exception{
        
        
      
     entityManager.persist(user); 
    }
	
    @Override
    public void edit(Users user) throws Exception {
      entityManager.merge(user);
    }

    @Override
    public Users find(Object id){
      return entityManager.find(Users.class, id);
    }

    @Override
    public List<Users> findAll() {
       javax.persistence.criteria.CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Users.class));
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public List<Users> findRange(int[] range) {
      javax.persistence.criteria.CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Users.class));
        javax.persistence.Query q = entityManager.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    @Override
    public void remove(Users user)  {
      entityManager.remove(entityManager.merge(user));
    }

    @Override
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Users> rt = cq.from(Users.class);
        cq.select(entityManager.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = entityManager.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}