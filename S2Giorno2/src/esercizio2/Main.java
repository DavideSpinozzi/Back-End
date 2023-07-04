package esercizio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		System.out.println();
		System.out.println(generateRandomNumberList(10));
		System.out.println();
		System.out.println(dioBestia(generateRandomNumberList(10)));
		System.out.println();
		dioStronzo(dioBestia(generateRandomNumberList(10)), false);
	}

	    public static List<Integer> generateRandomNumberList(int length) {
	        List<Integer> numberList = new ArrayList<>();
	        Random random = new Random();

	        for (int i = 0; i < length; i++) {
	            int randomNumber = random.nextInt(100) + 1;
	            numberList.add(randomNumber);
	        }

	        Collections.sort(numberList);

	        return numberList;
	    }
	

	public static List<Integer> dioBestia(List<Integer> lista1) {
		
		List<Integer> lista2 = new ArrayList<>(lista1);
        Collections.reverse(lista1);
        lista2.addAll(lista1);
        return lista2;
	}
	
	public static void dioStronzo(List<Integer> lista1, boolean x) {
		
		if (x) {
            
            for (int i = 0; i < lista1.size(); i += 2) {
                System.out.println(lista1.get(i));
            }
        } else {
           
            for (int i = 1; i < lista1.size(); i += 2) {
                System.out.println(lista1.get(i));
            }
		
	}
	
}
}
