/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.resorttype;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import oceania.entities.Resort;
import oceania.search.ResortTypeDropDown;

/**
 *
 * @author mdsha
 */
@Stateless
public class ResortTypeImpl implements ResortTypeDropDown
{

    @PersistenceContext(unitName = "OceaniaResorts-ejbPU")
    private EntityManager entityManager;
    @Override
    public List<Resort> getAllResortType() throws Exception {
          Query query =entityManager.createNamedQuery("Resort.findAll");
        return query.getResultList();
    }

    @Override
    public Resort resortDetails(int ResortID) throws Exception {
        TypedQuery<Resort> query =entityManager.createNamedQuery("Resort.findByResortId",Resort.class);
        query.setParameter("resortId", ResortID);
        return query.getSingleResult();}

    
    
}
