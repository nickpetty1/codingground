import java.util.*;
import java.io.*;

public class HelloWorld{
     //Treemap used to store student names and grades
     static TreeMap <String,ArrayList<String>> myMap = new TreeMap<String,ArrayList<String>>();

     public static void main(String []args){
        GetInput();
     }
    
    //Gets user input to let user add, remove, modify, and print grades
    public static void GetInput(){
        Scanner in = new Scanner(System.in);
        int userInput;
        
        do{
            //Menu of choices
            System.out.println("Please enter the number for one of the following choices:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Modify Grade");
            System.out.println("4. Print Grades");
            System.out.println("5. Exit Program");
            userInput = in.nextInt();
            if(userInput == 1){
                //Gets input and uses AddStudent method
                System.out.println("Student Name:");
                String student = in.next();
                System.out.println("Grade:");
                String grade = in.next();
                AddStudent(student,grade);
            }else if(userInput == 2){
                //Gets input and uses RemoveStudent method
                System.out.println("Student Name:");
                String student = in.next();
                in.nextLine();
                RemoveStudent(student);
            }else if(userInput == 3){
                //Gets input and uses ModifyGrade method
                System.out.println("Student Name:");
                String student = in.next();
                System.out.println("Old Grade:");
                String oldGrade = in.next();
                System.out.println("New Grade:");
                String newGrade = in.next();
                ModifyGrade(student,oldGrade,newGrade);
            }else if(userInput == 4){
                //Prints all grades
                PrintAll();
            }
        //Loops until 5 is chosen on the menu
        }while(userInput < 5);
        
    }
     
    public static void AddStudent(String name, String grade){
        //Uses arraylist to store multiple values when the same name is used
        ArrayList<String> arraylist = new ArrayList<String>();
        //Checks if name is already used, if so it will add grade to the existing array
        if(myMap.get(name) == null){
            arraylist.add(grade);
            myMap.put(name,arraylist);
        }else{
            arraylist = myMap.get(name);
            arraylist.add(grade);
            Collections.sort(arraylist, Collections.reverseOrder());
            myMap.put(name,arraylist);
        }
    }
    //Removes student
    public static void RemoveStudent(String name){
        myMap.remove(name);
    }
    //Modifies grade, takes three inputs, old grade is used to differentiate
    //when students have the same name
    public static void ModifyGrade(String name, String oldGrade, String newGrade){
        ArrayList<String> arraylist = new ArrayList<String>();
        //When students have the same name, this will find old grade, remove it, and add new grade
        if(myMap.get(name).size() > 1){
            arraylist = myMap.get(name);
            arraylist.remove(oldGrade);
            arraylist.add(newGrade);
            Collections.sort(arraylist, Collections.reverseOrder());
            myMap.put(name,arraylist);
        }else{
            arraylist.add(newGrade);
            myMap.put(name,arraylist);
        }
    }
    
    public static void PrintAll(){
        //Prints output by looping through the TreeMap
        for (Map.Entry<String, ArrayList<String>> entry : myMap.entrySet()) {
            for(int i = 0;i < entry.getValue().size();i++){
                //Second for loop is for when there are multiple students with the same name
                System.out.print(entry.getKey() + ": ");
                System.out.println(entry.getValue().get(i));
            }
        }
    }
}
     
