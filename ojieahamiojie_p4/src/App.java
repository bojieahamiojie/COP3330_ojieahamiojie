package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        File file = new File("Saved_Lists");
        if(!file.exists()){
            file.mkdir();
        }

        while(flag){
            System.out.println("Main Menu\n");
            System.out.println("---------\n");
            System.out.println("1) Create a new list\n");
            System.out.println("2) Load an existing list\n");
            System.out.println("3) quit\n>");

            int choice = input.nextInt();

            switch(choice){
                case 1:
                    newList();
                    break;
                case 2:
                    loadList();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Input is incorrect\n");
            }
        }
    }
}
