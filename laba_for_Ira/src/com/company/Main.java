package com.company;

import java.util.Scanner;

public class Main {

    private static String input(){ // func for inputting string in program
        Scanner in = new Scanner(System.in);
        String temp = in.nextLine();
        return temp;
    }

    private static boolean checkPalindrome (StringBuffer input){ // func to check string as a palindrome
        for (int i = 0; i < input.length(); i++) { // some magic with this shit
            if ((int) input.charAt(i) < 65 && (int) input.charAt(i) > 1103) { // in ASCII these symbols are [0; 'A') U ('ya'; +Inf)
                input.deleteCharAt(i);
                i--;
                continue;
            }

            if ((int) input.charAt(i) > 90 && (int) input.charAt(i) < 97){ // in ASCII these symbols are ('Z'; 'a')
                input.deleteCharAt(i);
                i--;
                continue;
            }

            if ((int) input.charAt(i) > 96 && (int) input.charAt(i) < 123) { // in ASCII these symbols are ['a'; 'z']
                input.setCharAt(i, (char) (input.charAt(i) - 32)); // here we change register of English letters
                continue;
            }

            if ((int) input.charAt(i) > 122 && (int) input.charAt(i) < 1040){ // in ASCII these symbols are ('z'; /Russian/'A')
                input.deleteCharAt(i);
                i--;
                continue;
            }

            if ((int) input.charAt(i) > 1071 && (int) input.charAt(i) < 1104) { // in ASCII (not sure) there are little Russian letters
                input.setCharAt(i, (char) (input.charAt(i) - 32)); // here we change register of Russian letters
                continue;
            }

            if (input.charAt(i) == ' ') { // delete spaces. fuck spaces
                input.deleteCharAt(i);
                i--;
            }
        }

        StringBuffer output = new StringBuffer(input.reverse()); // put in output string reversed input
        input.reverse(); // and reverse it again to compare

        boolean flag = true; // some crutches

        for (int i = 0; i < input.length(); i++)
            if (output.charAt(i) != input.charAt(i)) // comparing input and reverse(output)
                flag = false;

        return flag;
    }

    public static void main(String[] args) {
        StringBuffer input = new StringBuffer(1); // here we get our string

        System.out.println("Welcome. \nEnter 'help' to get list of available commands"); // here some UI
        Scanner in = new Scanner(System.in);
        String enter;
        do {
            System.out.print(">");
            enter = in.nextLine();
            switch (enter) {
                case "enter":
                    System.out.print("Enter your phrase here: ");
                    input = new StringBuffer(input());
                    break;

                case "check":
                    if (input.capacity() > 1) {
                        if (checkPalindrome(input))
                            System.out.println("Great! Yor phrase is palindrome!");
                        else
                            System.out.println("Crap! This is not a palindrome.");
                    }
                    else System.out.println("You must enter phrase first!");
                    break;

                case "help":
                    System.out.println("List of available commands:" +
                    "\n'enter' to enter phrase to check;" +
                    "\n'check' to check is phrase palindrome" +
                    "\n'exit' to exit program");
                    break;

                case "exit":
                    break;
            }
        } while (!enter.equals("exit"));
    }
}
