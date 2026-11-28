package fr.ubordeaux.ao.keyboardadventure.view;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {

    // Properties :

    // Constructors :
    public Label(String text, int fontsize) {
        super(text);
        setOpaque(true);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setFont(new Font("Calibri", Font.BOLD, fontsize));
    }

    public Label() {
        this("", 21);
    }

    // Methods :


}
