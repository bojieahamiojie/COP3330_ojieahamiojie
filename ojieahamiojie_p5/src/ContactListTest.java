import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {
    @Test
    public void addingItemsIncreasesSize(){
        ContactList newContactList = new ContactList();
        ContactItem newContactItem = new ContactItem("Success", "Success", "713-496-2053", "a@b.c", false);
        newContactList.addContact(newContactItem);
        assertEquals(1, newContactList.getContacts().size());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactItem newContactItem = new ContactItem("Success", "Success", "713-496-2053", "a@b.c", false);
        ContactList newContactList = new ContactList();
        newContactList.addContact(newContactItem);
        assertFalse(newContactItem.setFirstName(""));
        assertFalse(newContactItem.setLastName(""));
        assertFalse(newContactItem.setPhoneNumber(""));
        assertFalse(newContactItem.setEmailAddress(""));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactList newContactList = new ContactList();
        ContactItem newContactItem = new ContactItem("Success", "Success", "713-496-2053", "a@b.c", false);

        newContactList.addContact(newContactItem);
        assertFalse(newContactList.validateEditIndex(2));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList newContactList = new ContactList();
        ContactItem newContactItem = new ContactItem("Success", "Success", "713-496-2053", "a@b.c", false);

        newContactList.addContact(newContactItem);
        newContactItem.validateFirst("");
        assertEquals("", newContactItem.getFirst());
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList newContactList = new ContactList();
        ContactItem newContactItem = new ContactItem("Success", "Success", "713-496-2053", "a@b.c", false);

        newContactList.addContact(newContactItem);
        newContactItem.validateLast("");
        assertEquals("", newContactItem.getLast());
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList newContactList = new ContactList();
        ContactItem newContactItem = new ContactItem("Success", "Success", "713-496-2053", "a@b.c", false);

        newContactList.addContact(newContactItem);
        newContactItem.validatePhone("");
        assertEquals("", newContactItem.getPhone());
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
    }

    @Test
    public void newListIsEmpty(){
        ContactList newContactList = new ContactList();
        assertEquals(0, newContactList.getContacts().size());
    }

    @Test
    public void removingItemsDecreasesSize(){
        ContactList newContactList = new ContactList();

        ContactItem newContactItem1 = new ContactItem("Success", "Success", "713-496-2053", "a@b.c", false);
        ContactItem newContactItem2 = new ContactItem("Success 2", "Success 2", "713-496-2053", "a@b.c", false);
        ContactItem newContactItem3 = new ContactItem("Success 3", "Success 3", "713-496-2053", "a@b.c", false);

        newContactList.addContact(newContactItem1);
        newContactList.addContact(newContactItem2);
        newContactList.addContact(newContactItem3);

        assertEquals(3, newContactList.getContacts().size());
        newContactList.removeContactItem(0);
        assertEquals(2, newContactList.getContacts().size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactList newContactList = new ContactList();

        ContactItem newContactItem1 = new ContactItem("Success", "Success", "713-496-2053", "a@b.c", false);
        ContactItem newContactItem2 = new ContactItem("Success 2", "Success 2", "713-496-2053", "a@b.c", false);
        ContactItem newContactItem3 = new ContactItem("Success 3", "Success 3", "713-496-2053", "a@b.c", false);

        newContactList.addContact(newContactItem1);
        newContactList.addContact(newContactItem2);
        newContactList.addContact(newContactItem3);

        assertEquals(3, newContactList.getContacts().size());
        assertFalse(newContactList.removeContactItem(5));
    }

    @Test
    public void savedContactListCanBeLoaded() throws IOException {
        ContactList newContactList = new ContactList();

        ContactItem newContactItem1 = new ContactItem("Success", "Success", "713-496-2053", "a@b.c", false);
        ContactItem newContactItem2 = new ContactItem("Success 2", "Success 2", "713-496-2053", "a@b.c", false);
        ContactItem newContactItem3 = new ContactItem("Success 3", "Success 3", "713-496-2053", "a@b.c", false);

        newContactList.addContact(newContactItem1);
        newContactList.addContact(newContactItem2);
        newContactList.addContact(newContactItem3);

        String path = "test.txt";
        File file = new File("Saved_Contacts//" + path);
        newContactList.savingList(file);

        File checkFile = new File("Saved_Contacts//" + path);
        assertTrue(ContactApp.checkToExist(checkFile));
        checkFile.delete();
    }
}
