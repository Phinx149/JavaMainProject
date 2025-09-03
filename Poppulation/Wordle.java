    
import java.io.*; 
import java.util.*;

public class Wordle {
    public static String[] keyArray=new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};//array store the state of the key board
    public static String [] fileToArray()throws FileNotFoundException{//Method stores file to array
        String [] wordArray;//stores the word in the file
        int numLines=0;//stores the number of lines in file
        File wordFile=new File("C:\\Users\\user\\Downloads\\anand197\\sgb-words.txt");
        Scanner scanner=new Scanner(wordFile);
        while (scanner.hasNextLine()){//figures out how many lines in the file
            numLines=numLines+1;
            scanner.nextLine();
        }
        scanner.close();
        scanner=new Scanner(wordFile);//intializes scanner class to

        wordArray= new String[numLines];
        for (int i=0;i<numLines;i++){// reads words from file to enter into word array
            wordArray[i]=scanner.nextLine();
            
        }
        scanner.close();
        return wordArray;
    }  
    public static void updKeys(String colString,String temp){//method updates the keyboard
        for (int i=0;i<26;i++){//loops to the keyboard and checks if the letter right and its postition in the word is right and color keyboard based on that
            if (keyArray[i].equals(temp)){
                keyArray[i]=colString;

            }else if (colString.equals("\u001B[32;1m" + temp + "\u001B[0m")&&keyArray[i].contains(temp)){
                keyArray[i]="\u001B[32;1m" + temp + "\u001B[0m";
                

            }
        }

    }
    public static String similarity(String string1,String string2){
        //Checks the similarity between guess and answer word
        String []stringArr1=string1.split("");
        String [] stringArr2=string2.split("");
        String result="";
        
        for (int i=0;i<5;i++){
            String temp=stringArr1[i];
            boolean inWord=false;
            
            for (int j=0;j<5;j++){
                if (i==j && temp.equals(stringArr2[j])){
                    result = result+"\u001B[32;1m" + temp + "\u001B[0m";//concatenates string of letter that is in word and same positon as the wordle answer with green color
                    updKeys("\u001B[32;1m" + temp + "\u001B[0m",temp);//updates keyboard
                    

                    inWord=true;
                    
                    break;
                    
                }else if(i!=j && temp.equals(stringArr2[j])){

                    result =result+ "\u001B[33;2m" + temp + "\u001B[0m";//concatenates string of letter that is in word but not in right position with yellow color
                    inWord=true;
                    updKeys("\u001B[33;2m" + temp + "\u001B[0m",temp);//updates keyboard
                    

                    break;
                }
            }
        if (inWord==false){
            result =result+ "\u001B[31;2m" + temp + "\u001B[0m";//if not in word the character concatenated is red in color
            updKeys( "\u001B[31;2m" + temp + "\u001B[0m",temp);
            

        }
           

            
        }
        return result;

       }
       

       
       

        public static void wordleGame(String [] array){//method runs wordle game and takes string of arrays as parameter
            Random random =new Random();
            
            boolean found=false;
            
            String answer;
            
            String[] guessArray=new String[5];
           
            int randNum=random.nextInt(0,array.length);
            
            answer=array[randNum];
            
            array[randNum]=null;
           
            
            Scanner scanner=new Scanner(System.in);
           
            
           for (int i=0;i<5;i++){
            
            
            System.out.println("enter your guess of word:");
                
            String guess=scanner.nextLine().trim().toLowerCase();
           
            while (guess.length()!=5 ){
                    System.out.print("Please enter a five letter word as your guess: ");//checking if lenght of guess is 5
                    guess=scanner.nextLine().trim().toLowerCase();
                }
                
                
            if (guess.equals(answer)){//checks if they are equal
                    System.out.println("You got the right word");
                    found=true;
                    break;
            }else{//if not equal displays what you have gotten wrong along with keyboard
                    guessArray[i]=similarity(guess,answer);
                    for (int j=0;j<guessArray.length;j++){
                        if (guessArray[j]!=null){
                            System.out.println(guessArray[j]);

                        }
                    }
                    for (int j=0;j<26;j++){
                        System.out.print(keyArray[j]+"  ");
                        
                    }
                    System.out.println("\n");
                }
            }
            if (found==false){
                System.out.print("You have failed to guess the word");//if unable to guess world prints this
            }
            scanner.close();

        }
        

       

    
    public static void main(String [] args) {
        try {
            String [] array;
            array=fileToArray();
            
            wordleGame(array);

           

    
        }
         catch (FileNotFoundException f){
            
               System.out.println("File not found.");
         }
        
        


    }

    
}

