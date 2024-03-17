package org.example.masterclass.interpretacióndiagramadeclases.figuras;

public class PruebaFiguras {
    /**
     * Método main que crea un círculo, un rectángulo, un cuadrado y
     * un triángulo rectángulo. Para cada uno de estas figuras geométricas,
     * se calcula su área y perímetro.
     */
    public static void main(String args[]) {
        Círculo figura1 = new Círculo(2);
        Rectángulo figura2 = new Rectángulo(1,2);
        Cuadrado figura3 = new Cuadrado(3);
        TrianguloRectangulo figura4 = new TrianguloRectangulo(3,5);
        System.out.println("El área del círculo es = " + figura1.
                calcularArea());
        System.out.println("El perímetro del círculo es = "  + figura1.
                calcularPerímetro());
        System.out.println();
        System.out.println("El área del rectángulo es = " + figura2.
                calcularArea());
        System.out.println("El perímetro del rectángulo es = " + figura2.
                calcularPerímetro());
        System.out.println();
        System.out.println("El área del cuadrado es = " + figura3.
                calcularArea());
        System.out.println("El perímetro del cuadrado es = " + figura3.
                calcularPerímetro());
        System.out.println();
        System.out.println("El área del triángulo es = " + figura4.
                calcularArea());
        System.out.println("El perímetro del triángulo es = " + figura4.
                calcularPerímetro());
        figura4.determinarTipoTriángulo();
    }
}
