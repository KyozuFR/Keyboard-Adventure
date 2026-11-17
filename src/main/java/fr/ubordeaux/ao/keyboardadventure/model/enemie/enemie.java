package fr.ubordeaux.ao.keyboardadventure.model.enemie;

public class enemie implements Ienem{
    private int HP = 1;
    private float speed = 1;
    private String word = "araigne";
    public  enemie(){

    }
    
    public enemie(int HP,float speed,String word){
        this.HP = HP;
        this.speed = speed;
        this.word = word;
    }

    @Override
    public String getWord() {
        return word;
    }

}
