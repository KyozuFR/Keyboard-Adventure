package fr.ubordeaux.ao.keyboardadventure.model.enemie;

public class dummyenemie extends  enemieDecorator{


    dummyenemie(Ienem enemie){
        super(enemie);
    }

    @Override
    public String getWord() {
        return enemie.getWord() + " dumbass";
    }
}
