import java.util.*;
import java.io.*;
import java.lang.*;

public class BealeCipher{

     public static void main(String []args) throws IOException {
        File decFile = new File("Newfile.txt");
        BufferedReader dec= new BufferedReader(new FileReader(decFile));
        
        String[] words = (dec.readLine()).split(" ");
        List<String> wordList = new ArrayList<String>(Arrays.asList(words));

        
        File cipherFile = new File("cipher.txt");
        BufferedReader cipher = new BufferedReader(new FileReader(cipherFile));
        
        String[] numbers = cipher.readLine().split(", ");
        List<String> numberStrList = new ArrayList<String>(Arrays.asList(numbers));
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        
        for (int i = 0; i < numberStrList.size(); i++){
            numberList.add(Integer.parseInt(numberStrList.get(i)));
        }
        

        System.out.println((wordList.get(808).substring(0,1)).toLowerCase());
        
        ArrayList<String> decrypt = new ArrayList<String>();
        
        
        System.out.println(wordList.get(806));
        
        /*
        for(int i = 0; i < numberList.size(); i++){
            int cipherKey = numberList.get(i);
            String firstLetter = (wordList.get(cipherKey - 1).substring(0,1)).toLowerCase();
            decrypt.add(firstLetter);
        }
        
        for(int i = 0; i < decrypt.size(); i++){
            System.out.print(decrypt.get(i));
        }
        */
        

 
     }
}
