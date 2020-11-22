package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Input {

    public String inputString(String question, String regex) {
        try{
            System.in.reset();
        } catch (IOException exception) {
            exception.getStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        String in;
        String str;
        char m = '\0';
        do {
            do {
                scanner.reset();
                System.out.println(question);
                str = scanner.nextLine().trim();
            } while (!str.matches(regex));
            do {
                scanner.reset();
                System.out.print("You've entered: \"" + str);
                System.out.print("\".\nAccept? ( Y / N )\n");
                in = scanner.nextLine().trim();
                if (in.length() > 0) {
                    m = in.toLowerCase()
                            .charAt(0);
                }
            } while(m != 'y' && m != 'n');
        } while(m != 'y');
        return str;
    }

    //origin and end inclusive
    public int inputInt(String question, int origin, int end) {
        int number;
        do {
            number = Integer.parseInt(inputString(question, "\\d+"));
        } while (number < origin || number > end);

        return number;
    }
}
