/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.packagetype;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import oceania.entities.Packages;
import oceania.search.PackageTypeDropDown;

/**
 *
 * @author mdsha
 */
@Stateless
public class PackageTypeImpl implements PackageTypeDropDown
{

    @PersistenceContext(unitName = "OceaniaResorts-ejbPU")
    private EntityManager entityManager;
    
    @Override
    public List<Packages> getAllPackageType() throws Exception {
         Query query =entityManager.createNamedQuery("Packages.findAll");
        return query.getResultList();
     }

    @Override
    public Packages getPackageDetails(int PackageID) throws Exception {
        TypedQuery<Packages> query =entityManager.createNamedQuery("Packages.findByPackageId",Packages.class);
        query.setParameter("packageId", PackageID);
        return query.getSingleResult();

    
    }

    
    
}
