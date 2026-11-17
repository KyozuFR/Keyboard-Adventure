package fr.ubordeaux.ao.keyboardadventure.model.enemie;

public class enemieBuilder {

    private Ienem enemie;

    private enemieBuilder(enemie enemie){
        this.enemie = enemie;
    }

    public static enemieBuilder baseEnemy(){
        return  new enemieBuilder(new enemie());
    }

    public enemieBuilder dummyEnemy(){
        this.enemie = new dummyenemie(enemie);
        return this;
    }

    public Ienem build(){
        return  enemie;
    }

}
