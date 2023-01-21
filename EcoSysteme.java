
/**
   interface EcoSysteme

**/

import java.util.ArrayList;

public interface EcoSysteme {
    public int getNombreProies(); // number of current preys
    public int getNombrePredateurs(); // number of current predators
    public int getNombreProiesMatures(); // number of current mature preys
    public int getNombrePredateursMatures(); // number of current mature predators
    public int getNombreProiesChassables(); // number of current chaseable preys
    public ArrayList<Animal> getIndividus(); // animals in the population
    public double masseProies(); // current total mass of preys
    public double massePredateurs(); // current toral mass of predators
    public void vieillir(); // getting older
    public void chasser(); // chasing
    public void reproduire(); // reproducing
    public void melanger(); // mix the list of animals
}
