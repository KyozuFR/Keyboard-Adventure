package fr.ubordeaux.ao.keyboardadventure.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardController extends KeyAdapter{

    @Override
    public void keyTyped(KeyEvent key) {
        char c = key.getKeyChar();
        if (c == '\n') {
            //todo battle.submitWord();
        } else if (c == '\b') {
            //todo player.eraseChar();
        } else {
            //todo player.typeChar(c);
        }
    }
}
