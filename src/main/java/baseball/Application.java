package baseball;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.lang.IllegalArgumentException;

public class Application {

    static void handleLineException(String[] parsedString){
        if (parsedString.length != 3)
            throw new IllegalArgumentException("Too many arguments");
    }

    static void handleWordException(String word){
        if (word.length() != 1)
            throw new IllegalArgumentException("Wrong argument length");
        if (!Character.isDigit(word.charAt(0)))
            throw new IllegalArgumentException("Argument is not a number");
    }

    static void handleZeroException(Integer num){
        if (num == 0)
            throw new IllegalArgumentException("Invalid range of input");
    }

    static Integer castToInteger(String str){
        Integer num = 0;
        try {
            num = Integer.parseInt(str);
            handleZeroException(num);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return num;
    }

    static void handleException(String[] parsedString){
        try {
            handleLineException(parsedString);
            for (String word : parsedString){
                handleWordException(word);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    static List<Integer> inputAnswer(){
        List<Integer> inputList;
        Integer[] inputArray = new Integer[3];
        String inputString = Console.readLine();
        String[] parsedString = inputString.split(" ");

        //for debugging
        System.out.println(inputString);
        for (String str : parsedString) {
            System.out.println(str);
        }
        System.out.println(parsedString.length);
        //

        handleException(parsedString);

        for (int i = 0; i < 3; i++) {
            inputArray[i] = castToInteger(parsedString[i]);
        }
        inputList = Arrays.asList(inputArray);

        return inputList;
    }

    public static void main(String[] args) {

        List<Integer> isStrike = inputAnswer();

        //for debugging
        for (Integer i : isStrike) {
            System.out.println("(" + i + ")");
        }
        //
    }
}
