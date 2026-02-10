package com.Zypher.SpaceInvaderClon;

import javax.swing.JFrame;
import com.Zypher.SpaceInvaderClon.controller.GameController;
import com.Zypher.SpaceInvaderClon.model.PlayerSpace;
import com.Zypher.SpaceInvaderClon.view.GamePanel;

public class Main {

    public static void main(String[] args) {

        // 1. CREAR EL MODELO (La Nave)
        // Posición X centrada (aprox), Y abajo, Ancho 50, Alto 50
        PlayerSpace player = new PlayerSpace(375, 500, 50, 50);

        // 2. CREAR LA VISTA (El Panel)
        // Le pasamos el modelo para que sepa qué pintar
        GamePanel panel = new GamePanel(player);

        // 3. CONFIGURAR LA VENTANA (El Marco)
        JFrame window = new JFrame("Space Invaders Clon - Zypher");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(panel);            // Metemos el dibujo dentro de la ventana
        window.setSize(800, 600);     // Tamaño de la ventana
        window.setResizable(false);   // Que no se pueda estirar
        window.setLocationRelativeTo(null); // Esto centra la ventana en tu pantalla
        window.setVisible(true);      // ¡Hágase la luz!

        // 4. CREAR Y ARRANCAR EL CONTROLADOR (El Motor)
        // Conectamos todo y encendemos el bucle del juego
        GameController controller = new GameController(player, panel);
        controller.start();
    }
}