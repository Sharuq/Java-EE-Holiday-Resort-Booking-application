/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oceania.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Booking.findByBookingNo", query = "SELECT b FROM Booking b WHERE b.bookingNo = :bookingNo")
    , @NamedQuery(name = "Booking.findByBookingName", query = "SELECT b FROM Booking b WHERE b.bookingName = :bookingName")
    , @NamedQuery(name = "Booking.findByBookingTypeId", query = "SELECT b FROM Booking b WHERE b.bookingTypeid.typeId = :bookingTypeid")
    , @NamedQuery(name = "Booking.findByBookingDate", query = "SELECT b FROM Booking b WHERE b.bookingDate = :bookingDate")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BOOKING_NO", nullable = false)
    private Integer bookingNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "BOOKING_NAME", nullable = false, length = 70)
    private String bookingName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOKING_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date bookingDate;
    @JoinColumn(name = "BOOKING_TYPEID", referencedColumnName = "TYPE_ID", nullable = false)
    @ManyToOne(optional = false)
    private Bookingtype bookingTypeid;
    @JoinColumn(name = "PACKAGE_ID", referencedColumnName = "PACKAGE_ID", nullable = false)
    @ManyToOne(optional = false)
    private Packages packageId;
    @JoinColumn(name = "RESORT_ID", referencedColumnName = "RESORT_ID", nullable = false)
    @ManyToOne(optional = false)
    private Resort resortId;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
    @ManyToOne(optional = false)
    private Users userId;

    public Booking() {
    }

    public Booking(Integer bookingNo) {
        this.bookingNo = bookingNo;
    }

    public Booking(Integer bookingNo, String bookingName, Date bookingDate) {
        this.bookingNo = bookingNo;
        this.bookingName = bookingName;
        this.bookingDate = bookingDate;
    }

    public Integer getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(Integer bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Bookingtype getBookingTypeid() {
        return bookingTypeid;
    }

    public void setBookingTypeid(Bookingtype bookingTypeid) {
        this.bookingTypeid = bookingTypeid;
    }

    public Packages getPackageId() {
        return packageId;
    }

    public void setPackageId(Packages packageId) {
        this.packageId = packageId;
    }

    public Resort getResortId() {
        return resortId;
    }

    public void setResortId(Resort resortId) {
        this.resortId = resortId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingNo != null ? bookingNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingNo == null && other.bookingNo != null) || (this.bookingNo != null && !this.bookingNo.equals(other.bookingNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "oceania.entities.Booking[ bookingNo=" + bookingNo + " ]";
    }
    
}
