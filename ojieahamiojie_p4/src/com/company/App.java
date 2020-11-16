package com.company;

import java.io.File;
import java.io.IOException;
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

    public static void subMenu(TaskList currentList) throws IOException{
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while(flag){
            System.out.println("List Operation Menu\n");
            System.out.println("---------\n");

            System.out.println("1) View the list\n");
            System.out.println("2) Add an item\n");
            System.out.println("3) Edit an item\n");
            System.out.println("4) Remove an item\n");
            System.out.println("5) Mark an item as completed\n");
            System.out.println("6) Unmark an item as completed\n");
            System.out.println("7) Save the current list\n");
            System.out.println("8) Quit to main menu\n>");

            int choice = input.nextInt();

            switch(choice){
                case 1:
                    currentList.printElements();
                    break;
                case 2:
                    TaskItem currentItem = parseItem();
                    if(currentItem != null)
                        currentList.addTask(currentItem);
                    break;
                case 3:
                    editItem(currentList);
                    break;
                case 4:
                    removeItem(currentList);
                    break;
                case 5:
                    markDone(currentList);
                    break;
                case 6:
                    unmarkDone(currentList);
                case 7:
                    saveFile(currentList);
                    break;
                case 8:
                    flag = false;
                    break;
                default:
                    System.out.println("Input is incorrect\n");
            }
        }
    }

    public static void saveFile(TaskList currentList) throws IOException{
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the filename to save as: ");
        String path = input.nextLine();

        File file = new File("Saved_Lists//" + path);
        if(checkExists(file)){
            System.out.println("\nWARNING: This file already exists!\n");
            return;
        }
        currentList.saveList(file);
        System.out.println("Task list has been saved!\n");
    }

    public static boolean unmarkDone(TaskList currentList){
        Scanner input = new Scanner(System.in);

        if(currentList.getTasks().size() == 0){
            System.out.println("There are no tasks!\n");
            return false;
        }

        currentList.printMarked();
        System.out.println("Which task will unmark as completed? ");
        int choice = input.nextInt();
        if(!currentList.validUnmarkIndex(choice)){
            System.out.println("\nItem is already unmarked!\n");
            return false;
        }
        return true;
    }

    public static boolean markDone(TaskList currentList){
        Scanner input = new Scanner(System.in);

        if(currentList.getTasks().size() == 0){
            System.out.println("There are no tasks to mark!\n");
            return false;
        }

        currentList.printUnmarked();
        System.out.println("Which task will mark as complete? ");
        int choice = input.nextInt();
        if(!currentList.validMarkIndex(choice)){
            System.out.println("\n Item is already marked!\n");
            return false;
        }
        return true;
    }

    public static void removeItem(TaskList currentList){
        Scanner input = new Scanner(System.in);

        if (currentList.getTasks().size() == 0){
            System.out.println("There are no tasks to edit!\n");
            return;
        }

        currentList.printElements();
        System.out.println("Which task will remove? ");
        int choice = input.nextInt();

        if(!currentList.removeTask(choice))
            System.out.println("\nWARNING: Invalid item!\n");
    }

    public static void editItem(TaskList currentList){
        Scanner input = new Scanner(System.in);

        if(currentList.getTasks().size() == 0) {
            System.out.println("There are no tasks to edit!\n");
            return;
        }

        currentList.printElements();
        System.out.println("Which task will you edit? ");
        int choice = Integer.parseInt(input.nextLine());
        if(currentList.validEditIndex(choice)){
            TaskItem curr = currentList.getTasks().get(choice);

            String title = "";
            String description = "";
            String date = "";

            System.out.println("\nEnter a new title for task " + choice + ": ");
            title = input.nextLine();
            System.out.println("\nEnter a new description for task " + choice + ": ");
            description = input.nextLine();
            System.out.println("\nTask due date (YYYY-MM-DD) for task " + choice + ": ");
            date = input.nextLine();

            curr = createItem(title, description, date, false);
            currentList.getTasks().set(choice, curr);
        }
        else
            System.out.println("\nWARNING: Chosen task item does not exist.\n");
    }

    public static TaskItem parseItem(){
        TaskItem parsedItem = new TaskItem();

        Scanner input = new Scanner(System.in);

        String title = "";
        String description = "";
        String date = "";

        System.out.println("Task title: ");
        title = input.nextLine();;
        System.out.println("\n Task description: ");
        description = input.nextLine();
        System.out.println("\nTask due date (YYYY-MM-DD): ");
        date = input.nextLine();

        parsedItem = createItem(title, description, date, false);
        return parsedItem;
    }

    public static TaskItem createItem(String title, String description, String date, boolean marked){
        TaskItem createdItem = new TaskItem();

        if(!createdItem.setTitle(title) || !createdItem.setDueData(date))
            return null;

        createdItem.setDescription(description);
        return createdItem;
    }

    public static String parseVal(Scanner input){
        return input.nextLine();
    }

    public static void newList() throws IOException {
        TaskList newList = new TaskList();
        subMenu(newList);
    }

    public static boolean checkExists(File file){
        if(file.exists())
            return true;

        return false;
    }

    public static void loadList() throws IOException{
        Scanner input = new Scanner(System.in);

        File dir = new File("Saved_Lists");
        if(dir.list().length <= 0){
            System.out.println("\nThere are no saved lists to load!\n");
            return;
        }

        System.out.println("Enter the filename to load: ");
        String path = input.nextLine();

        File file = new File("Saved_Lists//" + path);
        if(!checkExists(file)){
            System.out.println("\nWARNING: This file does not exist!\n");
            return;
        }

        Scanner scan = new Scanner(file);
        TaskList newList = new TaskList();
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] variables = line.split("\\|");
            String title = variables[0];
            String description = variables[1];
            String date = variables[2];
            boolean marked = Boolean.parseBoolean(variables[3]);

            TaskItem temp = new TaskItem(title, description, date, marked);
            newList.addTask(temp);
        }
        subMenu(newList);
    }
}