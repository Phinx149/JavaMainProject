import java.util.Scanner;
public class ComputeBmi {
    public static double calcBmi(double weight, double height) {
         //Purpose: Calculate Bmie
         // Returns: Output
         double Bmi_result = 703*weight / (height*height);
         return Bmi_result;


    }
    public static void main(String[] args){
        double weight;
        double height;
        double result;
        Scanner scnr=new Scanner(System.in);
        ComputeBmi bmiObject=new ComputeBmi();//Creates bmi object
        System.out.print("Enter Weights in pounds: ");
        
        weight=scnr.nextDouble();
        
        System.out.print("Enter Height in inches: ");
        
        height=scnr.nextDouble();
        
        result=bmiObject.calcBmi(weight, height);// calls calc bmi function to using height and weight
        
        System.out.println("For weight: " +weight+" and height: "+ height +" inches ");
        System.out.println("The BMI is: " +result);



    }
}
