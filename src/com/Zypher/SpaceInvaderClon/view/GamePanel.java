package com.Zypher.SpaceInvaderClon.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import com.Zypher.SpaceInvaderClon.model.PlayerSpace; // Importante: Traemos la nave del otro paquete

public class GamePanel extends JPanel {

    // Referencia al jugador (para saber dónde pintarlo)
    private PlayerSpace player;

    /**
     * Constructor
     * @param player El objeto jugador que este panel debe dibujar
     */
    public GamePanel(PlayerSpace player) {
        this.player = player;

        // Opcional: Color de fondo del juego (Negro espacio)
        this.setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Borra lo anterior (limpia la pantalla)

        // 1. Elegimos color
        g.setColor(Color.GREEN); // O Color.RED, el que gustes

        // 2. Dibujamos el rectángulo del jugador
        // Le preguntamos al jugador: ¿Dónde estás? ¿Cuánto mides?
        g.fillRect(
                player.getxPos(),
                player.getyPos(),
                player.getWidth(),
                player.getHeight()
        );
    }
}