package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        findMaxInSideDiagonal();
    }

    private static int scanMatrixSize(){
        do {
            System.out.println("Enter size of square matrix: ");
            try {
                int matrixSize = scanInput().nextInt();
                if (matrixSize > 1){
                    return matrixSize;
                } else System.out.println("Error! Size should be more than one element");
            } catch (Exception e){
                System.out.println("Error! Try Again");
            }
        }while (true);
    }

    public static int scanMatrixElements(){
        do {
            System.out.println("Enter element of matrix: ");
            try {
                int element = scanInput().nextInt();
                return element;
            } catch (Exception e){
                System.out.println("Error! Try Again");
            }
        }while (true);
    }

    private static int[][] createMatrix(){
        int matrixSize = scanMatrixSize();
        int[][] matrix = new int[matrixSize][matrixSize];
        return  matrix;
    }

    private static int[][] fillMatrix(){
        int[][]matrix = createMatrix();
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = scanMatrixElements();
            }
        }

        printMatrix(matrix);
        return matrix;
    }

    private static void findMaxInSideDiagonal(){
        int[][] matrix = fillMatrix();
        int maxInSideDiagonal = matrix[0][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if ((matrix.length - 1) == (i+j) && matrix[i][j] % 2 == 0 && matrix[i][j] != 0){
                    if (maxInSideDiagonal < matrix[i][j]){
                        maxInSideDiagonal = matrix[i][j];
                    }
                }
            }
        }

        if(maxInSideDiagonal % 2 != 0 || maxInSideDiagonal == 0){
            System.out.println("There are no even numbers in side diagonal!");
        }
        else System.out.println("Answer is: " + maxInSideDiagonal);

    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static Scanner scanInput(){
        Scanner in = new Scanner(System.in);
        return in;
    }
}
