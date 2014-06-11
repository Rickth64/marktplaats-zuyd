/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rick
 */
@Entity
@Table(name = "bidding")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bidding.findAll", query = "SELECT b FROM Bidding b"),
    @NamedQuery(name = "Bidding.findByIdbidding", query = "SELECT b FROM Bidding b WHERE b.idbidding = :idbidding"),
    @NamedQuery(name = "Bidding.findByAmount", query = "SELECT b FROM Bidding b WHERE b.amount = :amount")})
public class Bidding implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbidding")
    private Integer idbidding;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @JoinColumn(name = "advertisement_idadvertisement", referencedColumnName = "idadvertisement")
    @ManyToOne(optional = false)
    private Advertisement advertisementIdadvertisement;
    @JoinColumn(name = "account_idaccount", referencedColumnName = "idaccount")
    @ManyToOne(optional = false)
    private Account accountIdaccount;

    public Bidding() {
    }

    public Bidding(Integer idbidding) {
        this.idbidding = idbidding;
    }

    public Bidding(Integer idbidding, BigDecimal amount) {
        this.idbidding = idbidding;
        this.amount = amount;
    }

    public Integer getIdbidding() {
        return idbidding;
    }

    public void setIdbidding(Integer idbidding) {
        this.idbidding = idbidding;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Advertisement getAdvertisementIdadvertisement() {
        return advertisementIdadvertisement;
    }

    public void setAdvertisementIdadvertisement(Advertisement advertisementIdadvertisement) {
        this.advertisementIdadvertisement = advertisementIdadvertisement;
    }

    public Account getAccountIdaccount() {
        return accountIdaccount;
    }

    public void setAccountIdaccount(Account accountIdaccount) {
        this.accountIdaccount = accountIdaccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbidding != null ? idbidding.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bidding)) {
            return false;
        }
        Bidding other = (Bidding) object;
        if ((this.idbidding == null && other.idbidding != null) || (this.idbidding != null && !this.idbidding.equals(other.idbidding))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bidding[ idbidding=" + idbidding + " ]";
    }
    
}
