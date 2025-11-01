package com.pruebapoo.spaceinvaders;

/**
 * Punto de entrada del programa. Se encarga de crear la ventana principal del juego.
 */
public class LanzadorJuego {

    /**
     * Metodo principal para iniciar la aplicacion.
     *
     * @param argumentos Argumentos que se puedan pasar desde la consola (no se utilizan).
     */
    public static void main(String[] argumentos) {
        // Creamos la ventana del juego.
        VentanaJuego ventanaDelJuego = new VentanaJuego();

        // Hacemos visible la ventana para que el usuario pueda verla.
        ventanaDelJuego.setVisible(true);
    }
}
