package fr.ubordeaux.ao.keyboardadventure.model;

public interface ModelState {
    void typeChar(char c);
    void eraseChar();
    void submitWord();
}
