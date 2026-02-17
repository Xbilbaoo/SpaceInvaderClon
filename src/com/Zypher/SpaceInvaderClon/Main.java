package com.Zypher.SpaceInvaderClon;

import javax.swing.JFrame;
import java.util.ArrayList; // Importante: Importar ArrayList

import com.Zypher.SpaceInvaderClon.controller.GameController;
import com.Zypher.SpaceInvaderClon.model.Bullet; // Importante: Importar Bullet
import com.Zypher.SpaceInvaderClon.model.PlayerSpace;
import com.Zypher.SpaceInvaderClon.view.GamePanel;

public class Main {

    public static void main(String[] args) {

        // 1. EL MODELO (Datos)
        PlayerSpace player = new PlayerSpace(375, 500, 50, 50);

        // --- NUEVO: La lista de balas nace aquí ---
        // El Main es el "dueño" de la munición y se la presta a todos.
        ArrayList<Bullet> bullets = new ArrayList<>();

        // 2. LA VISTA (El Panel)
        // Le pasamos al jugador Y la lista de balas compartida para que las pueda pintar
        GamePanel panel = new GamePanel(player, bullets);

        // 3. LA VENTANA
        JFrame window = new JFrame("Space Invaders Clon - Zypher");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(panel);
        window.setSize(800, 600);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // 4. EL CONTROLADOR
        // Le pasamos el jugador, el panel Y la misma lista de balas para que las gestione
        GameController controller = new GameController(player, panel, bullets);

        controller.start();
    }
}