package com.Zypher.SpaceInvaderClon;

import javax.swing.JFrame;
import com.Zypher.SpaceInvaderClon.model.PlayerSpace;
import com.Zypher.SpaceInvaderClon.view.GamePanel;

public class Main {

    public static void main(String[] args) {
        // 1. CREAR EL MODELO (La Lógica)
        // Creamos la nave en la posición 300, 500 con tamaño 50x50
        PlayerSpace player = new PlayerSpace(300, 500, 50, 50);

        // 2. CREAR LA VISTA (El Lienzo)
        // Le pasamos el 'player' para que sepa qué dibujar.
        GamePanel panel = new GamePanel(player);


    }
}