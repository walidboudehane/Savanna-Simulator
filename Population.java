// Fichier :     Population.java
// Création:     
// Auteurs :     
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

/**
   class Population
    implements EcoSysteme, Iterable<Animal>

**/

import java.util.Iterator;
import java.lang.Iterable;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

// Defines a population of herb and animals (preys and predators), iterable
public class Population implements EcoSysteme, Iterable<Animal> {

    // TO BE COMPLETED //
    private ArrayList<Animal> individus = new ArrayList<>();
    

    
    protected int nombreProies = 0;
    protected double masseProies = 0;
    protected int nombrePredateurs = 0; 
    protected double massePredateurs = 0;
    protected Herbe herbe; 
    

    public Population( Herbe herbe, ArrayList<Animal> proies, ArrayList<Animal> predateurs ) {

        nombreProies = proies.size();
        nombrePredateurs = predateurs.size();
        individus.addAll(proies);
        individus.addAll(predateurs);
        this.herbe = herbe;
    }

    public Herbe getHerbe(){
        return this.herbe;
    }
    
	
    // number of current preys
    public int getNombreProies(){
        return nombreProies;  
    } 

    // number of current predators
    public int getNombrePredateurs(){
        return nombrePredateurs;
    }

    // number of current mature preys
    public int getNombreProiesMatures(){
        int nombreProiesMatures = 0;

        for (Animal a : individus){
            if (a.estProie() && a.estMature() && a.estVivant()){
                nombreProiesMatures ++;
            }
        }
        return nombreProiesMatures;
    }

    // number of current mature predators
    public int getNombrePredateursMatures(){
        int nombrePredateursMatures = 0;

        for (Animal a : individus){
            if (a.estPredateur() && a.estMature() && a.estVivant()){
                nombrePredateursMatures ++; 
            }
        }
        return nombrePredateursMatures;
    }

    // number of current chaseable preys
    public int getNombreProiesChassables(){
        return (int) Math.floor(nombreProies * 0.2);
    } 

    // animals in the population
    public ArrayList<Animal> getIndividus(){
        return this.individus;
    } 

    // current total mass of preys
    public double masseProies(){
        double masseProies = 0;

        for (Animal a : individus){
            if (a.estProie()){
                masseProies += a.getMasse();
            }
        }
        return masseProies;
    }

    // current toral mass of predators
    public double massePredateurs(){
        double massePredateurs = 0;

        for (Animal a : individus){
            if (a.estPredateur()){
                massePredateurs += a.getMasse();
            }
        }
        return massePredateurs;
    } 

    // getting older
    public void vieillir(){

        ArrayList<Animal> individus2 = new ArrayList<>();
        Iterator<Animal> it = individus.iterator();
        herbe.vieillir();

        while(it.hasNext()){

            Animal currentAnimal = it.next();

            currentAnimal.vieillir();

            if (!currentAnimal.estVivant()){
                //it.remove();

                if (currentAnimal.estPredateur()){
                    nombrePredateurs--;
                }
                else{
                    nombreProies--;
                }
            } 
        }
        
        for (Animal a : individus){
            if (a.estVivant()){
                individus2.add(a);
            }
        }

        individus = individus2;
           
    }

    // chasing
    public void chasser(){
        melanger();
        ArrayList<Animal> individus2 = new ArrayList<>();
        int nombreProiesAchasser = 0;
        int nombreDeProieChassee = 0;
        ArrayList<Animal> proiechassable = new ArrayList<>();

        Iterator<Animal> itProie = individus.iterator();
        Iterator<Animal> itPredateur = individus.iterator();

        Iterator<Animal> itPC = individus.iterator();

        while(itProie.hasNext()){
            Animal currentAnimal = itProie.next();
            double masseAmangerProie = currentAnimal.getMasse()*2;

            if(currentAnimal.estProie() && currentAnimal.estVivant() && (masseAmangerProie <= herbe.getMasseAnnuelle())){
                
                herbe.setMasseAnnuelle(herbe.getMasseAnnuelle() - masseAmangerProie);
            }
            else if (currentAnimal.estProie() && currentAnimal.estVivant()){
                currentAnimal.mourir();
                nombreProies--;
            }

            
        }

        while(itPC.hasNext()){
            Animal currentA = itPC.next();
            if (currentA.estProie() && currentA.estVivant() && (nombreProiesAchasser < getNombreProiesChassables()) ){
                proiechassable.add(currentA);
                nombreProiesAchasser++;
            }

        }
 
        while(itPredateur.hasNext()){
            Animal currentAnimal = itPredateur.next();
            double masseAmangerPredateur = currentAnimal.getMasse()*2;

            if(currentAnimal.estPredateur() && (nombreDeProieChassee < nombreProiesAchasser)){

                Iterator<Animal> pC = proiechassable.iterator();
                double masseMangee=0;

                while(pC.hasNext() && (masseMangee < masseAmangerPredateur)){
                    Animal currentProie = pC.next();
                    
                    if (currentProie.estVivant()){
                        masseMangee += currentProie.getMasse();      
                        currentProie.mourir();
                        nombreProies--; 
                        nombreDeProieChassee++; 
                    }
                }
            }
            else if(currentAnimal.estPredateur()) {
                currentAnimal.mourir();
                
                nombrePredateurs--;
            }
            
        } 

        for (Animal a : individus){
            if (a.estVivant()){
                individus2.add(a);
            }
        }
            
        individus = individus2;
    }
    

    // reproducing
    public void reproduire(){
        ArrayList<Animal> bebes = new ArrayList<>();
        int nombreBebePredateurs = 0;
        int nombreBebeProies = 0;
        int MaxBebePredateurs = getNombrePredateursMatures() / 2 ;
        int MaxBebeProies = getNombreProiesMatures() / 2 ;
        
        Iterator<Animal> it = individus.iterator();

        while(it.hasNext()){
            Animal currentAnimal = it.next();
            if(currentAnimal.estMature() && currentAnimal.estVivant() && currentAnimal.estProie() && (nombreBebeProies < MaxBebeProies)){
                bebes.add(currentAnimal.accoucher());
                nombreBebeProies++;
                nombreProies++;
            }
            else if(currentAnimal.estMature() && currentAnimal.estVivant() && currentAnimal.estPredateur() && (nombreBebePredateurs < MaxBebePredateurs) ){
                bebes.add(currentAnimal.accoucher());
                nombreBebePredateurs++;
                nombrePredateurs++;
            }
                
        }
        individus.addAll(bebes);   
    } 

    // mix the list of animals
    public void melanger(){
        Collections.shuffle(this.individus, new Random(4));
    }

    public Iterator<Animal> iterator() {
        
        return individus.iterator();
    } 


    // TO BE COMPLETED //

}
