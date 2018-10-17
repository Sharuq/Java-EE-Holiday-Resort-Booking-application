/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mdsha
 */
@Entity
@Table(catalog = "", schema = "OCEANIARESORTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resort.findAll", query = "SELECT r FROM Resort r")
    , @NamedQuery(name = "Resort.findByResortId", query = "SELECT r FROM Resort r WHERE r.resortId = :resortId")
    , @NamedQuery(name = "Resort.findByResortName", query = "SELECT r FROM Resort r WHERE r.resortName = :resortName")
    , @NamedQuery(name = "Resort.findByResortAddress", query = "SELECT r FROM Resort r WHERE r.resortAddress = :resortAddress")
    , @NamedQuery(name = "Resort.findByResortCity", query = "SELECT r FROM Resort r WHERE r.resortCity = :resortCity")
    , @NamedQuery(name = "Resort.findByResortLandscape", query = "SELECT r FROM Resort r WHERE r.resortLandscape = :resortLandscape")
    , @NamedQuery(name = "Resort.findBySurCharge", query = "SELECT r FROM Resort r WHERE r.surCharge = :surCharge")})
public class Resort implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RESORT_ID", nullable = false)
    private Integer resortId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "RESORT_NAME", nullable = false, length = 70)
    private String resortName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 130)
    @Column(name = "RESORT_ADDRESS", nullable = false, length = 130)
    private String resortAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "RESORT_CITY", nullable = false, length = 150)
    private String resortCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "RESORT_LANDSCAPE", nullable = false, length = 150)
    private String resortLandscape;
    @Column(name = "SUR_CHARGE")
    private Integer surCharge;

    public Resort() {
    }

    public Resort(Integer resortId) {
        this.resortId = resortId;
    }

    public Resort(Integer resortId, String resortName, String resortAddress, String resortCity, String resortLandscape) {
        this.resortId = resortId;
        this.resortName = resortName;
        this.resortAddress = resortAddress;
        this.resortCity = resortCity;
        this.resortLandscape = resortLandscape;
    }

    public Integer getResortId() {
        return resortId;
    }

    public void setResortId(Integer resortId) {
        this.resortId = resortId;
    }

    public String getResortName() {
        return resortName;
    }

    public void setResortName(String resortName) {
        this.resortName = resortName;
    }

    public String getResortAddress() {
        return resortAddress;
    }

    public void setResortAddress(String resortAddress) {
        this.resortAddress = resortAddress;
    }

    public String getResortCity() {
        return resortCity;
    }

    public void setResortCity(String resortCity) {
        this.resortCity = resortCity;
    }

    public String getResortLandscape() {
        return resortLandscape;
    }

    public void setResortLandscape(String resortLandscape) {
        this.resortLandscape = resortLandscape;
    }

    public Integer getSurCharge() {
        return surCharge;
    }

    public void setSurCharge(Integer surCharge) {
        this.surCharge = surCharge;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resortId != null ? resortId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resort)) {
            return false;
        }
        Resort other = (Resort) object;
        if ((this.resortId == null && other.resortId != null) || (this.resortId != null && !this.resortId.equals(other.resortId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "oceania.entities.Resort[ resortId=" + resortId + " ]";
    }
    
}
