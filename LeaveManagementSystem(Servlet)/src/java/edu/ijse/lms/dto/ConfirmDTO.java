/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dto;

/**
 *
 * @author Dell
 */
public class ConfirmDTO {
    
    private String email;
    
    private String position;
    private String decision;

    public ConfirmDTO(String email, String position, String decision) {
        this.email = email;
        
        this.position = position;
        this.decision = decision;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String isDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }
    
    

    
}
