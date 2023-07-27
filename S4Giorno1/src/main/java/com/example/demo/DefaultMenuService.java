package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class DefaultMenuService implements MenuService {

    @Override
    public List<Pizza> getPizzas() {
        List<Pizza> pizzas = new ArrayList<>();

        List<Topping> capricciosaTopping = new ArrayList<>();
        capricciosaTopping.add(new Topping("Prosciutto", 50));
        capricciosaTopping.add(new Topping("Funghi", 30));
        capricciosaTopping.add(new Topping("Olive", 20));
        capricciosaTopping.add(new Topping("Peperoni", 25));
        Pizza margherita = new Pizza("Capricciosa", "Prosciutto,Funghi,Olive,Peperoni", 8.99, true, capricciosaTopping);

        List<Topping> hawaiianTopping = new ArrayList<>();
        hawaiianTopping.add(new Topping("Prosciutto", 50));
        hawaiianTopping.add(new Topping("Ananas", 40));
        Pizza hawaiian = new Pizza("Pizza Hawaii", "Margherita con prosciutto e ananas", 10.99, false, hawaiianTopping);

        pizzas.add(margherita);
        pizzas.add(hawaiian);


        return pizzas;
    }

    @Override
    public List<Beverage> getBeverages() {
        List<Beverage> beverages = new ArrayList<>();

        Beverage coke = new Beverage("Coca-Cola", "Bevanda analcolica gassata", 2.99, 150);
        Beverage water = new Beverage("Acqua", "Acqua naturale", 1.99, 0);

        beverages.add(coke);
        beverages.add(water);


        return beverages;
    }
}