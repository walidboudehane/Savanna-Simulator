import java.util.ArrayList;
import java.util.Iterator;

public class TEST {
    
    public static void main(String args[]){

        int even = 0;

        ArrayList<Integer> nbr = new ArrayList<>(5);
        for (int i = 0 ; i < 10 ; i++){
            nbr.add(i+1);
        }

        ArrayList<Integer> nbr2 = new ArrayList<>(5);
        for (int i = 0 ; i < 5 ; i++){
            nbr2.add(i+11);
        }

        ArrayList<Integer> nbr3 = new ArrayList<>();

        nbr3.addAll(nbr);
        nbr3.addAll(nbr2);

        System.out.println(nbr);
        System.out.println(nbr2);
        System.out.println(nbr3);

        Iterator<Integer> it = nbr3.iterator();
        while(it.hasNext()){
            if (it.next() % 2 == 0){
                it.remove();
            }
        }
        System.out.println(nbr3);
        
        



        
        }
                   
         
    }

