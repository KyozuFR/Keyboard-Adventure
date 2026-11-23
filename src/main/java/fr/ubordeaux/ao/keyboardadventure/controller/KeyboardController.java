package fr.ubordeaux.ao.keyboardadventure.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardController extends KeyAdapter{

    // Properties :
    Controller controller;

    // Constructors :
    public KeyboardController(Controller controller) {
        super();
        this.controller = controller;
    }

    // Methods :
    @Override
    public void keyPressed(KeyEvent key) {
        System.out.println("Key pressed !");
        char c = key.getKeyChar();
        if (c == '\n') {
            controller.submitWord();
        } else if (c == '\b') {
            controller.eraseChar();
        } else {
            controller.typeChar(c);
        }
    }
}
