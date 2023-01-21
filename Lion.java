

/**
   class Lion
    extends Animal

**/
public class Lion extends Animal{

    protected double facteurCroissanceLions;
    public static final int AGEMAX = 50;
    public static final int AGEMATURE = 5;
    protected Animal proie;

    public Lion(double facteurCroissanceLions){
        super(facteurCroissanceLions);
        setPredateur(true);
    }

    @Override
    public void manger(){
        setMasse(getMasse()+masseMangee());;
    }

    public double masseMangee(){
        return proie.getMasse();
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
        this.masse *=  facteurCroissance;
        if (getAge() > getAgeMax()){
            mourir();
        }
    }

    @Override
    public Animal accoucher(){
        return new Lion(facteurCroissance);
    }

}
