package com.pruebapoo.spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel principal del juego. Maneja los componentes visuales y las entradas de teclado.
 */
public class PanelJuego extends JPanel implements KeyListener {

    /**
     * Color de fondo utilizado para simular el cielo nocturno del juego.
     */
    private static final Color COLOR_FONDO = Color.BLACK;

    /**
     * Jugador principal del juego.
     */
    private final Jugador jugadorPrincipal;

    /**
     * Etiqueta informativa para guiar al usuario sobre los controles.
     */
    private final JLabel etiquetaDeAyuda;

    /**
     * Boton para iniciar o reiniciar el juego.
     */
    private final JButton botonIniciar;

    /**
     * Construye el panel, configura sus propiedades y agrega los componentes.
     */
    public PanelJuego() {
        super();

        // Desactivamos el layout automatico para controlar las posiciones manualmente con setBounds.
        setLayout(null);

        // Establecemos un color de fondo que represente el espacio.
        setBackground(COLOR_FONDO);

        // Permitimos que el panel pueda recibir el foco para capturar las teclas.
        setFocusable(true);

        // Registramos el panel como KeyListener para manejar los eventos de teclado.
        addKeyListener(this);

        // Creamos el jugador y lo agregamos al panel.
        jugadorPrincipal = new Jugador();
        add(jugadorPrincipal.obtenerEtiquetaJugador());

        // Creamos una etiqueta con instrucciones para mostrar al usuario los controles.
        etiquetaDeAyuda = crearEtiquetaDeAyuda();
        add(etiquetaDeAyuda);

        // Creamos un boton para iniciar el juego. Su funcionalidad se completara mas adelante.
        botonIniciar = crearBotonIniciar();
        add(botonIniciar);
    }

    /**
     * Crea una etiqueta con instrucciones de uso para colocar en la parte superior del panel.
     *
     * @return JLabel configurado con el texto de ayuda.
     */
    private JLabel crearEtiquetaDeAyuda() {
        JLabel etiqueta = new JLabel("Usa las teclas A y D para mover la nave.");
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setBounds(20, 20, 300, 20);
        return etiqueta;
    }

    /**
     * Crea el boton de inicio y lo coloca en la esquina inferior derecha.
     *
     * @return JButton configurado con la accion de iniciar.
     */
    private JButton crearBotonIniciar() {
        JButton boton = new JButton("Iniciar");
        boton.setBounds(650, 500, 100, 30);
        return boton;
    }

    /**
     * Dibuja un fondo adicional con estrellas para darle vida al panel.
     *
     * @param pincel Objeto de dibujo recibido del sistema Swing.
     */
    @Override
    protected void paintComponent(Graphics pincel) {
        super.paintComponent(pincel);

        // En cada repintado dibujamos algunos circulos que simulan estrellas.
        pincel.setColor(Color.DARK_GRAY);
        pincel.fillOval(100, 80, 10, 10);
        pincel.fillOval(300, 200, 8, 8);
        pincel.fillOval(600, 50, 12, 12);
        pincel.fillOval(500, 300, 6, 6);
    }

    /**
     * Maneja las teclas tipadas por el usuario.
     *
     * @param eventoTecla Evento de teclado recibido por el listener.
     */
    @Override
    public void keyTyped(KeyEvent eventoTecla) {
        char teclaPresionada = eventoTecla.getKeyChar();

        // Obtenemos los limites actuales del panel para calcular las posiciones.
        Rectangle limitesDelPanel = getBounds();

        // Segun la tecla presionada movemos al jugador.
        if (teclaPresionada == 'a' || teclaPresionada == 'A') {
            jugadorPrincipal.moverIzquierda();
        } else if (teclaPresionada == 'd' || teclaPresionada == 'D') {
            jugadorPrincipal.moverDerecha(limitesDelPanel);
        }

        // Solicitamos que se repinte el panel para reflejar la nueva posicion.
        repaint();
    }

    /**
     * No utilizamos este evento, pero debemos implementarlo por la interfaz KeyListener.
     */
    @Override
    public void keyPressed(KeyEvent eventoTecla) {
        // No implementado por ahora.
    }

    /**
     * No utilizamos este evento, pero debemos implementarlo por la interfaz KeyListener.
     */
    @Override
    public void keyReleased(KeyEvent eventoTecla) {
        // No implementado por ahora.
    }
}
