package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S4Giorno1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(S4Giorno1Application.class, args);
        System.out.println("Hello World");
    }

    @Autowired
    private MenuService menuService;

    public void run(String... args) {
        
        List<Pizza> pizze = menuService.getPizzas();
        List<Beverage> bevande = menuService.getBeverages();

        
        Tavolo tavolo1 = new Tavolo(1, 4);

        Ordine ordine1 = new Ordine(4);
        ordine1.aggiungiElementoMenu(pizze.get(0)); 
        ordine1.aggiungiElementoMenu(bevande.get(0));

        
        ordine1.setStato(StatoOrdine.PRONTO);

        
        System.out.println("Ordine #" + ordine1.getNumeroOrdine());
        System.out.println("Stato: " + ordine1.getStato());
        System.out.println("Numero Coperti: " + ordine1.getNumeroCoperti());
        System.out.println("Ora Acquisizione: " + ordine1.getOraAcquisizione());
        System.out.println("Elementi del Menu:");
        for (ElementoMenu elementoMenu : ordine1.getElementi()) {
            System.out.println("- " + elementoMenu.getNome() + " (" + elementoMenu.getDescrizione() + ") - Prezzo: " + elementoMenu.getPrezzo());
        }
        System.out.println("Importo Totale: " + ordine1.getImportoTotale());
    }
}