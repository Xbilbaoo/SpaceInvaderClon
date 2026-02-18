package com.Zypher.SpaceInvaderClon.view;

import com.Zypher.SpaceInvaderClon.model.Alien;
import com.Zypher.SpaceInvaderClon.model.Bullet;
import com.Zypher.SpaceInvaderClon.model.PlayerSpace;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList; // Importante
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    private PlayerSpace player;
    private ArrayList<Bullet> bullets;
    private ArrayList<Alien> aliens;// <--- NUEVO: Referencia a la munición

    // Actualizamos el constructor para recibir las balas
    public GamePanel(PlayerSpace player, ArrayList<Bullet> bullets, ArrayList<Alien> aliens) {
        this.player = player;
        this.bullets = bullets;
        this.aliens = aliens;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Paint the background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Paint the player
        g.setColor(Color.GREEN);
        g.fillRect(player.getxPos(), player.getyPos(), player.getWidth(), player.getHeight());

        g.setColor(Color.YELLOW); // Las balas serán amarillas

        // Usamos un bucle for-each para recorrer la lista
        for (Bullet b : bullets) {
            g.fillRect(b.getxPos(), b.getyPos(), b.getWidth(), b.getHeight());
        }

        g.setColor(Color.MAGENTA);
        for (Alien a : aliens) {
            g.fillRect(a.getxPos(), a.getyPos(), a.getWidth(), a.getHeight());
        }
    }
}