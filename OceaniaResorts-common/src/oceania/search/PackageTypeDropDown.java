/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.search;

import java.util.List;
import javax.ejb.Remote;
import oceania.entities.Packages;
/**
 *
 * @author mdsha
 */
@Remote
public interface PackageTypeDropDown {
      public List<Packages> getAllPackageType() throws Exception;
      public Packages packageDetails(int PackageID) throws Exception;
}
