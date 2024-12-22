package com.example.banque;

import javax.jws.WebService;
import javax.jws.WebMethod;
import java.util.List;

@WebService
public interface BanqueService {
    @WebMethod
    double conversion(double mt);

    @WebMethod
    Compte getCompte();

    @WebMethod
    List<Compte> getComptes();

    @WebMethod
    void crediter(int codeCompte, double montant);

    @WebMethod
    void debiter(int codeCompte, double montant);

    @WebMethod
    double getSolde(int codeCompte);

    @WebMethod
    void supprimerCompte(int codeCompte);
}