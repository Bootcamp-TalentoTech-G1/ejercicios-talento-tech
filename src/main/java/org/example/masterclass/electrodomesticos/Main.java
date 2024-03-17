package org.example.masterclass.electrodomesticos;

/*
Crearemos una supeclase llamada Electrodomestico con las siguientes características:

Sus atributos son precio base, color, consumo energético (letras entre A y F) y peso. Indica que se podrán heredar.
Por defecto, el color sera blanco, el consumo energético sera F, el precioBase es de 100 € y el peso de 5 kg. Usa constantes para ello.
Los colores disponibles son blanco, negro, rojo, azul y gris. No importa si el nombre esta en mayúsculas o en minúsculas.
Los constructores que se implementaran serán
Un constructor por defecto.
Un constructor con el precio y peso. El resto por defecto.
Un constructor con todos los atributos.
Los métodos que implementara serán:
Métodos get de todos los atributos.
comprobarConsumoEnergetico(char letra): comprueba que la letra es correcta, sino es correcta usara la letra por defecto. Se invocara al crear el objeto y no sera visible.
comprobarColor(String color): comprueba que el color es correcto, sino lo es usa el color por defecto. Se invocara al crear el objeto y no sera visible.
precioFinal(): según el consumo energético, aumentara su precio, y según su tamaño, también. Esta es la lista de precios:
Letra	Precio
A	100 €
B	80 €
C	60 €
D	50 €
E	30 €
F	10 €
Peso	Precio
Entre 0 y 19 kg	10 €
Entre 20 y 49 kg	50 €
Entre 50 y 79 kg	80 €
Mayor que 80 kg	100 €
Crearemos una subclase llamada Lavadora con las siguientes características:
Su atributo es carga, ademas de los atributos heredados.
Por defecto, la carga es de 5 kg. Usa una constante para ello.
Los constructores que se implementaran serán:
Un constructor por defecto.
Un constructor con el precio y peso. El resto por defecto.
Un constructor con la carga y el resto de atributos heredados. Recuerda que debes llamar al constructor de la clase padre.
Los métodos que se implementara serán:
Método get de carga.
precioFinal():, si tiene una carga mayor de 30 kg, aumentara el precio 50 €, sino es así no se incrementara el precio.
Llama al método padre y añade el código necesario. Recuerda que las condiciones que hemos visto en la clase Electrodomestico también deben afectar al precio.
Crearemos una subclase llamada Television con las siguientes características:

Sus atributos son resolución (en pulgadas) y sintonizador TDT (booleano), ademas de los atributos heredados.
Por defecto, la resolución sera de 20 pulgadas y el sintonizador sera false.
Los constructores que se implementaran serán:
Un constructor por defecto.
Un constructor con el precio y peso. El resto por defecto.
Un constructor con la resolución, sintonizador TDT y el resto de atributos heredados. Recuerda que debes llamar al constructor de la clase padre.
Los métodos que se implementara serán:
Método get de resolución y sintonizador TDT.
precioFinal(): si tiene una resolución mayor de 40 pulgadas, se incrementara el precio un 30% y si tiene un sintonizador TDT incorporado, aumentara 50 €. Recuerda
que las condiciones que hemos visto en la clase Electrodomestico también deben afectar al precio.
Ahora crea una clase ejecutable que realice lo siguiente:

Crea un array de Electrodomesticos de 10 posiciones.
Asigna a cada posición un objeto de las clases anteriores con los valores que desees.
Ahora, recorre este array y ejecuta el método precioFinal().
Deberás mostrar el precio de cada clase, es decir, el precio de todas las televisiones por un lado, el de las lavadoras por otro y la suma de los Electrodomesticos (puedes crear objetos Electrodomestico, pero recuerda que Television y Lavadora también son electrodomésticos). Recuerda el uso operador instanceof.
Por ejemplo, si tenemos un Electrodomestico con un precio final de 300, una lavadora de 200 y una televisión de 500, el resultado final sera de 1000 (300+200+500) para electrodomésticos, 200 para lavadora y 500 para televisión.
 */

public class Main {
    public static void main(String[] args) {
        //Creamos un array de Electrodomesticos
        Electrodomestico listaElectrodomesticos[]=new Electrodomestico[10];

        //Asignamos cada una de las posiciones como queramos
        listaElectrodomesticos[0]=new Electrodomestico(200, 60, 'C', "Verde");
        listaElectrodomesticos[1]=new Lavadora(150, 30);
        listaElectrodomesticos[2]=new Television(500, 80, 'E', "negro", 42, false);
        listaElectrodomesticos[3]=new Electrodomestico();
        listaElectrodomesticos[4]=new Electrodomestico(600, 20, 'D', "gris");
        listaElectrodomesticos[5]=new Lavadora(300, 40, 'Z', "blanco", 40);
        listaElectrodomesticos[6]=new Television(250, 70);
        listaElectrodomesticos[7]=new Lavadora(400, 100, 'A', "verde", 15);
        listaElectrodomesticos[8]=new Television(200, 60, 'C', "naranja", 30, true);
        listaElectrodomesticos[9]=new Electrodomestico(50, 10);

        //Creamos las variables que usaremos para almacenar la suma de los precios
        double sumaElectrodomesticos=0;
        double sumaTelevisiones=0;
        double sumaLavadoras=0;

        //Recorremos el array invocando el metodo precioFinal
        for(int i=0;i<listaElectrodomesticos.length;i++){
            /*
             * Cuando una Television o una Lavadora este en la posicion del array actual,
             * pasara por su clase y por la de electrodomestico, ya que una television es un electrodomestico.
             * Ejecutamos en cada uno su propia version del metodo precioFinal
             */

            if(listaElectrodomesticos[i] instanceof Electrodomestico){
                sumaElectrodomesticos+=listaElectrodomesticos[i].precioFinal();
            }
            if(listaElectrodomesticos[i] instanceof Lavadora){
                sumaLavadoras+=listaElectrodomesticos[i].precioFinal();
            }
            if(listaElectrodomesticos[i] instanceof Television){
                sumaTelevisiones+=listaElectrodomesticos[i].precioFinal();
            }
        }

        //Mostramos los resultados
        System.out.println("La suma del precio de los electrodomesticos es de "+sumaElectrodomesticos);
        System.out.println("La suma del precio de las lavadoras es de "+sumaLavadoras);
        System.out.println("La suma del precio de las televisiones es de "+sumaTelevisiones);

    }


    }

