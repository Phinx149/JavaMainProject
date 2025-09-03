public class Bird extends Animal {
    private boolean vegan;
   
    public Bird(){}
    public Bird(boolean isVegan,String Name){
        vegan=isVegan;
        name=Name;
        


    }
    public boolean getVegan(){
        return vegan;

    }
    @Override
    public void Speak(){
        System.out.print("Tweet Tweet");
    }

    public String toString(){
        if (vegan==true){
            return(name+" True");
        }else{
            return (name+" False");
        }
    }
    
}
