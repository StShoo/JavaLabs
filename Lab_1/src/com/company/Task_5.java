package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Task_5 {

    ArrayList<Character> newCharsOfWord = new ArrayList<>();
    public void task_5(){
        char[] charsOfWord = readString().toCharArray();
        rewriteChar(charsOfWord);
        printChars();
    }

    private String readString(){
        Scanner in = new Scanner(System.in);
        System.out.print("Ваше слово: ");
        String word = in.nextLine();
        return word;
    }

    private void rewriteChar(char[] charsOfWord){
        int counter = 0;
        for (int i = 0; i<charsOfWord.length; i++){
            if ((charsOfWord[i] == 'о' || charsOfWord[i] == 'O')){
                counter++;
                if (counter == 2){
                    continue;
                }
            }
            newCharsOfWord.add(charsOfWord[i]);
        }
    }

    private void printChars(){
        System.out.println("Ваше змінене слово:");
        for (int i = 0; i < newCharsOfWord.size(); i++){
            System.out.print(newCharsOfWord.get(i));
        }
    }
}
