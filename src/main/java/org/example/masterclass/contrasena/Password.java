package org.example.masterclass.contrasena;
import java.util.Random;
public class Password {
    private int longitud;
    private String contraseña;

    // Constructor por defecto
    public Password() {
        this.longitud = 8;
        generarPassword();
    }

    // Constructor con longitud personalizada
    public Password(int longitud) {
        this.longitud = longitud;
        generarPassword();
    }

    // Método para comprobar si la contraseña es fuerte
    public boolean esFuerte() {
        int mayusculas = 0, minusculas = 0, numeros = 0;

        for (int i = 0; i < contraseña.length(); i++) {
            char c = contraseña.charAt(i);
            if (Character.isUpperCase(c))
                mayusculas++;
            else if (Character.isLowerCase(c))
                minusculas++;
            else if (Character.isDigit(c))
                numeros++;
        }

        return mayusculas > 2 && minusculas > 1 && numeros > 5;
    }

    // Método para generar una contraseña aleatoria
    public void generarPassword() {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();

        String letrasMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
         //Une conjunto lestas y numeros
        String caracteres = letrasMayusculas + letrasMinusculas + numeros;

        for (int i = 0; i < longitud; i++) {
            //Posiciones de los caracteres
            int index = rnd.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }

        this.contraseña = sb.toString();
    }

    // Getters y Setters
    public String getContraseña() {
        return contraseña;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
        generarPassword();
    }
}