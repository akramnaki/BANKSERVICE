package com.example.banque;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Server {

    public static void main(String[] args) {
        
        BanqueServiceImpl banqueService = new BanqueServiceImpl();
        
        Endpoint.publish("http://localhost:8080/banque", banqueService);
        System.out.println("Service Banque démarré à l'adresse http://localhost:8080/banque");
    }
}
