public class Helicopter extends Vehicle{
    private String model;
    private double power;
    public Helicopter(String Model,double Power){
        model=Model;
        power=Power;
        super.numVehicles++;
    }
    public String getModel(){
        return model;
    }
    public double getHorsepower(){
        return power;
    }
    public void movingForward(){
        System.out.print("Helicopter is moving forward");
    }
    public void movingBackward(){
        System.out.print("The Helicopter is moving backward");
    }
    
    public void moveUp(){
        System.out.println("Helicopter moving up");
    }
    public void moveDown(){
        System.out.println("Helicopter moving down");
    }
}
