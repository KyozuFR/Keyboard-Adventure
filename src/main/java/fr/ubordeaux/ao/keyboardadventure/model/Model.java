package fr.ubordeaux.ao.keyboardadventure.model;

import java.util.ArrayList;
import java.util.List;

public class Model implements Subject {

    // Properties:
    private Donjon donjon;
    private Player player;
    List<Observer> observers;

    // Constructors :
    public Model() {
        this.observers = new ArrayList<>();
    }

    // Methods :
    public void startDonjon(Player player, Donjon donjon) {
        this.donjon = donjon;
        donjon.run(player);
    }

    public void submitWord() {
        donjon.getCurrentBattle().playerSubmit();
        notifyObservers();
    }

    public void typeChar(char c) {
        player.writeChar(c);
        notifyObservers();
    }

    public void eraseChar() {
        player.eraseChar();
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update();
        }
    }
}
