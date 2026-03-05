package com.Zypher.SpaceInvaderClon.controller;

import com.Zypher.SpaceInvaderClon.model.PlayerSpace;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * This class handles key events (movement and actions) of the player and game.
 *
 * @version 0.1
 * @author Zypher
 */

public class KeyHandler extends KeyAdapter {

    private final PlayerSpace player;
    private final GameController gameCtrl;

    /**
     * Standard Constructor to this Key Handler.
     * @param player Player instance
     * @param gameCtrl Controller instance
     */

    public KeyHandler(PlayerSpace player, GameController gameCtrl) {

        this.player = player;
        this.gameCtrl = gameCtrl;

    }

    /**
     * Method to do actions when the player presses the play buttons.
     *
     * @param e The key that the user is pressing.
     */

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

            case (KeyEvent.VK_SPACE):

                this.gameCtrl.shoot();
                break;

        }
    }

    /**
     * Method to stop any action when player want to stop moving.
     *
     * @param e The key that the user is releasing.
     */

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_LEFT) {
            player.setDx(0);
        }
    }
}
