/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author danib
 */
@Entity
@XmlRootElement
public class Crypto implements Serializable {
    private static final long serialVersionUID = 1L;
     @Id
    @SequenceGenerator(name="Crypto_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Crypto_Gen")
    private long id;
    private String description;
    private String name; 
    private float value;
    private String date;

    @ManyToMany
    private Collection<User> user;
    @OneToOne(mappedBy = "crypto")
    private Purcharses purcharses;

    

    public Crypto(){}
    public Collection<User> getUser() {
        return user;
    }

    public void setUser(Collection<User> user) {
        this.user = user;
    }

    public Purcharses getPurcharses() {
        return purcharses;
    }

    public void setPurcharses(Purcharses purcharses) {
        this.purcharses = purcharses;
    }
    
  
  
    public String getDescription() {
        return description;
    }
      public void setDescription(String description) {
        this.description = description;
    }
    public float getValue() {
        return value;
    }
      public void setValue(float value) {
        this.value = value;
    }
    
     public String getdate() {
        return date;
    }
      public void setdate(String date) {
        this.date = date;
    }
 
    public String getName() {
        return name;
    }
      public void setName(String name) {
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "model.entities.Topic[ id=" + id + " ]";
    }
    
}
