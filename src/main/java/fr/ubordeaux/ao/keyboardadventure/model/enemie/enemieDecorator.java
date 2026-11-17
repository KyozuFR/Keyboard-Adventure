package fr.ubordeaux.ao.keyboardadventure.model.enemie;

abstract class enemieDecorator implements  Ienem{
    protected  final Ienem enemie;

    protected enemieDecorator(Ienem enemie){
        this.enemie = enemie;
    }   
    
}
