public class Dog  extends Animal {
    private boolean chasesCats;
    
    public Dog (boolean CC, String aName){
        chasesCats = CC;
        name = aName;
    }

    public Dog () {
        chasesCats = false;
        name = "Fido";
    }

    public void Speak(){
        System.out.println("Woof Woof");
    }

    public boolean catChaser() {
        return chasesCats;
    }

    public String toString () {return name + " Chases Cats? " + chasesCats;}
}
