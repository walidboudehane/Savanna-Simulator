
/**
   class Herbe

**/

public class Herbe {
    
    // the maximum possible herb mass (upper limit)
    private double masseCritique;
    // current herb mass
    private double masse;
    // herb mass consumable in one year
    private double masseAnnuelle;
    // herb growth rate
    private double tauxCroissance;
    
    public Herbe( double masse, double masseCritique, double tauxCroissance ) {
        this.masse = masse;
        this.masseAnnuelle = 0.6 * this.masse; // backup herb of 60% of the current mass
        this.masseCritique = masseCritique;
        this.tauxCroissance = tauxCroissance;
    }
    // getters
    public double getMasseAnnuelle() { return masseAnnuelle; }
    // setters
    public void setMasseAnnuelle( double masseAnnuelle ){ this.masseAnnuelle = masseAnnuelle; }
    // behavior
    public void vieillir(){
        //this.masseAnnuelle = Math.max( 0, this.masseAnnuelle );
        this.masse = this.masse * 0.4 + this.masseAnnuelle;
        this.masse = Math.min( this.masse * this.tauxCroissance, this.masseCritique );
        this.masseAnnuelle = this.masse * 0.6; // backup herb of 60% of the current mass
    }
    public String toString() { return "[" + masse + " d'herbe]"; }
}
