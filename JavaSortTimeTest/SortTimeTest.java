import java.util.*;

public class SortTimeTest{

     public static void main(String []args){
        
        
        Random rand = new Random();
        
        ArrayList<Integer> mylist = new ArrayList<Integer>();
        
      
        for (int x=0;x<100000;x++){
            int n = rand.nextInt(100000);
            mylist.add(n);
        }
        
        System.out.println(mylist.get(5));
        System.out.println(mylist.get(6));
        System.out.println(mylist.get(7));
        long startTime = System.nanoTime();
        Collections.sort(mylist);
        
        
        /*
        for (int i = 0; i < mylist.size() - 1; i++){
            int minPosition = i;
            for (int a = i + 1; a < mylist.size(); a ++){
                if(mylist.get(a) < mylist.get(minPosition)){
                    minPosition = a;
                }
            }
            int smallerNumber = mylist.get(minPosition);
            mylist.set(minPosition, mylist.get(i));
            mylist.set(i, smallerNumber);
        }
        */
        System.out.println(mylist.get(5));
        System.out.println(mylist.get(6));
        System.out.println(mylist.get(7));
        
        
        
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println(duration);
     }
}
