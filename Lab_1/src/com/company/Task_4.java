package com.company;

public class Task_4 {

    Task_3 task_3 = new Task_3();

    public void task_4(){
        int matrixSize = task_3.scanMatrixSize();
        float[][] mainMatrix = task_3.fillMatrix(task_3.createMatrix(matrixSize));
        float[] matrixOfDiagonalSums = new float[(matrixSize-2)*2];
        task_3.printMatrix(mainMatrix);

        System.out.print("Max Sum of parallel to main diagonal is: ");
        printAnswer(findMaxSum(matrixOfDiagonalSums, mainMatrix));
        System.out.println();
        System.out.print("Min Sum of parallel to other diagonal is: ");
        printAnswer(findMinSum(matrixOfDiagonalSums, mainMatrix));
    }

    private void countSumOfParallelToMainDiagonal(float[] matrixOfDiagonalSums, float[][] mainMatrix){
        for (int i = 1; i < mainMatrix[0].length - 1; i++){
            float sumOfOneDiagonal = 0;
            int j = i;
            int l = 0;

            while (j != mainMatrix[0].length){
                sumOfOneDiagonal += mainMatrix[l][j];
                l++;
                j++;
            }
            System.out.println(sumOfOneDiagonal);
            matrixOfDiagonalSums[i-1] = sumOfOneDiagonal;
        }

        for (int i = 1; i < mainMatrix[0].length - 1; i++){
            float sumOfOneDiagonal = 0;
            int j = i;
            int l = 0;

            while (j != mainMatrix[0].length){
                sumOfOneDiagonal += mainMatrix[j][l];
                l++;
                j++;
            }
            System.out.println(sumOfOneDiagonal);
            matrixOfDiagonalSums[(mainMatrix[0].length - 2) + i - 1] = sumOfOneDiagonal;
        }
    }

    private void countSumOfOfParallelToOtherDiagonal(float[] matrixOfDiagonalSums, float[][] mainMatrix){
        for (int i = 1; i < mainMatrix[0].length - 1; i++){
            float sumOfOneDiagonal = 0;
            int j = i;
            int l = 0;

            while (j >= 0){
                sumOfOneDiagonal += Math.abs(mainMatrix[l][j]);
                l++;
                j--;
            }
            System.out.println(sumOfOneDiagonal);
            matrixOfDiagonalSums[i-1] = sumOfOneDiagonal;
        }

        for (int i = 1; i < mainMatrix[0].length - 1; i++){
            float sumOfOneDiagonal = 0;
            int j = i;
            int l = mainMatrix[0].length - 1;

            while (j < mainMatrix[0].length){
                sumOfOneDiagonal += mainMatrix[j][l];
                l--;
                j++;
            }
            System.out.println(sumOfOneDiagonal);
            matrixOfDiagonalSums[(mainMatrix[0].length - 2) + i - 1] = sumOfOneDiagonal;
        }
    }

    private float findMaxSum(float[] matrixOfDiagonalSums, float[][] mainMatrix){
        countSumOfParallelToMainDiagonal(matrixOfDiagonalSums, mainMatrix);

        float maxSumOfParallelToMainDiagonal = matrixOfDiagonalSums[0];
        for (int i = 0; i < matrixOfDiagonalSums.length; i++){
            if (maxSumOfParallelToMainDiagonal < matrixOfDiagonalSums[i]){
                maxSumOfParallelToMainDiagonal = matrixOfDiagonalSums[i];
            }
        }

        return maxSumOfParallelToMainDiagonal;
    }

    private float findMinSum(float[] matrixOfDiagonalSums, float[][] mainMatrix){
        countSumOfOfParallelToOtherDiagonal(matrixOfDiagonalSums, mainMatrix);

        float minSumOfParallelToMainDiagonal = matrixOfDiagonalSums[0];
        for (int i = 0; i < matrixOfDiagonalSums.length; i++){
            if (minSumOfParallelToMainDiagonal > matrixOfDiagonalSums[i]){
                minSumOfParallelToMainDiagonal = matrixOfDiagonalSums[i];
            }
        }

        return minSumOfParallelToMainDiagonal;
    }


    private void printAnswer(float SumOfParallelToMainDiagonal){
        System.out.print(SumOfParallelToMainDiagonal);
    }
}
