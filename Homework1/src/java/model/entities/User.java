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
import java.io.Serializable;
import jakarta.persistence.OneToMany;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author danib
 */
@Entity
@XmlRootElement
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="User_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_Gen")
    private Long id;
    private String password;
    private String userNamer;
    
    
    @ManyToMany(mappedBy = "users")
    final private Collection<Crypto> crypto;
    @OneToMany(mappedBy = "user")
    final private Collection<Purcharses> purcharses;
   
    
    
    public User() {
        this.purcharses = new ArrayList<>();
        this.crypto = new ArrayList<>();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Collection<Crypto> getCrypto() {
        return crypto;
    }

    public Collection<Purcharses> getPurcharses() {
        return purcharses;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserNamer() {
        return userNamer;
    }

    public void setUserNamer(String userNamer) {
        this.userNamer = userNamer;
    }
    
    
    
}
