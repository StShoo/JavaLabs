package com.company;

import java.util.Scanner;

public class Task_2 {

    private int indexOfLastElement = 0;

    public void task_2(){
        System.out.print("Enter array size: ");
        int sizeOfArray = scanArraySize();

        System.out.print("Your random Array: ");
        double[] arr = generateRandomArray(sizeOfArray);
        System.out.println();

        System.out.print("Enter k: ");
        int kValue = scanKValue();

        checkKValue(kValue, sizeOfArray, arr);

        System.out.print("Answer array: ");
        fillAnswerArray(arr);
    }



    private int scanArraySize(){
        int n = scanInput().nextInt();
        return n;
    }

    private int scanKValue(){
        int k = scanInput().nextInt();
        return k;
    }

    private void checkKValue(int k, int sizeOfArray, double[] arr){
        boolean isKCorrect = false;

        for (int i = 0; i < sizeOfArray; i++){
            if (k == arr[i]){
                indexOfLastElement = i;
                isKCorrect = true;
                break;
            }
        }

        if (!isKCorrect){
            System.out.println("You will get an empty array");
            System.exit(0);
        }
    }

    private double[] generateRandomArray(int sizeOfArray){
        double[] arr = new double[sizeOfArray];

        for (int i = 0; i < sizeOfArray; i++){
            arr[i] = (int)(Math.random() * 20) - 10;
        }

        printArray(arr);
        return arr;
    }

    private void fillAnswerArray(double[] arr){
        double[] answerArray = new double[indexOfLastElement+1];

        for (int i = 0; i < answerArray.length; i++){
            answerArray[i] = arr[i];
        }

        printArray(answerArray);
    }

    private void printArray(double[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private Scanner scanInput(){
        Scanner in = new Scanner(System.in);
        return in;
    }
}
