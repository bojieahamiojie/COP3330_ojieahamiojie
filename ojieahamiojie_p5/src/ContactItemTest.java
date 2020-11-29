import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues() {
        String blankFirst = "";
        String blankLast = "";
        String blankPhone = "";
        String blankEmail = "";
        assertNull(ContactApp.createContactItem(blankFirst, blankLast, blankPhone, blankEmail, false));
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        String blankEmail = "";
        assertNotNull(ContactApp.createContactItem("Jazzy", "Kirk", "321-058-2957", blankEmail, false));
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        String blankFirst = " ";
        assertNotNull(ContactApp.createContactItem(blankFirst, "Kirk", "321-058-2957", "kirkjazz@corp.org", false));
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        String blankLast = " ";
        assertNotNull(ContactApp.createContactItem("Jazzy", blankLast, "321-058-2957", "kirkjazz@corp.org", false));
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        String blankPhone = " ";
        assertNotNull(ContactApp.createContactItem("Jazzy", "Kirk", blankPhone, "kirkjazz@corp.org", false));
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        String firstName = "Jazzy";
        String lastName = "Kirk";
        String phoneNumber = "321-058-2957";
        String emailAddress = "kirkjazz@corp.org";
        assertNotNull(ContactApp.createContactItem(firstName, lastName, phoneNumber, emailAddress, false));
    }

    @Test
    public void editingFailsWithAllBlankValues() {
        String editBlankFirst = "";
        String editBlankLast = "";
        String editBlankPhone = "";
        String editBlankEmail = "";
        ContactItem temp = new ContactItem("Success", "Success", "713-496-2053", "a@b.c", false);
        assertFalse(temp.setFirstName(editBlankFirst));
        assertFalse(temp.setLastName(editBlankLast));
        assertFalse(temp.setPhoneNumber(editBlankPhone));
        assertFalse(temp.setEmailAddress(editBlankEmail));
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactItem temp = new ContactItem();
        String blankEmail = "";
        assertEquals(blankEmail, temp.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem temp = new ContactItem();
        String blankFirst = "";
        assertEquals(blankFirst, temp.getFirst());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem temp = new ContactItem();
        String blankLast = "";
        assertEquals(blankLast, temp.getLast());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem temp = new ContactItem();
        String blankPhone = "";
        assertEquals(blankPhone, temp.getPhone());
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        String nonBlankFirst = "Erica";
        String nonBlankLast = "Pinkett";
        String nonBlankPhone = "407-395-2943";
        String nonBlankEmail = "epinkett@cia.gov";
        ContactItem temp = new ContactItem("Success", "Success", "713-496-2053", "a@b.c", false);
        assertTrue(temp.setFirstName(nonBlankFirst));
        assertTrue(temp.setLastName(nonBlankLast));
        assertTrue(temp.setPhoneNumber(nonBlankPhone));
        assertTrue(temp.setEmailAddress(nonBlankEmail));
    }

    @Test
    public void testToString(){
        ContactItem contact = new ContactItem("Aaliyah", "Jenkins", "321-847-5285", "liyahjay@perkins.edu", false);
        assertEquals("Name: Aaliyah Jenkins\n" + "Phone number: 321-847-5285\n" + "Email address: liyahjay@perkins.edu\n", contact.toString());
    }
}
