package giorno2.esercizio1;

public class Rettangolo {
	
 private double h;
 private double b;
 
public Rettangolo(double h, double b) {
	this.h = h;
	this.b = b;
}

public double getH() {
	return h;
}

public void setH(double h) {
	this.h = h;
}

public double getB() {
	return b;
}

public void setB(double b) {
	this.b = b;
}

public double perimetro() {
	return (h+b)*2;
}
 
public double area() {
	return h*b;
}

}
