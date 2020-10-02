package com.company;
import java.io.*;
import java.io.IOException;
import java.util.Stack;

class Main
{
    public static void RevealStr(String binaryArray) throws IOException
    {
        Stack<String> stack = new Stack();
        stack.push(binaryArray);
        PrintStream outputFile = new PrintStream(new FileOutputStream("outPART2.txt",true));
        outputFile.flush();

        int index;

        while (!stack.empty())
        {
            String number = stack.pop();
            if ((index = number.indexOf('*')) >=0)
            {
                for (char binary = '0'; binary <= '1'; binary++)
                {
                    number = number.substring(0, index) + binary +
                            number.substring(index + 1);
                    stack.push(number);
                }
            }
            else
                System.out.println(number);
                outputFile.println(number);
        }
    }

    public static void main(String[] args) throws IOException
    {
        long startTime = System.nanoTime();

        Console col = System.console();
        String inputString;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        inputString = reader.readLine();

        RevealStr(inputString);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime + " nanoseconds");
    }
}
