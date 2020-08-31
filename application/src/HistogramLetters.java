import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HistogramLetters {

    private static int[] lettersCounter = new int[26];
    private static double[] probabilityOfEvents  = new double[26];
    private static char[] englishAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static char[] englishAlphabetCapital = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static double[] centralAngleOfSegments = new double[26];

    public void fileProcessor() {
        try {
            FileReader myFileReader = new FileReader("Emma.txt");
            int singleCharacter = myFileReader.read();

            while (singleCharacter != -1) {
                identifyLetter(singleCharacter);
//                System.out.print((char) singleCharacter);
                singleCharacter = myFileReader.read();
            }
        }
        catch (FileNotFoundException exception1){
            System.out.println("File was not found ");
        }
        catch(IOException exception2){
            System.out.println("I/O error occured");
        }
    }

    public void identifyLetter(int intCharacter){
        char charCharacter = (char) intCharacter;

        for(int i = 0; i < 26; i++){
            if(charCharacter == englishAlphabet[i] ||
                    charCharacter == englishAlphabetCapital[i]){
                lettersCounter[i] += 1;
            }
        }

    }

    private double getFrequencyOfAllEvents(){
        int frequencyOfAllEvents = 0;

        for(int i = 0 ; i < 26; i++){
            frequencyOfAllEvents += lettersCounter[i];
        }

        return frequencyOfAllEvents;
    }

    public double[] calculateProbabilityOfEvents(){
        for(int i = 0; i < 26; i++) {
            probabilityOfEvents[i] = lettersCounter[i]/getFrequencyOfAllEvents();
        }

        return probabilityOfEvents;
    }

    public char[] getTypesOfEvents(){
        return englishAlphabet;
    }


    public void printLettersCount(){
        System.out.println();
        System.out.println();
        for(int i = 0; i < 26;i++){
            S
            ystem.out.print(englishAlphabet[i] + ": #");
            System.out.println(lettersCounter[i]);
        }
    }

    public void printProbabilityOfEvents(){
        System.out.println();
        System.out.println();
        for(int i = 0; i < 26;i++){
            System.out.print(englishAlphabet[i] + ": #");
            System.out.println(probabilityOfEvents[i]);
        }
    }


}
