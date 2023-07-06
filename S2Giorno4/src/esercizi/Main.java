package esercizi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Product product1 = new Product(1L, "Libro 1", "Libri", 150.0);
		Product product2 = new Product(2L, "Libro 2", "Libri", 80.0);
		Product product3 = new Product(3L, "Giocattolo 1", "Giocattoli", 50.0);
		Product product4 = new Product(4L, "Prodotto per bambini 1", "Bambini", 120.0);
		Product product5 = new Product(5L, "Prodotto per ragazzi 1", "Ragazzi", 200.0);

		Customer customer1 = new Customer(1L, "Cliente 1", 1);
		Customer customer2 = new Customer(2L, "Cliente 2", 2);
		Customer customer3 = new Customer(3L, "Cliente 3", 2);

		List<Product> order1Products = new ArrayList<>();
		order1Products.add(product1);
		order1Products.add(product4);
		Order order1 = new Order(1L, "In attesa", LocalDate.of(2021, 3, 15), LocalDate.of(2021, 3, 20), order1Products,
				customer1);

		List<Product> order2Products = new ArrayList<>();
		order2Products.add(product3);
		Order order2 = new Order(2L, "Consegnato", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 15), order2Products,
				customer2);

		List<Product> order3Products = new ArrayList<>();
		order3Products.add(product2);
		order3Products.add(product5);
		Order order3 = new Order(3L, "Consegnato", LocalDate.of(2021, 3, 25), LocalDate.of(2021, 3, 30), order3Products,
				customer3);

		List<Product> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		products.add(product5);

		List<Order> orders = new ArrayList<>();
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);

		List<Product> libriCostosi = products.stream()
				.filter(product -> product.getCategory().equals("Libri") && product.getPrice() > 100)
				.collect(Collectors.toList());

		System.out.println("Libri costosi:");
		libriCostosi.forEach(libro -> System.out.println(libro.getName() + " - Prezzo: " + libro.getPrice()));
		System.out.println();

		List<Order> ordiniConProdottiBambini = orders.stream().filter(
				order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("Bambini")))
				.collect(Collectors.toList());

		System.out.println("Ordini con prodotti per bambini:");
		ordiniConProdottiBambini.forEach(order -> System.out
				.println("ID Ordine: " + order.getId() + " - Cliente: " + order.getCustomer().getName()));
		System.out.println();

		List<Product> prodottiRagazziScontati = products.stream()
				.filter(product -> product.getCategory().equals("Ragazzi"))
				.peek(product -> product.setPrice(product.getPrice() * 0.9)).collect(Collectors.toList());

		System.out.println("Prodotti per ragazzi scontati:");
		prodottiRagazziScontati.forEach(product -> System.out.println(product.getName() + " - Prezzo Originale: "
				+ product.getPrice() + " - Prezzo Scontato: " + (product.getPrice() * 0.9)));
		System.out.println();

		List<Order> ordiniClientiTierDue = orders.stream()
				.filter(order -> order.getCustomer().getTier() == 2
						&& order.getOrderDate().isAfter(LocalDate.of(2021, 2, 1))
						&& order.getOrderDate().isBefore(LocalDate.of(2021, 4, 1)))
				.collect(Collectors.toList());

		System.out.println("Prodotti ordinati da clienti di livello 2 tra il 01-Feb-2021 e il 01-Apr-2021:");
		ordiniClientiTierDue.forEach(order -> order.getProducts().forEach(product -> System.out
				.println("Prodotto: " + product.getName() + " - Data Ordine: " + order.getOrderDate())));
	}
}