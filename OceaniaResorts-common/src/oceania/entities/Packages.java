/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mdsha
 */
@Entity
@Table(catalog = "", schema = "OCEANIARESORTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Packages.findAll", query = "SELECT p FROM Packages p")
    , @NamedQuery(name = "Packages.findByPackageId", query = "SELECT p FROM Packages p WHERE p.packageId = :packageId")
    , @NamedQuery(name = "Packages.findByPackageName", query = "SELECT p FROM Packages p WHERE p.packageName = :packageName")
    , @NamedQuery(name = "Packages.findByPackageDescription", query = "SELECT p FROM Packages p WHERE p.packageDescription = :packageDescription")
    , @NamedQuery(name = "Packages.findByPackageCharge", query = "SELECT p FROM Packages p WHERE p.packageCharge = :packageCharge")})
public class Packages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PACKAGE_ID", nullable = false)
    private Integer packageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "PACKAGE_NAME", nullable = false, length = 70)
    private String packageName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "PACKAGE_DESCRIPTION", nullable = false, length = 300)
    private String packageDescription;
    @Column(name = "PACKAGE_CHARGE")
    private Integer packageCharge;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageId")
    private Collection<Booking> bookingCollection;

    public Packages() {
    }

    public Packages(Integer packageId) {
        this.packageId = packageId;
    }

    public Packages(Integer packageId, String packageName, String packageDescription) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.packageDescription = packageDescription;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageDescription() {
        return packageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }

    public Integer getPackageCharge() {
        return packageCharge;
    }

    public void setPackageCharge(Integer packageCharge) {
        this.packageCharge = packageCharge;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (packageId != null ? packageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Packages)) {
            return false;
        }
        Packages other = (Packages) object;
        if ((this.packageId == null && other.packageId != null) || (this.packageId != null && !this.packageId.equals(other.packageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "oceania.entities.Packages[ packageId=" + packageId + " ]";
    }
    
}
