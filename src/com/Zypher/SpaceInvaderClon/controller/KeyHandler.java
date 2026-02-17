package com.Zypher.SpaceInvaderClon.controller;

import com.Zypher.SpaceInvaderClon.model.Bullet;
import com.Zypher.SpaceInvaderClon.model.PlayerSpace;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyHandler extends KeyAdapter {

    private PlayerSpace player;
    private ArrayList<Bullet> bullets;

    public KeyHandler(PlayerSpace player, ArrayList<Bullet> bullets) {

        this.player = player;

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        switch (code) {

            case (KeyEvent.VK_RIGHT):

                this.player.setDx(5);
                break;

            case (KeyEvent.VK_LEFT):

                this.player.setDx(-5);
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        // Lógica: Si suelta la tecla de dirección, paramos la nave.
        if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_LEFT) {
            player.setDx(0);
        }
    }
}
