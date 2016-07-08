import java.util.*;

public class selectionSort{

     public static void main(String []args){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Nick");
        names.add("Bob");
        names.add("Charlie");
        names.add("Alice");
        names.add("Jeff");
        names.add("Zack");
        names.add("Fred");
        names.add("Mike");
        names.add("Steven");
        names.add("Rodger");
        
        System.out.println(names);
        sortAlphabetical(names);
        System.out.println(names);
        sortReverse(names);
        System.out.println(names);
     }
    //Orders strings alphabetically with selection sort
    public static void sortAlphabetical(ArrayList<String> names){
        for(int x = 0; x<names.size();x++){
        int minIndex = x;
        for (int n = minIndex + 1; n<names.size();n++){
            if((names.get(n).compareTo(names.get(minIndex))) < 0){
                minIndex = n;
            }
        }
        String temp = names.get(x);
        names.set(x,names.get(minIndex));
        names.set(minIndex,temp);
        }
     }
    //Orders strings in reverse with selection sort
    public static void sortReverse(ArrayList<String> names){
        for(int x = 0; x<names.size();x++){
        int minIndex = x;
        for (int n = minIndex + 1; n<names.size();n++){
            if((names.get(n).compareTo(names.get(minIndex))) > 0){
                minIndex = n;
            }
        }
        String temp = names.get(x);
        names.set(x,names.get(minIndex));
        names.set(minIndex,temp);
        }
     }
}
