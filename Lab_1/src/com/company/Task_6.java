package com.company;

import java.util.Scanner;

public class Task_6 {

    public void task_6() {
        checkPassword();
    }


    private String readString() {
        Scanner in = new Scanner(System.in);
        System.out.print("Ваш пароль: ");
        String password = in.nextLine();
        return password;
    }

    private void checkPassword(){
        String reg = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9_]).{8,}";

        if (readString().matches(reg)){
            System.out.print("Ваш пароль дійсний");
        }
        else System.out.print("Ваш не пароль дійсний");
    }

}