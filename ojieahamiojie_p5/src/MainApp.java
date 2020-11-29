import java.io.IOException;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while(flag){
            System.out.println("Select your application\n");
            System.out.println("-----------------------\n");
            System.out.println("1) task list\n");
            System.out.println("2) contact list\n");
            System.out.println("3) quit");
            int choice = input.nextInt();
            System.out.println("\n\n");

            switch(choice){
                case 1:
                    TaskApp taskApp = new TaskApp();
                    taskApp.mainMenu();
                    break;
                case 2:
                    ContactApp contactApp = new ContactApp();
                    contactApp.mainContactMenu();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Input is correct\n");
            }
        }
    }
}