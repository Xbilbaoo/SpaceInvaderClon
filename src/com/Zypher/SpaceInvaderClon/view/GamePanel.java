package com.Zypher.SpaceInvaderClon.view;

import com.Zypher.SpaceInvaderClon.model.Bullet;
import com.Zypher.SpaceInvaderClon.model.PlayerSpace;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList; // Importante
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    private PlayerSpace player;
    private ArrayList<Bullet> bullets; // <--- NUEVO: Referencia a la munición

    // Actualizamos el constructor para recibir las balas
    public GamePanel(PlayerSpace player, ArrayList<Bullet> bullets) {
        this.player = player;
        this.bullets = bullets; // <--- Guardamos la referencia
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 1. Pintar Fondo
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // 2. Pintar Jugador
        g.setColor(Color.GREEN);
        g.fillRect(player.getxPos(), player.getyPos(), player.getWidth(), player.getHeight());

        // 3. PINTAR BALAS (El Bucle Mágico)
        g.setColor(Color.YELLOW); // Las balas serán amarillas

        // Usamos un bucle for-each para recorrer la lista
        for (Bullet b : bullets) {
            g.fillRect(b.getxPos(), b.getyPos(), b.getWidth(), b.getHeight());
        }
    }
}