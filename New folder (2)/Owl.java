public class Owl {
    String Name;
    int Age;
    double Weight;
    public Owl(String name, int age, double weight){
        Name=name;
        Age=age;
        Weight=weight;

    }
    public boolean Equals(Owl owl1, Owl owl2) {
        if (owl1.Name.equals(owl2.Name)& owl1.Age==owl2.Age & owl1.Weight==owl2.Weight){
            return true;

        }else{
            return false;
        }
    
    }
    public int getAge(){
        return Age;

    }
    public String getName(){
        return Name;
    }
    public String getWeight(){
        return String.valueOf(Weight);
    }

    
}
