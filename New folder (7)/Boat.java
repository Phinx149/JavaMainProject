public class Boat extends Vehicle {
    private String model;
    private double horsePower;
    public Boat(String Model,double Power){
        super.numVehicles=super.numVehicles+1;
        model=Model;
        horsePower=Power;

    }
    public String getModel(){
        return model;

    }
    public double getHorsepower(){
        return horsePower;
    }
    public void movingForward(){
        System.out.print("The boat moving forward");
    }
    public void movingBackward(){
        System.out.print("The boat is moving backwards");
    }

    public void hoistAnchor(){
        System.out.print("Boat hosting anchor");
    }
    public void dropAnchor(){
        System.out.print("Boat dropping anchor");
    }
    
}
