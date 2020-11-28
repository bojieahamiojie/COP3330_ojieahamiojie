import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactList {
    private List<ContactItem> contacts;

    public ContactList(){
        this.contacts = new ArrayList<>();
    }

    public ContactList(List<ContactItem> contacts){
        this.contacts = contacts;
    }

    public void addContact(ContactItem items){
        contacts.add((ContactItem) items);
    }

    public List<ContactItem> getContacts(){
        return contacts;
    }

    public void setContacts(List<ContactItem> contacts){
        this.contacts = contacts;
    }

    public boolean removeContactItem(int choice){
        if(this.validateEditIndex(choice)){
            this.getContacts().remove(choice);
            return true;
        }
        return false;
    }

    public boolean validateEditIndex(int choice){
        if(choice >= 0 && choice < this.getContacts().size()) {
            if (!(this.getContacts().get(choice).isMarkedEdited())) {
                this.getContacts().get(choice).setUnmark();
                return true;
            }
        }
        return false;
    }

    public boolean validateMarkIndex(int choice){
        if(choice >= 0 && choice < this.getContacts().size()) {
            if (!(this.getContacts().get(choice).isMarkedEdited())) {
                this.getContacts().get(choice).setMarkedEdited();
                return true;
            }
        }
        return false;
    }

    public boolean validateUnmarkIndex(int choice){
        if(choice >= 0 && choice < this.getContacts().size()) {
            if (this.getContacts().get(choice).isMarkedEdited()) {
                this.getContacts().get(choice).setUnmark();
                return true;
            }
        }
        return false;
    }

    public void printsElements(){
        for(int i = 0; i < contacts.size(); i++){
            ContactItem temp = contacts.get(i);
            System.out.println(i + ")");

            if(temp.isMarkedEdited())
                System.out.println("* ");
            System.out.println("Name: " + temp.getFirst() + " " + temp.getLast());
            System.out.println("Phone: " + temp.getPhone());
            System.out.println("Email: " + temp.getEmail());
        }
    }

    public void printUnmark(){
        for(int i = 0; i < contacts.size(); i++){
            ContactItem temp = contacts.get(i);

            if(!temp.isMarkedEdited()){
                System.out.println(i + ")");
                System.out.println("Name: " + temp.getFirst() + " " + temp.getLast());
                System.out.println("Phone: " + temp.getPhone());
                System.out.println("Email: " + temp.getEmail());
            }
        }
    }

    public void printMarkedEdited(){
        for(int i = 0; i < contacts.size(); i++){
            ContactItem temp = contacts.get(i);

            if(!temp.isMarkedEdited()){
                System.out.println(i + ")");
                System.out.println("Name: " + temp.getFirst() + " " + temp.getLast());
                System.out.println("Phone: " + temp.getPhone());
                System.out.println("Email: " + temp.getEmail());
            }
        }
    }

    public void savingList(File file) throws IOException{
        FileWriter fileWriter = new FileWriter(file);
        for(ContactItem temp : contacts){
            String line = temp.getFirst() + "|";
            line += temp.getFirst() + "|";
            line += temp.getLast() + "|";
            line += temp.getPhone() + "|";
            line += temp.getEmail() + "|";
            line += temp.isMarkedEdited() + "\n";
            fileWriter.write(line);
        }
        fileWriter.close();
    }
}
