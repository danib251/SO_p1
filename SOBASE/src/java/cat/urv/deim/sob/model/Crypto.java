/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.urv.deim.sob.model;

import java.util.Date;

/**
 *
 * @author danib
 */
public class Crypto {
    private long id;
    
    private String description;
    
    private String name; 
    
    private float value;
    
    private Date date;
    
    private Purchase purcharse;
    
    public Crypto() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Purchase getPurcharse() {
        return purcharse;
    }

    public void setPurcharses(Purchase purcharse) {
        this.purcharse = purcharse;
    }
    
    
    
}
