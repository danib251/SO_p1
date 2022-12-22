/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Support;
import java.io.Serializable;
/**
 *
 * @author Daniel Becerra
 * @author Gabriel Gombau
 * 
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String message;
    
    public Message (String m){
        this.message=m;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
