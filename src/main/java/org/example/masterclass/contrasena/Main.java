package org.example.masterclass.contrasena;

/*
Haz una clase llamada Password que siga las siguientes condiciones:

Que tenga los atributos longitud y contraseña . Por defecto, la longitud sera de 8.
Los constructores serán los siguiente:
Un constructor por defecto.
Un constructor con la longitud que nosotros le pasemos. Generara una contraseña aleatoria con esa longitud.
Los métodos que implementa serán:
esFuerte(): devuelve un booleano si es fuerte o no, para que sea fuerte debe tener mas de 2 mayúsculas, mas de 1 minúscula y mas de 5 números.
generarPassword():  genera la contraseña del objeto con la longitud que tenga.
Método get para contraseña y longitud.
Método set para longitud.
 */
public class Main {
    public static void main(String[] args) {
        Password password = new Password(10);
        System.out.println("Contraseña generada: " + password.getContraseña());
        System.out.println("¿Es fuerte la contraseña? " + password.esFuerte());
    }
}
