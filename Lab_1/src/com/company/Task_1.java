package com.company;
import java.util.Scanner;

public class Task_1 {

    float[] sidesOfTriangle = new float[3];

    public void task_1(){

        for (int i = 0; i < 3; i++){
            System.out.print("Введіть "+ (i+1) + " сторону трикутника: ");

            Scanner in = new Scanner(System.in);
            float sideLen = in.nextFloat();

            if (sideLen <= 0)
            {
                System.out.print("Довжина сторони не може бути 0 або відємною");
                break;
            }

            sidesOfTriangle[i] = sideLen;
        }

        if (isTriangle()){
            System.out.println("Трикутник існує");
        } else{
            System.out.println("Трикутник не існує");
            return;
        }

        if (isEquilateral() == true){
            System.out.println("Трикутник рівносторонній");
        }
        else {
            if (isIsosceles() == true){
                System.out.println("Трикутник рівнобедренний");
            }
            calculateAngle();
        }

    }

    private boolean isTriangle(){
        for (int i = 0; i < 3; i++) {
            if (sidesOfTriangle[0] + sidesOfTriangle[1] <= sidesOfTriangle[2]) {
                return false;
            }
            changeCombinationInArray();
        }
        return true;
    }

    private boolean isEquilateral(){
        if (sidesOfTriangle[0] == sidesOfTriangle[1] && sidesOfTriangle[1] == sidesOfTriangle[2]){
            return true;
        }
        else return false;
    }

    private boolean isIsosceles(){
        if (sidesOfTriangle[0] == sidesOfTriangle[1] || sidesOfTriangle[1] == sidesOfTriangle[2] ||
                sidesOfTriangle[0] == sidesOfTriangle[2]){
            return true;
        }
        else return false;
    }

    private void calculateAngle(){
        while (findBiggestSide() != sidesOfTriangle[2])
        {
            changeCombinationInArray();
        }

        double cosAngle = (Math.pow(sidesOfTriangle[0], 2) + Math.pow(sidesOfTriangle[1], 2)
                - Math.pow(sidesOfTriangle[2], 2))/(2 * sidesOfTriangle[0] * sidesOfTriangle[1]);

        System.out.println(cosAngle);

        if ((Math.pow(sidesOfTriangle[0], 2) + Math.pow(sidesOfTriangle[1], 2)
                - Math.pow(sidesOfTriangle[2], 2))/(2 * sidesOfTriangle[0] * sidesOfTriangle[1]) < 0){
            System.out.println("Трикутник тупокутний");
        } else if ((Math.pow(sidesOfTriangle[0], 2) + Math.pow(sidesOfTriangle[1], 2)
                - Math.pow(sidesOfTriangle[2], 2))/(2 * sidesOfTriangle[0] * sidesOfTriangle[1]) > 0){
            System.out.println("Трикутник гострокутний");
        } else System.out.println("Прямокутний");
    }

    private float findBiggestSide(){
        float maxSide = 0;
        for (int i = 0; i < 3; i++){
            if (sidesOfTriangle[i] > maxSide){
                maxSide = sidesOfTriangle[i];
            }
        }
        return maxSide;
    }

    private void changeCombinationInArray(){

        float num = sidesOfTriangle[2];
        sidesOfTriangle[2] = sidesOfTriangle[1];
        sidesOfTriangle[1] = sidesOfTriangle[0];
        sidesOfTriangle[0] = num;

    }
}
