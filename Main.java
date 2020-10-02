package com.company;
import java.io.*;

class Main {

    private static void RevealStr(char binaryArray[], int counter) throws IOException {
        PrintStream outputFile = new PrintStream(new FileOutputStream("outPART1.txt",true));
        outputFile.flush();
        if (counter == binaryArray.length) {
            outputFile.println(binaryArray);
            System.out.println(binaryArray);

            return;
        }
        if (binaryArray[counter] == '*') {
            for (char starNumber = '0'; starNumber <= '1'; starNumber++) {
                binaryArray[counter] = starNumber;
                RevealStr(binaryArray,counter+1)  ;
                binaryArray[counter] = '*';
            }
            return;
        }
        outputFile.close();
        RevealStr(binaryArray, counter+1);
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        Console col = System.console();
        String inputString;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        inputString = reader.readLine();

        char inputCharacter[] = new char[inputString.length()];

        for (int i = 0; i < inputString.length(); i++)
            inputCharacter[i] = inputString.charAt(i);

        RevealStr(inputCharacter, 0);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime + " nanoseconds");
    }
}