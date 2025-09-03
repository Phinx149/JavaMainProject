public class Bus {
    private Passenger[] passenger;
    private int Capacity;
    private int occupied;
    public Bus(){
        Capacity=40;
        passenger=new Passenger[40];
        occupied=0;
    }
    public Bus(int capacity){
        Capacity=capacity;
        Passenger[] passenger=passenger[Capacity];
        occupied=0;

    }
    public int get_Capacity(){
        return Capacity;
    }
    public void set_Capacity(int capacity){
        Capacity=capacity;
    }
    public int numberOfPassengers(){
        return occupied;
    }
    public Passenger[] get_bus(){
        return passenger;
    }

    public void add_Passenger(Passenger p){
        
        if (Capacity==occupied){
            System.out.print("the bus is full");

        }else{

            for (int i;i<array.length;i++){
                if (passenger[i]==null){
                    passenger[i]=p;
                    occupied=occupied+1;
                    break;


                }

            }


        }

        }
}
   

