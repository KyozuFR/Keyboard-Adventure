package fr.ubordeaux.ao.keyboardadventure.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardController extends KeyAdapter{

    @Override
    public void keyTyped(KeyEvent key) {
        System.out.println("key:" + key.getKeyChar());
    }
}
