package com.example.banque;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "com.example.banque.BanqueService")
public class BanqueServiceImpl implements BanqueService {
    private List<Compte> comptes = new ArrayList<>();

    @Override
    public double conversion(double mt) {
        return mt * 10.9; 
    }

    @Override
    public Compte getCompte() {
        Compte compte = new Compte();
        compte.setCode(1);
        compte.setSolde(1000.0);
        return compte;
    }

    @Override
    public List<Compte> getComptes() {
        Compte compte1 = new Compte();
        compte1.setCode(1);
        compte1.setSolde(1000.0);
        comptes.add(compte1);

        Compte compte2 = new Compte();
        compte2.setCode(2);
        compte2.setSolde(2000.0);
        comptes.add(compte2);

        return comptes;
    }

    @Override
    public void crediter(int codeCompte, double montant) {
        for (Compte compte : comptes) {
            if (compte.getCode() == codeCompte) {
                compte.setSolde(compte.getSolde() + montant);
                break;
            }
        }
    }

    @Override
    public void debiter(int codeCompte, double montant) {
        for (Compte compte : comptes) {
            if (compte.getCode() == codeCompte) {
                compte.setSolde(compte.getSolde() - montant);
                break;
            }
        }
    }

    @Override
    public double getSolde(int codeCompte) {
        for (Compte compte : comptes) {
            if (compte.getCode() == codeCompte) {
                return compte.getSolde();
            }
        }
        return 0;
    }

    @Override
    public void supprimerCompte(int codeCompte) {
        comptes.removeIf(compte -> compte.getCode() == codeCompte);
    }
}
