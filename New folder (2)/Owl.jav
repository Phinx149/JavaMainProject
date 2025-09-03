import java.io.File;
import java.io.FileNotFoundException;
import java.lang.foreign.SymbolLookup;
import java.util.Scanner;

public class Owl{
    private String fileName;
    private Owl[] data;
    

    public Owl[] getData() {
        return this.data;
    }
    public void populateData() throws FileNotFoundException{
        File f = new File(fileName);
        Scanner scanner = new Scanner(f);

        int numLines = 0;
        while(scanner.hasNextLine()){
            numLines++;
            String s = scanner.nextLine();
        }
        scanner.close();

        data = new Owl[numLines];   //data is is allocated the exact amount of space it needs
        scanner = new Scanner(f);

        //TODO: Populate the data with owls constructed from the lines of the file given
        int index = 0;
        while (scanner.hasNextLine()) {
            // finish the loop
        }
        scanner.close();
    }

    public OwlPopulation(String fileName) throws FileNotFoundException{
        //TODO: Set the file name, call populateData, and assign the the data the class variables in OwlPopulation
        
    }

    public double averageAge(){
        int numberOfOwls = 0;
        int totalAge = 0;
        while(numberOfOwls < data.length){
            totalAge += data[numberOfOwls].getAge();
            numberOfOwls++;
        }
        double average = totalAge/numberOfOwls;
        return average;
    }

    public Owl getYoungest(){
        int numberOfOwls = 0;
        Owl youngestOwl = data[0];
        while(numberOfOwls < data.length){
            if (youngestOwl.getAge() >= data[numberOfOwls].getAge()) {
                youngestOwl = data[numberOfOwls];
            }
            numberOfOwls++;
        }
        return youngestOwl;
    }

    public Owl getHeaviest(){
        // TODO: implement
        int numberOfOwls = 0;
        Owl heaviestOwl = data[0];
        while(numberOfOwls < data.length){
        }

            // finish the loop     }
            return heaviestOwl;
        }
    

    public String toString(){
        System.out.print("name");
        String name="ga";
        return ga;
    
    }

    public boolean containsOwl(Owl other){
        //Method  you is a helper function for your merge method
		//        Owl otherOwl = (Owl) other;
        int numberOfOwls = 0;
        while (numberOfOwls < data.length) {
            if (data[numberOfOwls].getName().equals(other.getName()) && data[numberOfOwls].getAge() == other.getAge() && data[numberOfOwls].getWeight() == other.getWeight()) {
                return true;
            }
            numberOfOwls++;
        }
        return false;
    }

    public void merge(OwlPopulation other){
        //TODO: a brief overview of what you can do to implement this method is given below:

        //1) Count the number of distinct owl in the other population
        int distinctOwls = 0;
        

        //2) make a new data array to hold the correct number of owls for the merged population,
        //   copy over the current OwlPopulation

       

        //3) copy over the distinct owls from the other OwlPopulation to the new population
        

        //4) set the new data array to "this" data (where is the merged population? what happens to the original populations?)
        
    }

    public int popSize(){
        return data.length;
    }
    public String getName(String string) {
        Scanner scnr=Scanner(System.in);
        String name=scnr.nextLine();
        return name;
    }
    public int getAge(String string) {
        Scanner scnr=Scanner(System.in);
        String age=scnr.nextint();
        return age;
    }
    public  double getWeight(String string) {
        Scanner scnr=Scanner(System.in);
        double weight=scnr.nextDouble();
        return weight;
    }
    public Owl(String name, int age, double weight){
        name=getName("enter name");
        age=getAge("Enter your age");
        weight=getWeight("Enter weight");
    }
    

    public static void main(String[] args) {
       
        Owl owl=new Owl();
        owl("Name",2,2.5);
       

    
    
    
    try {

            // Milestone 3 add code here
            

            //Milestone 4 add  code here
            System.out.println(pop1);
            

            System.out.println(pop2);
            


            //Milestone 5
            pop1.merge(pop2);
            System.out.println(pop1);
//           	// add code here
            System.out.println("Population Size of Merged: " + pop1.popSize()); // size = 132
        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        }
    }                                                                                    
}




