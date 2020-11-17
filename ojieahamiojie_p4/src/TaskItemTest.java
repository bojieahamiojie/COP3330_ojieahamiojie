import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        String failDate = "20205105151";
        assertNull(App.createItem("Filler title", "Filler description", failDate, false));
    }

    @Test
    public void creatingTaskItemFailsWIthInvalidTitle(){
        String failTitle = "";
        assertNull(App.createItem(failTitle, "Filler description", "2020-01-01", false));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        String successDate = "2020-01-01";
        assertNotNull(App.createItem("Filler title", "Filler desciption", successDate, false));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        String successTitle = "Task 1";
        assertNotNull(App.createItem(successTitle, "Filler desciption", "2020-02-05", false));
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        String failDate = "20200202";
        TaskItem temp = new TaskItem("Success", "Success", failDate, false);
        assertFalse(temp.setDueDate(failDate));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        String successDate = "2020-05-04";
        TaskItem temp = new TaskItem("Success", "Success", "0120-01-01", false);
        assertTrue(temp.setDueDate(successDate));
    }

    @Test
    public void settingTaskItemTileFailsWithInvalidTitle(){
        String failTitle = "";
        TaskItem temp = new TaskItem("Good title", "Success", "0120-01-01", false);
        assertFalse(temp.setTitle(failTitle));
    }

    @Test
    public void settingTaskItemSucceedsWithValidTitle(){
        String successTitle = "New title";
        TaskItem temp = new TaskItem("Success", "Success", "0120-01-01", false);
        assertTrue(temp.setTitle(successTitle));
    }
}
