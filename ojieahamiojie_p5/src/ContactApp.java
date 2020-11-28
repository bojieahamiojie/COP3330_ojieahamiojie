import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ContactApp {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while(flag){
            System.out.println("Select your application\n");
            System.out.println("-----------------------\n");
            System.out.println("1) task list\n");
            System.out.println("2) contact list\n");
            System.out.println("3) quit\n>");
            int choice = input.nextInt();

            switch(choice){
                case 2:
                    mainMenu();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Input is incorrect\n");
            }
        }
    }

    public static void mainMenu() throws IOException{
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        File file = new File("Saved_Contacts");
        if(!file.exists()){
            file.mkdir();
        }

        while(flag){
            System.out.println("Main Menu\n");
            System.out.println("---------\n");
            System.out.println("1) Create a new list\n");
            System.out.println("2) Load an existing list\n");
            System.out.println("3) quit\n> ");
            int choice = input.nextInt();

            switch(choice){
                case 1:
                    System.out.println("new contact list has been created\n");
                    newContact();
                    break;
                case 2:
                    loadContact();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Input is incorrect\n");
            }
        }
    }

    public static void subContactListMenu(ContactList currentContactList) throws IOException{
        Scanner input= new Scanner(System.in);
        boolean flag = true;

        while(flag){
            System.out.println("List Operation Menu\n");
            System.out.println("---------\n");

            System.out.println("1) View the list\n");
            System.out.println("2) Add an item\n");
            System.out.println("3) Edit an item\n");
            System.out.println("4) Remove an item\n");
            System.out.println("5) Save the current list\n");
            System.out.println("6) Quit to main menu\n>");
            int choice = input.nextInt();

            switch(choice){
                case 1:
                    currentContactList.printsElements();
                    break;
                case 2:
                    ContactItem currentContactItem = parseContactItem();
                    if(currentContactItem != null)
                        currentContactList.addContact(currentContactItem);
                    break;
                case 3:
                    editContact(currentContactList);
                    break;
                case 4:
                    removeContactItem(currentContactList);
                    break;
                case 5:
                    savingFile(currentContactList);
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Input is incorrect\n");
            }
        }
    }

    public static void savingFile(ContactList currentContactList) throws IOException{
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the file name to save as: ");
        String path = input.nextLine();

        File existingFile = new File("Saved_Contacts" + path);
        if(checkToExist(existingFile)){
            System.out.println("\nWARNING! This file already exists!\n");
            return;
        }
        currentContactList.savingList(existingFile);
        System.out.println("Contact list has been saved!\n");
    }

    public static boolean unmarkEdited(ContactList currentContactList){
        Scanner input = new Scanner(System.in);

        if(currentContactList.getContacts().size() == 0){
            System.out.println("There are no contacts!\n");
            return false;
        }

        currentContactList.printMarkedEdited();
        System.out.println("Which contact will unmark as edited? ");
        int choice = input.nextInt();
        if(!currentContactList.validateUnmarkIndex(choice)){
            System.out.println("\nContact is already unmarked!\n");
            return false;
        }
        return true;
    }

    public static boolean markEdited(ContactList currentContactList){
        Scanner input = new Scanner(System.in);

        if(currentContactList.getContacts().size() == 0){
            System.out.println("There are no contacts to edit!\n");
            return false;
        }

        currentContactList.printUnmark();
        System.out.println("Which contact will mark as edited? ");
        int choice = input.nextInt();
        if(!currentContactList.validateMarkIndex(choice)){
            System.out.println("\n Contact is already marked!\n");
            return false;
        }
        return true;
    }

    public static void removeContactItem(ContactList currentContactList){
        Scanner input = new Scanner(System.in);

        if(currentContactList.getContacts().size() == 0){
            System.out.println("There are no contacts to edit!\n");
            return;
        }

        currentContactList.printsElements();
        System.out.println("Which contact will you remove? ");
        int choice = input.nextInt();

        if(!currentContactList.removeContactItem(choice))
            System.out.println("\nWARNING! Invalid contact!\n");
    }

    public static void editContact(ContactList currentContactList){
        Scanner input = new Scanner(System.in);

        if(currentContactList.getContacts().size() == 0){
            System.out.println("There are no contacts to edit!\n");
            return;
        }

        currentContactList.printsElements();
        System.out.println("Which contact will you edit? ");
        int choice = Integer.parseInt(input.nextLine());

        if(currentContactList.validateEditIndex(choice)){
            ContactItem current;

            String first = "";
            String last = "";
            String phone = "";
            String email = "";

            System.out.println("\nEnter a new first name for contact " + choice + ": ");
            first = input.nextLine();
            System.out.println("\nEnter a new last name for contact " + choice + ": ");
            last = input.nextLine();
            System.out.println("\nEnter a new phone number (xxx-xxx-xxxx) for contact " + choice + ": ");
            phone = input.nextLine();
            System.out.println("\nEnter a new email address (x@y.z) for contact " + choice + ": ");
            email = input.nextLine();

            current = createContactItem(first, last, phone, email);
            currentContactList.getContacts().set(choice, current);
        }
        else
            System.out.println("\nWARNING! Chosen contact item does not exist\n");
    }

    public static ContactItem parseContactItem(){
        new ContactItem();
        ContactItem parsedContactItem;

        Scanner input = new Scanner(System.in);

        String first = "";
        String last = "";
        String phone = "";
        String email = "";

        System.out.println("\nFirst name: ");
        first = input.nextLine();
        System.out.println("\nLast name: ");
        last = input.nextLine();
        System.out.println("\nPhone number (xxx-xxx-xxxx): ");
        phone = input.nextLine();
        System.out.println("\nEmail address (x@y.z): ");
        email = input.nextLine();

        parsedContactItem = createContactItem(first, last, phone, email);
        return parsedContactItem;
    }

    public static ContactItem createContactItem(String first, String last, String phone, String email){
        ContactItem createdContactItem = new ContactItem();
        if(!createdContactItem.setFirstName(first) || !createdContactItem.setEmailAddress(email))
            return null;

        createdContactItem.setLastName(last);
        createdContactItem.setPhoneNumber(phone);
        return createdContactItem;
    }

    public static void newContact() throws IOException{
        ContactList newContact = new ContactList();
        subContactListMenu(newContact);
    }

    public static boolean checkToExist(File file){
        if(file.exists())
            return true;
        return false;
    }

    public static void loadContact() throws IOException{
        Scanner input = new Scanner(System.in);

        File directory = new File("Saved_Contacts");
        if(directory.list().length <= 0){
            System.out.println("\nThere are no saved contact lists to load!\n");
            return;
        }

        System.out.println("Enter the filename to load: ");
        String path = input.nextLine();

        File file = new File("Saved_Contacts//" + path);
        if(!checkToExist(file)){
            System.out.println("\nWARNING: This file does not exist!\n");
            return;
        }

        Scanner sc = new Scanner(file);
        ContactList newContact = new ContactList();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] variables = line.split("\\|");
            String first = variables[0];
            String last = variables[1];
            String phone = variables[2];
            String email = variables[3];

            ContactItem temp = new ContactItem(first, last, phone, email);
            newContact.addContact(temp);
        }
        subContactListMenu(newContact);
    }
}
