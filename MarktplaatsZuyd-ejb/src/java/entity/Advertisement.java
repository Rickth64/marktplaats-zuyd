/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author rick
 */
@Entity
@Table(name = "advertisement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advertisement.findAll", query = "SELECT a FROM Advertisement a"),
    @NamedQuery(name = "Advertisement.findByIdadvertisement", query = "SELECT a FROM Advertisement a WHERE a.idadvertisement = :idadvertisement"),
    @NamedQuery(name = "Advertisement.findByName", query = "SELECT a FROM Advertisement a WHERE a.name = :name"),
    @NamedQuery(name = "Advertisement.findByDescription", query = "SELECT a FROM Advertisement a WHERE a.description = :description"),
    @NamedQuery(name = "Advertisement.findByPrice", query = "SELECT a FROM Advertisement a WHERE a.price = :price")})
public class Advertisement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idadvertisement")
    private Integer idadvertisement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advertisementIdadvertisement")
    private Collection<Bidding> biddingCollection;
    @JoinColumn(name = "account_idaccount", referencedColumnName = "idaccount")
    @ManyToOne(optional = false)
    private Account accountIdaccount;
    @JoinColumn(name = "category_idcategory", referencedColumnName = "idcategory")
    @ManyToOne(optional = false)
    private Category categoryIdcategory;

    public Advertisement() {
    }

    public Advertisement(Integer idadvertisement) {
        this.idadvertisement = idadvertisement;
    }

    public Advertisement(Integer idadvertisement, String name, String description) {
        this.idadvertisement = idadvertisement;
        this.name = name;
        this.description = description;
    }

    public Integer getIdadvertisement() {
        return idadvertisement;
    }

    public void setIdadvertisement(Integer idadvertisement) {
        this.idadvertisement = idadvertisement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<Bidding> getBiddingCollection() {
        return biddingCollection;
    }

    public void setBiddingCollection(Collection<Bidding> biddingCollection) {
        this.biddingCollection = biddingCollection;
    }

    public Account getAccountIdaccount() {
        return accountIdaccount;
    }

    public void setAccountIdaccount(Account accountIdaccount) {
        this.accountIdaccount = accountIdaccount;
    }

    public Category getCategoryIdcategory() {
        return categoryIdcategory;
    }

    public void setCategoryIdcategory(Category categoryIdcategory) {
        this.categoryIdcategory = categoryIdcategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadvertisement != null ? idadvertisement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advertisement)) {
            return false;
        }
        Advertisement other = (Advertisement) object;
        if ((this.idadvertisement == null && other.idadvertisement != null) || (this.idadvertisement != null && !this.idadvertisement.equals(other.idadvertisement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Advertisement[ idadvertisement=" + idadvertisement + " ]";
    }
    
}
