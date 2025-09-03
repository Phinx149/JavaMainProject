
public class WindChill {
    public static double findWindchill(double T, double W){
        //Purpose: Helps find the wind chill using temperature and wind velocity
        double windChillCalc=35.74+0.6215*T-35.75*Math.pow(W,0.16)+0.4275*T*Math.pow(W,0.16);

        return windChillCalc;



    }
    public static void main(String args[]){
        double tempFar;
        double windVelocity;
        double result;
        
        tempFar=Double.parseDouble(args[0]);
        windVelocity=Double.parseDouble(args[1]);
        result=findWindchill(tempFar,windVelocity);
        System.out.println("The wind-chill at Temperature: "+tempFar+" Fahrenheit and Wind speed: "+windVelocity+" mph");
        System.out.println("is "+result+" degrees Fahrenheit");
        

        

    }
}
