package com.example.banque;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Compte {
    private int code;
    private double solde;

    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}
