import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {
    @Test
    public void constructorFailsWithInvalidDueDate() {
        String failDate = "20205105151";
        assertNull(TaskApp.createItem("Filler title", "Filler description", failDate, false));
    }

    @Test
    public void constructorFailsWIthInvalidTitle() {
        String failTitle = "";
        assertNull(TaskApp.createItem(failTitle, "Filler description", "2020-01-01", false));
    }

    @Test
    public void constructorSucceedsWithValidDueDate() {
        String successDate = "2020-01-01";
        assertNotNull(TaskApp.createItem("Filler title", "Filler description", successDate, false));
    }

    @Test
    public void constructorSucceedsWithValidTitle() {
        String successTitle = "Task 1";
        assertNotNull(TaskApp.createItem(successTitle, "Filler description", "2020-02-05", false));
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue() {
        String goodDescription = "Edited description";
        TaskItem temp = new TaskItem("Success", "Success", "2020-05-08", false);
        assertFalse(temp.setDescription(goodDescription));
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat() {
        String failDateFormat = "20200202";
        TaskItem temp = new TaskItem("Success", "Success", "2020-01-01", false);
        assertFalse(temp.setDueDate(failDateFormat));
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD() {
        String invalidDate = "202-02-02";
        TaskItem temp = new TaskItem("Success", "Success", invalidDate, false);
        assertFalse(temp.setDueDate(invalidDate));
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue() {
        String expectedDueDate = "2020-11-21";
        TaskItem temp = new TaskItem("Filler title", "Filler description", "2020-01-01", false);
        assertTrue(temp.setDueDate(expectedDueDate));
    }

    @Test
    public void editingTitleFailsWithEmptyString() {
        String failTitle = "";
        TaskItem temp = new TaskItem("Good title", "Success", "2019-01-01", false);
        assertFalse(temp.setTitle(failTitle));
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue() {
        String goodTitle = "Edited title";
        TaskItem temp = new TaskItem("Success", "Success", "2020-01-01", false);
        assertTrue(temp.setTitle(goodTitle));
    }
}