/**
   class Animal
    implements the Prey/Predator relationship

**/
public class Animal implements ProiePredateur{

    protected double masse;
    protected int age;
    protected boolean proie;
    protected boolean predateur;
    protected boolean mature;
    protected boolean vivant=true;
    protected double facteurCroissance;

    public Animal(double facteurCroissance){
        this.facteurCroissance = facteurCroissance;
        naitre();
    }   

    // animal becomes alive
    public void naitre(){
        this.age = 0;
        this.masse = 10.0;
        vivant = true;
    } 

    // animal is getting one year older
    public void vieillir(){
        this.age ++;
        this.masse = this.masse * facteurCroissance;
    }

    // animal eats
    public void manger(){
        
    }

    // animal delivers
    public Animal accoucher(){
        return new Animal(facteurCroissance);
    }
    
    // animal dies
    public void mourir(){
        vivant=false;
    } 

    // animal is alive
    public boolean estVivant(){
        return vivant;
    } 

    // animal is mature
    public boolean estMature(){
        if (this.age >= getAgeMature()){
            mature = true;
        }
        else{
            mature = false;
        }
        return mature;
    }

    // set animal mode to prey
    public void setProie( boolean proie ){
        this.proie = proie;
    } 

    // animal is a prey
    public boolean estProie(){
        return this.proie;
    }

    // set animal mode to predator
    public void setPredateur( boolean predateur ){
        this.predateur = predateur;
    } 

    // animal is a predator
    public boolean estPredateur(){
        return this.predateur;
    }

    // get animal's mass
    public double getMasse(){
        return this.masse;
    }
    
    // set animal's mass
    public void setMasse( double masse ){
        this.masse = masse;
    }

    // set animal's age
    public void setAge( int age ){
        this.age = age;
    }

    // get animal's age
    public int getAge(){
        return this.age;
    } 

    // get animal's maximum age
    public int getAgeMax(){
        return -1;
    } 

    // get animal's mature age
    public int getAgeMature(){
        return -1;
    }

}
