package fr.ubordeaux.ao.keyboardadventure.controller;

import java.util.LinkedList;
import java.util.Queue;

public enum BagOfCommands implements Runnable {

    INSTANCE;
    // Properties :
    private Queue<Command> commands = new LinkedList<>();;

    // Methods :
    public synchronized void add(Command command) {
        this.commands.add(command);
        notifyAll();
    }

    public void executeLast() {
        Command command = this.commands.poll();
        if(command == null) {
            return;
        }
        command.execute();
    }

    public void executeAll() {
        while(!commands.isEmpty()) {
            executeLast();
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                while (commands.isEmpty()) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                Command command = commands.poll();
                command.execute();

            }
        }

    }
}
