// Fichier :     Antilope.java
// Création:     
// Auteurs :     
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

/**
   class Antilope
    extends Animal

**/
public class Antilope extends Animal{

    protected double facteurCroissanceAntilopes;
    public static final int AGEMAX = 15;
    public static final int AGEMATURE = 2;

    public Antilope(double facteurCroissanceAntilopes){
        super(facteurCroissanceAntilopes);
        setProie(true);
    }

    @Override
    public void manger(){
        double masseAmanger = getMasse()*2;
        setMasse(getMasse() + masseAmanger);
    }

    @Override
    public int getAgeMax(){
        return AGEMAX;
    } 

    @Override
    public int getAgeMature(){
        return AGEMATURE;
    }

    @Override
    public void vieillir(){
        this.age ++;
        this.masse = this.masse * facteurCroissance;
        if (getAge() > getAgeMax()){
            mourir();
        }
    }

    @Override
    public Animal accoucher(){
        return new Antilope(facteurCroissance);
    }

}
