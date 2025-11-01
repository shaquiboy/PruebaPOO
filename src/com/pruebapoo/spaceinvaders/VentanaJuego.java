package com.pruebapoo.spaceinvaders;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Ventana principal del juego. Aqui definimos el tamano y ajustes basicos de la GUI.
 */
public class VentanaJuego extends JFrame {

    /**
     * Ancho en pixeles de la ventana del juego.
     */
    private static final int ANCHO_VENTANA = 800;

    /**
     * Alto en pixeles de la ventana del juego.
     */
    private static final int ALTO_VENTANA = 600;

    /**
     * Panel principal donde se dibujaran todos los elementos del juego.
     */
    private final PanelJuego panelDelJuego;

    /**
     * Construye la ventana del juego configurando todas las propiedades basicas.
     */
    public VentanaJuego() {
        super("Space Invaders - Prueba POO");

        // Creamos el panel principal que contendra los componentes del juego.
        panelDelJuego = new PanelJuego();

        // Ajustamos la ventana: tamano, cierre y posicion.
        configurarVentana();

        // Agregamos el panel al contenido de la ventana.
        add(panelDelJuego);
    }

    /**
     * Configura las propiedades principales de la ventana.
     */
    private void configurarVentana() {
        // Definimos el tamano preferido para la ventana.
        setPreferredSize(new Dimension(ANCHO_VENTANA, ALTO_VENTANA));

        // Aseguramos que se adapte al tamano preferido de su contenido.
        pack();

        // Permitimos que la ventana cierre la aplicacion al presionar la X.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Evitamos que el usuario cambie el tamano para mantener la relacion del juego.
        setResizable(false);

        // Centramos la ventana en la pantalla del usuario.
        setLocationRelativeTo(null);
    }

    /**
     * Devuelve el panel principal del juego.
     *
     * @return Panel donde se administran los componentes y movimientos del juego.
     */
    public PanelJuego obtenerPanelDelJuego() {
        return panelDelJuego;
    }
}
