import java.util.ArrayList;
import java.util.Collections;

public class App {

    public static void main(String[] args) {
        Converter cvt = new Converter();

        System.out.println("--------Program-Start--------");
        if(!DataAccess.inputFileExists()){
            DataAccess.createInputFile();
        }
        ArrayList<String> readIn = new ArrayList<>(DataAccess.readInputFile());

        ArrayList<Integer> numList = new ArrayList<>();
        for (String s:readIn) {
            Object temp = cvt.wordToNumber(s);
            if(temp != null){
                numList.add((Integer)temp);
            }
        }
        Collections.sort(numList);
        ArrayList<String> backToString = new ArrayList<>();
        for(int n:numList){
            backToString.add(cvt.numberToWord(n));
        }

        ArrayList<String> oneToSeven = new ArrayList<>(backToString.subList(0,7));
        ArrayList<String[]> inputOne = new ArrayList<>(makeColumns.printColumns(oneToSeven));
        ArrayList<String> oneToTwentyFive = new ArrayList<>(backToString.subList(0,25));
        ArrayList<String[]> inputTwo = new ArrayList<>(makeColumns.printColumns(oneToTwentyFive));
        ArrayList<String[]> completeList = new ArrayList<>(makeColumns.printColumns(backToString));

        System.out.println("---------------Input-One---------------");
        DisplayData.displayData(inputOne);
        System.out.println("---------------Input-Two---------------");
        DisplayData.displayData(inputTwo);
        System.out.println("---------------Input-Three---------------");
        DisplayData.displayData(completeList);
        System.out.println("--------Program-End--------");
    }
}
