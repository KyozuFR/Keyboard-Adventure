package fr.ubordeaux.ao.keyboardadventure.controller;

import fr.ubordeaux.ao.keyboardadventure.model.Model;
import fr.ubordeaux.ao.keyboardadventure.view.View;

public class Controller {

    // Properties :
    private View view;
    private Model model;
    private BagOfCommands commands;

    // Constructors :
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.commands = new BagOfCommands();
    }

    // Methods :
    public void submitWord() {
        commands.add(() -> {
            model.submitWord();
        });
    }

    public void typeChar(char c) {
        commands.add(() -> {
            model.typeChar(c);
        });
    }

    public void eraseChar() {
        commands.add(() -> {
            model.eraseChar();
        });
    }

    public void executeAll() {
        commands.executeAll();
    }
}
