package com.Zypher.SpaceInvaderClon.controller;

import com.Zypher.SpaceInvaderClon.model.PlayerSpace;
import com.Zypher.SpaceInvaderClon.view.GamePanel;

public class GameController implements Runnable {

    private PlayerSpace player;
    private GamePanel view;
    private boolean isRunning = false;

    private final int FPS = 60;
    private final int TARGET_TIME = 1000 / FPS;

    public GameController(PlayerSpace player, GamePanel view) {

        this.player = player;
        this.view = view;

    }

    public void start() {

        isRunning = true;
        Thread gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        while (isRunning) {

            long startTime = System.currentTimeMillis();

            update();

            view.repaint();

            long timeTaken = System.currentTimeMillis() - startTime;
            long waitTime = TARGET_TIME - timeTaken;

            try {

                if (waitTime > 0) {
                    Thread.sleep(waitTime);
                }

            } catch (InterruptedException e) {
                System.err.println("error durante el bucle de juego: " + e);
            }
        }
    }

    private void update() {
        player.tick(view.getWidth());
    }


}
