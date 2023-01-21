
/**
   interface ProiePredateur

**/

public interface ProiePredateur {
    public void naitre(); // animal becomes alive
    public void vieillir(); // animal is getting one year older
    public void manger(); // animal eats
    public Animal accoucher(); // animal delivers
    public void mourir(); // animal dies
    public boolean estVivant(); // animal is alive
    public boolean estMature(); // animal is mature
    public void setProie( boolean proie ); // set animal mode to prey
    public boolean estProie(); // animal is a prey
    public void setPredateur( boolean predateur ); // set animal mode to predator
    public boolean estPredateur(); // animal is a predator
    public double getMasse(); // get animal's mass
    public void setMasse( double masse ); // set animal's mass
    public void setAge( int age ); // set animal's age
    public int getAge(); // get animal's age
    public int getAgeMax(); // get animal's maximum age
    public int getAgeMature(); // get animal's mature age
}
