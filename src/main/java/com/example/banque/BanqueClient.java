package com.example.banque;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.List;

public class BanqueClient {
    public static void main(String[] args) {
        try {
            
            URL url = new URL("http://localhost:8080/banque?wsdl");
            
            QName qname = new QName("http://banque.example.com/", "BanqueServiceImplService");
        
            Service service = Service.create(url, qname);
            
            BanqueService banqueService = service.getPort(BanqueService.class);

            
            double montantEnAuro = 100; 
            double montantEnDH = banqueService.conversion(montantEnAuro);
            System.out.println("Conversion: " + montantEnAuro + " Auro = " + montantEnDH + " DH");

            
            Compte compte = banqueService.getCompte();
            System.out.println("Compte: " + compte.getCode() + ", Solde: " + compte.getSolde());

           
            List<Compte> comptes = banqueService.getComptes();
            for (Compte c : comptes) {
                System.out.println("Compte: " + c.getCode() + ", Solde: " + c.getSolde());
            }
            
            banqueService.crediter(1, 100);
            System.out.println("Compte crédité");

            
            banqueService.debiter(1, 50);
            System.out.println("Compte débité");

          
            double solde = banqueService.getSolde(1);
            System.out.println("Solde du compte: " + solde);

            
            banqueService.supprimerCompte(2);
            System.out.println("Compte supprimé");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
