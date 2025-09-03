import java.util.Scanner;
public class FunFormulas {
    Scanner scnr;
    public FunFormulas() {
        scnr = new Scanner(System.in);
    }
    public double getInput(String promtStr){

        double inputVal;
        System.out.print(promtStr);
        inputVal = scnr.nextDouble();
        while (inputVal<0){
            
            
            System.out.println(" Error: Please enter a non negative number!!!\n ");
            System.out.print(promtStr);
            inputVal = scnr.nextDouble();
        }
        return inputVal;
    }
    

    
    public void sd(){
        //Purpose of the funtion is to calculate the duration of the storm using hours
        
         double diamStorm = getInput("Enter the diameter of storm in miles: ");
         double durStorm = Math.sqrt(Math.pow(diamStorm, 3.0)/216);
         System.out.println("The duration of the storm is " + durStorm + " hours.");
        }
    public void ls(){
        //Purpose is to find the distance of the lightning strike form the observer 
        double timeDiff = getInput("Enter the number of seconds between the time you see the lighting and hear the thunder: ");
        double distLight = 1100*timeDiff;
        System.out.println("The distance to the lightning strike is approximately " + distLight + " meters.");
        }
    public void wi(){
        // Purpose is to find a weight of cube
        double edge = getInput("Enter the length of the edge of the cube measured in Cubic inches: ");
        double weightCube = 0.33*Math.pow(edge, 3.0);
        System.out.println("The weight of the ice cube is approximately " + weightCube + " grams.");
        }
    public void dt(){
        //Purpose is to find the the distance traveled in meters
        double rate = getInput("Enter the mile per hour traveled: ");
        double timeHour = getInput("Enter the hours traveled: ");
        double distTrav = rate*timeHour;
        System.out.println("The distance traveled is approximately " + distTrav + " miles.");
    }
    public void sa(){
        //Purpose is to find the body surface area
        double weightKg = getInput("Enter your weight in pounds: ");
        double heightCm = getInput("Enter your height in inches: ");
        double bsa = (Math.sqrt(heightCm*weightKg*(0.4536)*(2.54)))/60;
        System.out.println("Your body surface area is approximately " + bsa + " square meters.");
    }

 }
    

