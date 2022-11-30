package com.company;

import java.util.Scanner;

public class Task_3 {

    public void task_3(){
        float[][] matrix = fillMatrix(createMatrix(scanMatrixSize()));
        int k = checkKIsKCorrect(scanKNumber(), matrix.length);

        System.out.println("Your matrix: ");
        printMatrix(matrix);

        System.out.println("Your changed matrix: ");
        printMatrix(changeMatrixRow(matrix, k));
    }

    public int scanMatrixSize(){
        System.out.println("Enter size of square matrix: ");
        int matrixSize = scanInput().nextInt();
        return matrixSize;
    }

    public float scanMatrixElements(){
        System.out.println("Enter element of matrix: ");
        float element = scanInput().nextFloat();
        return element;
    }

    private int scanKNumber(){
        System.out.println("Enter k element: ");
        int k = scanInput().nextInt();
        return k;
    }

    private int checkKIsKCorrect(int k, int matrixSize){
        if (k < 0){
            System.out.println("k number is too small");
            endProgramme();
        } else if (k >= matrixSize){
            System.out.println("k number is too big");
            endProgramme();
        }
        return k;
    }

    public float[][] createMatrix(int matrixSize){
        float[][] matrix = new float[matrixSize][matrixSize];
        return  matrix;
    }

    public float[][] fillMatrix(float[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = scanMatrixElements();
            }
        }
        return matrix;
    }

    private float[][] changeMatrixRow(float[][] matrix, int k){
        float diagonalValue = matrix[k][k];
        for (int j = 0; j < matrix[k].length; j++){
            matrix[k][j] -= diagonalValue;
        }
        return matrix;
    }

    public void printMatrix(float[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void endProgramme(){
        System.exit(0);
    }

    public Scanner scanInput(){
        Scanner in = new Scanner(System.in);
        return in;
    }
}
