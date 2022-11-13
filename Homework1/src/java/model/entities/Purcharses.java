/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.io.Serializable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 *
 * @author danib
 */
@Entity
@XmlRootElement
public class Purcharses implements Serializable {
    private static final long serialVersionUID = 1L;
     @Id
    @SequenceGenerator(name="Purcharses_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Purcharses_Gen")
    private Long id;
    private String time;
    private float quantity;
    private float value;
    
    @OneToOne
    private Crypto crypto;
    @ManyToOne
    private User user;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Crypto getCrypto() {
        return crypto;
    }

    public void setCrypto(Crypto crypto) {
        this.crypto = crypto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
   

    public Purcharses() {
    }
    
    
    public float getDquantity() {
        return quantity;
    }
      public void setDescription(float quantity) {
        this.quantity = quantity;
    }
    
     public String gettime() {
        return time;
    }
      public void settime(String time) {
        this.time = time;
    }
 
    public float getvalue() {
        return value;
    }
      public void setName(float value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purcharses)) {
            return false;
        }
        Purcharses other = (Purcharses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "model.entities.Topic[ id=" + id + " ]";
    }
    
}
