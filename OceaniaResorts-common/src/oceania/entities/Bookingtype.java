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
    @NamedQuery(name = "Bookingtype.findAll", query = "SELECT b FROM Bookingtype b")
    , @NamedQuery(name = "Bookingtype.findByTypeId", query = "SELECT b FROM Bookingtype b WHERE b.typeId = :typeId")
      , @NamedQuery(name = "Bookingtype.findAllTypeName", query = "SELECT b.typeName FROM Bookingtype b")
        , @NamedQuery(name = "Bookingtype.findByTypeName", query = "SELECT b FROM Bookingtype b WHERE b.typeName = :typeName")})
public class Bookingtype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TYPE_ID", nullable = false)
    private Integer typeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "TYPE_NAME", nullable = false, length = 70)
    private String typeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingTypeid")
    private Collection<Booking> bookingCollection;

    public Bookingtype() {
    }

    public Bookingtype(Integer typeId) {
        this.typeId = typeId;
    }

    public Bookingtype(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
        hash += (typeId != null ? typeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookingtype)) {
            return false;
        }
        Bookingtype other = (Bookingtype) object;
        if ((this.typeId == null && other.typeId != null) || (this.typeId != null && !this.typeId.equals(other.typeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "oceania.entities.Bookingtype[ typeId=" + typeId + " ]";
    }
    
}
