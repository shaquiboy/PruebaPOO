package com.pruebapoo.spaceinvaders;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JLabel;

/**
 * Representa al jugador dentro del juego. Utilizamos un JLabel para dibujarlo.
 */
public class Jugador {

    /**
     * Tamano lateral del jugador (un cuadrado simple por ahora).
     */
    private static final int TAMANO_JUGADOR = 40;

    /**
     * Velocidad en pixeles con la que el jugador se desplaza al presionar una tecla.
     */
    private static final int VELOCIDAD_JUGADOR = 10;

    /**
     * Componente visual del jugador.
     */
    private final JLabel etiquetaJugador;

    /**
     * Crea al jugador inicializando su posicion y estilo grafico.
     */
    public Jugador() {
        etiquetaJugador = new JLabel();

        // Definimos el tamano y la posicion inicial del jugador usando bounds.
        etiquetaJugador.setBounds(380, 500, TAMANO_JUGADOR, TAMANO_JUGADOR);

        // Establecemos un color de fondo para que sea visible y un borde simple.
        etiquetaJugador.setOpaque(true);
        etiquetaJugador.setBackground(Color.GREEN);
    }

    /**
     * Devuelve el componente grafico del jugador para agregarlo a un panel.
     *
     * @return JLabel que representa al jugador en la pantalla.
     */
    public JLabel obtenerEtiquetaJugador() {
        return etiquetaJugador;
    }

    /**
     * Mueve al jugador hacia la izquierda asegurando que permanezca dentro del panel.
     */
    public void moverIzquierda() {
        int nuevaPosicionX = Math.max(0, etiquetaJugador.getX() - VELOCIDAD_JUGADOR);
        etiquetaJugador.setLocation(nuevaPosicionX, etiquetaJugador.getY());
    }

    /**
     * Mueve al jugador hacia la derecha respetando el limite del panel recibido.
     *
     * @param limitesPanel Rectangulo que representa el area disponible dentro del panel.
     */
    public void moverDerecha(Rectangle limitesPanel) {
        int maximaPosicionX = limitesPanel.width - etiquetaJugador.getWidth();
        int nuevaPosicionX = Math.min(maximaPosicionX, etiquetaJugador.getX() + VELOCIDAD_JUGADOR);
        etiquetaJugador.setLocation(nuevaPosicionX, etiquetaJugador.getY());
    }
}
