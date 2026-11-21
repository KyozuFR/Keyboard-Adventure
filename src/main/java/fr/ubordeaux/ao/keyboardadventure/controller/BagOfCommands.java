package fr.ubordeaux.ao.keyboardadventure.controller;

import java.util.LinkedList;
import java.util.Queue;

public class BagOfCommands {

    // Properties :
    private Queue<Command> commands;

    // Constructors :
    public BagOfCommands() {
        this.commands = new LinkedList<>();
    }

    // Methods :
    public void add(Command command) {
        this.commands.add(command);
    }

    public void executeLast() {
        Command command = this.commands.poll();
        if(command == null) {
            return;
        }
        command.execute();
    }

    public void executeAll() {
        for(Command command : commands) {
            command.execute();
        }
        this.commands.clear();
    }
}
