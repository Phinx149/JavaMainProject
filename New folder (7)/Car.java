public class Car extends Vehicle{
    private String model;
    private double power;
    public Car(String Model,double Power){
        model=Model;
        power=Power;
        super.numVehicles=super.numVehicles+1;
    }
    public String getModel(){
        return model;
    }
    public double getPower(){
        return power;
    }
    public void movingForward(){
        System.out.println("Car moving forward");
    }
    public void movingBackward(){
        System.out.println("Car is moving backward");
    }                                                                                                                                                                                                                     
    
}
