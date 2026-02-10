package com.Zypher.SpaceInvaderClon.controller;

import com.Zypher.SpaceInvaderClon.model.PlayerSpace;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {

    private PlayerSpace player;

    public KeyHandler(PlayerSpace player) {

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

            default:

                this.player.setDx(0);
                break;
        }
    }
}
