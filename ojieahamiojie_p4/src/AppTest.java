import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
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
        assertNotNull(App.createItem("Filler title", "Filler description", successDate, false));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        String successTitle = "Task 1";
        assertNotNull(App.createItem(successTitle, "Filler description", "2020-02-05", false));
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

    @Test
    public void addingTaskItemIncreasesSize(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);
        newList.addTask((List<TaskItem>) newItem);
        assertEquals(1, newList.getTasks().size());
    }

    @Test
    public void completingTaskItemChangesStatus(){
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        assertFalse(newItem.isMarked());
        newItem.setMarked();
        assertTrue(newItem.isMarked());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask((List<TaskItem>) newItem);
        assertFalse(newList.validMarkIndex(2));
    }

    @Test
    public void editingTaskItemDescriptionFailsWIthInvalidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask((List<TaskItem>) newItem);
        assertFalse(newList.validEditIndex(2));

    }

    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        //New values for date
        String newDate = "2020-01-01";

        newItem.setDueDate(newDate);
        assertEquals("2020-01-01", newItem.getDueDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask((List<TaskItem>) newItem);
        assertFalse(newList.validEditIndex(2));
    }

    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        //New values for title
        String newTitle = "New title!";

        newItem.setTitle(newTitle);
        assertEquals("New title!", newItem.getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask((List<TaskItem>) newItem);
        assertFalse(newList.validEditIndex(2));
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask((List<TaskItem>) newItem);
        assertFalse(newList.validEditIndex(2));
    }

    @Test
    public void gettingTaskItemDescriptionSucceedWithValidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask((List<TaskItem>) newItem);
        assertTrue(newList.validEditIndex(0));

        TaskItem getItem = newList.getTasks().get(0);
        assertEquals("Success", getItem.getDescription());

    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask((List<TaskItem>) newItem);
        assertFalse(newList.validEditIndex(2));
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask((List<TaskItem>) newItem);
        assertTrue(newList.validEditIndex(0));

        TaskItem getItem = newList.getTasks().get(0);
        assertEquals("2020-01-01", getItem.getDueDate());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask((List<TaskItem>) newItem);
        assertFalse(newList.validEditIndex(2));
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask((List<TaskItem>) newItem);
        assertTrue(newList.validEditIndex(0));

        TaskItem getItem = newList.getTasks().get(0);
        assertEquals("Success", getItem.getTitle());
    }

    @Test
    public void newTaskListsEmpty(){
        TaskList newList = new TaskList();

        assertEquals(0, newList.getTasks().size());
    }

    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskList newList = new TaskList();

        TaskItem newItem1 = new TaskItem("Success", "Success", "2020-01-01", false);
        TaskItem newItem2 = new TaskItem("Success 2", "Success 2", "2020-01-01", false);
        TaskItem newItem3 = new TaskItem("Success 3", "Success 3", "2020-01-01", false);

        newList.addTask((List<TaskItem>) newItem1);
        newList.addTask((List<TaskItem>) newItem2);
        newList.addTask((List<TaskItem>) newItem3);

        assertEquals(3, newList.getTasks().size());
        newList.removeTask(0);
        assertEquals(2, newList.getTasks().size());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskList newList = new TaskList();

        TaskItem newItem1 = new TaskItem("Success", "Success", "2020-01-01", false);
        TaskItem newItem2 = new TaskItem("Success 2", "Success 2", "2020-01-01", false);
        TaskItem newItem3 = new TaskItem("Success 3", "Success 3", "2020-01-01", false);

        newList.addTask((List<TaskItem>) newItem1);
        newList.addTask((List<TaskItem>) newItem2);
        newList.addTask((List<TaskItem>) newItem3);

        assertEquals(3, newList.getTasks().size());
        assertFalse(newList.removeTask(5));
    }

    @Test
    public void savedTaskListCanBeLoaded() throws IOException {
        TaskList newList = new TaskList();

        TaskItem newItem1 = new TaskItem("Success", "Success", "2020-01-01", false);
        TaskItem newItem2 = new TaskItem("Success 2", "Success 2", "2020-01-01", false);
        TaskItem newItem3 = new TaskItem("Success 3", "Success 3", "2020-01-01", false);

        newList.addTask((List<TaskItem>) newItem1);
        newList.addTask((List<TaskItem>) newItem2);
        newList.addTask((List<TaskItem>) newItem3);

        String path = "test.txt";
        File file = new File("Saved_Lists//" + path);
        newList.saveList(file);

        File checkFile = new File("Saved_Lists//" + path);
        assertTrue(App.checkExists(checkFile));
        checkFile.delete();

    }

    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", true);

        assertTrue(newItem.isMarked());
        newItem.setUnmarked();
        assertFalse(newItem.isMarked());
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", true);

        newList.addTask((List<TaskItem>) newItem);
        assertTrue(newList.validEditIndex(0));
        assertFalse(newList.validEditIndex(2));
    }
}
