import java.util.Comparator;
public class DictionaryEntry implements Comparable<DictionaryEntry> {
    // instance variables
    private String wordOrPhrase;
    private String definition;
    String [] data=new String[2];
    
    // constructors
    public DictionaryEntry() {
        this.wordOrPhrase="None";
        this.wordOrPhrase="None";
    }
    public DictionaryEntry(String wop, String def) {
        this.wordOrPhrase = wop;
        this.definition = def;
        data[0]=wordOrPhrase;
        data[1]=definition;
    }
   
    // You are required to implement at least the getters and setters below
    // You are free to implement other constructors as you see fit (deem necessary)
    // returns a String array with the wordOrPhrase at location zero and definition
    // at location 1 - You must implement to get rid of the compliation error!!!
    public String getWop(){
        return wordOrPhrase;
    }
    public void setWop(String word){
        wordOrPhrase=word;
    }
    public String getDef(){
        return definition;
    }
    public void setDef(String defword){
        definition=defword;
    }
    public String [] getData() {
        return data;
        
        
    }
    // accepts a String array with the wordOrPhrase at location zero and the definition
    // of the wordOrPhrase at location 1 and sets the variables accordingly
    public void setData(String [] newData) {
        data[0]=newData[0];
        data[1]=newData[1];
    }
    // Define a Comparator method that can be used to sort an ArrayList of Nodes in Lexically
    // Ascending order - that is, from A to Z, according to the wordOrPhrase
    // Note that you must keep the exact method signature provided here
    
    public int compareTo(DictionaryEntry other){
       
        return wordOrPhrase.strip().toLowerCase().compareTo(other.wordOrPhrase.strip().toLowerCase());
    }
}
