/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.io.Serializable;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author danib
 */
public class Purcharses implements Serializable {
    private static final long serialVersionUID = 1L;
     @Id
    @SequenceGenerator(name="Topic_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Topic_Gen")
    private Long id;
    private String time;
    private float quantity;
    private float value;
    
    @ManyToOne 
    private Crypto crypto;
    
    @ManyToOne
    private User user; 
    
    public User getUser() {
        return user;
    }
    public Crypto getCrypto() {
        return crypto;
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
