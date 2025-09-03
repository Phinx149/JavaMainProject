
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.tools.Diagnostic;
public class Dictionary {
    public static Scanner scanner=new Scanner(System.in);

    public static ArrayList<String> get_Names(){
       //gets name from users of files to read
        String name;
        String finish;
        ArrayList<String> names=new ArrayList<String>();
        boolean finished=false;
        while (finished==false){
            System.out.println("Enter the file name: ");
            name=scanner.nextLine();
            names.add(name);
            System.out.println("If you do not want to continue enter-No: ");
            finish=scanner.nextLine();
            if (finish.equals("No")){//loops till finish is equal to No this is case sensitive
                break;
            }
        }
        
        
        return names;
    }
    
    public static ArrayList<DictionaryEntry> readFile(String name)throws FileNotFoundException {
        //reads the files and return the data in for of arraylist withe Dictionary entry object
        //takes in the name of the file
        File fileName=new File(name);
    
        Scanner scanner=new Scanner(fileName);
        ArrayList<DictionaryEntry>fileLines =new ArrayList<DictionaryEntry>();
        
        while (scanner.hasNextLine()){        //loop goes through the file and splits reads in the data as two parts                                                                                                  
            String [] array=scanner.nextLine().trim().split("-");
            System.out.print(array[0]);
            DictionaryEntry data=new DictionaryEntry(array[0],array[1]); 
            fileLines.add(data);
           
    }
    
    
    scanner.close();
   
    return fileLines;

        

    }
    public static ArrayList<DictionaryEntry> mergeToDict(ArrayList<String> Names)throws FileNotFoundException{
        //merges all the files entered into one common arraylist dictionary
        //uses the read file and readFile method to read all the files
        ArrayList<DictionaryEntry> dict =new ArrayList<DictionaryEntry>();
        
        for (int i=0;i<Names.size();i++){
           ArrayList<DictionaryEntry>data =readFile(Names.get(i));
            
            for (int j=0;j<data.size();j++){
                boolean duplicate=false;
                String temp=data.get(j).getWop().strip();
                for (int k=0;k<dict.size();k++){
                    if (temp.equals(dict.get(k).getWop().strip())){
                        dict.get(k).setDef(data.get(j).getDef());//purpose of this part of the code is to remove any duplicats which may added into the file
                        duplicate=true;
                        break;
                    }
           }
           if (duplicate==false){// the the entry is to be added their must not be any duplicates
            dict.add(data.get(j));
           }
           

        }
    }
    Collections.sort(dict);//sort dictionary based on key
    return dict;
}
public static DictionaryEntry search(ArrayList<DictionaryEntry>theDict,String toSearch){
    //used to search dictionary and return the dictionary that is found
    //takes in the dictionary and the word to search
    //returns a dictionary entry with searche if found
            ArrayList<DictionaryEntry> doWords=new ArrayList<DictionaryEntry>();
            ArrayList<DictionaryEntry> firstSame=new ArrayList<DictionaryEntry>();
           
            boolean found=false;
            DictionaryEntry theFound=new DictionaryEntry();
            
                
            for (int i=0;i<theDict.size();i++){
                String [] splitCurrWord=theDict.get(i).getWop().trim().split("");
                String [] toSearchSplit=toSearch.split("");
                if (toSearch.toLowerCase().trim().equals(theDict.get(i).getWop().toLowerCase().trim())){//checks if the word search is equal to any key in the dictionary
                    System.out.println(theDict.get(i).getWop()+" : "+theDict.get(i).getDef());//if yes print out the word with definition
                    found=true;
                    theFound.setWop(theDict.get(i).getWop()); //Sets the theFound wordOrPhras part to the word or phrase found
                    theFound.setDef(theDict.get(i).getDef());
                    break;
               }else if (toSearch.equals("do")){
                if ((splitCurrWord[0].toLowerCase()).equals("d")&&splitCurrWord[1].toLowerCase().equals("o")){//if word start wit do add all of them to arraylist
                    doWords.add(theDict.get(i));
                }
                }else if (splitCurrWord[0].toLowerCase().trim().equals(toSearchSplit[0].toLowerCase().trim())&&theDict.get(i).getWop().toLowerCase().trim().contains(toSearch.toLowerCase().trim())){
                        firstSame.add(theDict.get(i));
                        
                    }
                
                
            }
    
    if (found==false){
        if (toSearch.toLowerCase().equals("do")){
            for (int j=0;j<doWords.size();j++){
                System.out.println(doWords.get(j).getWop()+" : "+doWords.get(j).getDef()+"\n");
            }
        }else if (firstSame.isEmpty()==false) {
            System.out.println("This is the all with first letter similarity ");
            for (int j=0;j<firstSame.size();j++){
                System.out.println(firstSame.get(j).getWop()+" : "+firstSame.get(j).getDef()+"\n");
            }
        }else{
            System.out.println("Could not find the word ");

        }
    
}
return theFound;
}
public static boolean Add(ArrayList<DictionaryEntry>theDict,String word,String definition){
    boolean wordToAdd=true;
    for (int i=0;i<theDict.size();i++){
        if (theDict.get(i).getWop().toLowerCase().trim().equals(word)){
            wordToAdd=false;
            break;
            }

     }
   if (wordToAdd==true){
     DictionaryEntry dictEnt=new DictionaryEntry(word,definition);
     theDict.add(dictEnt);
     Collections.sort(theDict);
     System.out.println("The new dictionary after add");
     for (int j=0;j<theDict.size();j++){
       
        System.out.println(theDict.get(j).getWop()+" : "+ theDict.get(j).getDef());
     }
     return true;
   }else{
    System.out.println("Could not add word or pharse as the the dictionary has similar word or phrase");
    return false;
   }
}

  public static boolean Delete(ArrayList<DictionaryEntry>theDict,String toDel){
    //delete Deletes the word user want if the word is found in any of the word or phrases
    //takes in word the dictionary and word to delete and returns boolean of wheather the operation was successfull
    boolean found=false;
    ArrayList<DictionaryEntry> Similar=new ArrayList<DictionaryEntry>();
    String[] toDelSplit=toDel.split("");
      
    for (int i=0;i<theDict.size();i++){
        String[] theDictSplit=theDict.get(i).getWop().trim().toLowerCase().split("");
        if (theDict.get(i).getWop().trim().toLowerCase().equals(toDel.toLowerCase().trim())){//check if dictionary word or phrases and is equal if yes deletes the wored
            theDict.remove(i);
            found=true;
            break;
        }else if(theDict.get(i).getWop().trim().toLowerCase().contains(toDel.toLowerCase().trim())&&theDictSplit[0].toLowerCase().trim().equals(toDelSplit[0].toLowerCase().trim())){//if not check if the first word is equal to the word to delete and if the word is contained in the other
            Similar.add(theDict.get(i));
        }
    }
    if (found==true){//if through shows user update file and return true
        System.out.println("The new file is");
        for (int j=0;j<theDict.size();j++){
            System.out.println(theDict.get(j).getWop()+" : "+theDict.get(j).getDef());
        }
        return true;
    }else if (Similar.isEmpty()==false){//if not true but the their are some words similar than print the similar words out
        System.out.println("Words similar to deletion:");
        for (int k=0;k<Similar.size();k++){
            System.out.println(Similar.get(k).getWop()+" : "+Similar.get(k).getDef());
        }
        return false;
    }else{
        System.out.print("Could not find word to delete");
        return false;
    }
   
    

    
  }
  public static boolean Update(ArrayList<DictionaryEntry>theDict,String word, String newdef){
    //Updates the the dictionary 
    // Does this by check if the word wanting to be updatede exist is dictionary
    boolean haveSet=false;
    for(int i=0;i<theDict.size();i++){
        if (theDict.get(i).getWop().trim().toLowerCase().equals(word.trim().toLowerCase())){//check if word equal to key in dictionary
            theDict.get(i).setDef(newdef);//if equal than we can update the dictionary
            haveSet=true;
            break;
        }
    }
    if (haveSet==false){
        System.out.println("unable to find the the defintion so cannot set");//if have set is equalt to false cannot set the dictionary
        return false;
    }else{
        return true;
    }

  }
  public static void WriteFile(ArrayList<DictionaryEntry>dict,String theNewDict){
    //Write to file takes in data from the dictionary dict and write into file theNewDict
    //function takes in dictionary arraylist and string the new dict the or the file name
    //returns void
    try {
            FileWriter writer = new FileWriter(theNewDict);
            
            // Writes each dictionary data in the file
            for (int i=0;i<dict.size();i++) {
                writer.write(dict.get(i).getWop() + " - " + dict.get(i).getDef() + "\n");
                
            }
            
            writer.close(); 
            System.out.println("Dictionary has been written to new  file");
        } catch (IOException e) {
            System.out.println("An error occurred as unable to write the file");
        }
    }




  


    public static void main(String [] args){
        try{
           
           ArrayList<DictionaryEntry> dict = mergeToDict(get_Names());

           
           boolean toClose = false;
           while (toClose==false) {
               // Ask the user for commands regarding what operations they want to run
               System.out.println("Enter the the operation you want to attempt- S, D, A, U, C :");
               String choice = scanner.nextLine().toLowerCase();
   
               switch (choice) {
                   case "s":
                       // Search for a word for the particular word or phrase
                       System.out.println("Enter the word or phrase you want to search for:");
                       String wordSearch = scanner.nextLine();
                       search(dict, wordSearch);
                       break;
                   case "d":
                       // Delete a word you try to search
                       System.out.println("Enter the word or phrase you want to delete:");
                       String delWord = scanner.nextLine();
                       Delete(dict, delWord);
                       break;
                   case "a":
                       // Add a the word if existing word does not exist
                       System.out.println("Enter the word or phrase you want to add:");
                       String newWord = scanner.nextLine();
                       System.out.println("Enter the definition you want to add:");
                       String newDef = scanner.nextLine();
                       
                       Add(dict, newWord, newDef);
                       break;
                   case "u":
                       // Update a definition based on whether the word or phrase entered exist in the dictionary
                       System.out.println("Enter the word you want to update:");
                       String updateWord = scanner.nextLine();
                       System.out.println("Enter the new definition of the word you plan to update:");
                       String newDefUpd = scanner.nextLine();
                       
                       Update(dict, updateWord, newDefUpd);
                       break;
                   case "c":
                       // Write all of the data into the the new dict file and close the program
                       toClose = true;
                       WriteFile(dict,"TheNewDict.txt");
                       break;
                   default:
                       System.out.println("The command you have entered is invalid. Please enter a valid command.");
               }
           }
   

           
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.out.println("Please enter a the correct names");

            

        }
            

        
    }

}


