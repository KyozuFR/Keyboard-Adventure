package fr.ubordeaux.ao.keyboardadventure.model;

public class ModelDonjon implements ModelState {

    private final Model model;
    private final Player player;
    private final Donjon donjon;

    public ModelDonjon(Model model, Player player, Donjon donjon) {
        this.model = model;
        this.player = player;
        this.donjon = donjon;
    }

    @Override
    public void typeChar(char c) {
        player.writeChar(c);
    }
    @Override
    public void eraseChar() {
        player.eraseChar();

    }
    @Override
    public void submitWord() {
        donjon.getCurrentBattle().playerSubmit();
    }
}
