import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {
    @Test
    public void addingItemsIncreasesSize(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);
        newList.addTask(newItem);
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

        newList.addTask(newItem);
        assertFalse(newList.validMarkIndex(2));
    }

    @Test
    public void editingItemDescriptionFailsWithInvalidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask(newItem);
        assertFalse(newList.validEditIndex(2));

    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue(){
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        String newDescription = "New description!";
        newItem.setDescription(newDescription);
        assertEquals("New description!", newItem.getDescription());
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue(){
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        String newDate = "2020-01-01";

        newItem.setDueDate(newDate);
        assertEquals("2020-01-01", newItem.getDueDate());
    }

    @Test
    public void editingItemTitleFailsWithEmptyString(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        String newTitle = "";

        newItem.setTitle(newTitle);
        assertFalse(newList.validEditIndex(2));
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask(newItem);
        assertFalse(newList.validEditIndex(2));
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue(){
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        String newTitle = "New title!";

        newItem.setTitle(newTitle);
        assertEquals("New title!", newItem.getTitle());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        String newDueDate = "20200101";

        newItem.setDueDate(newDueDate);
        assertFalse(newList.validEditIndex(2));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask(newItem);
        assertFalse(newList.validEditIndex(2));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        String newDueDate = "202-01-01";

        newItem.setDueDate(newDueDate);
        assertFalse(newList.validEditIndex(2));
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask(newItem);
        assertFalse(newList.validEditIndex(2));
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask(newItem);
        assertTrue(newList.validEditIndex(0));

        TaskItem getItem = newList.getTasks().get(0);
        assertEquals("Success", getItem.getDescription());

    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask(newItem);
        assertFalse(newList.validEditIndex(2));
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask(newItem);
        assertTrue(newList.validEditIndex(0));

        TaskItem getItem = newList.getTasks().get(0);
        assertEquals("2020-01-01", getItem.getDueDate());
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask(newItem);
        assertFalse(newList.validEditIndex(2));
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex(){
        TaskList newList = new TaskList();
        TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

        newList.addTask(newItem);
        assertTrue(newList.validEditIndex(0));

        TaskItem getItem = newList.getTasks().get(0);
        assertEquals("Success", getItem.getTitle());
    }

    @Test
    public void newListIsEmpty(){
        TaskList newList = new TaskList();

        assertEquals(0, newList.getTasks().size());
    }

    @Test
    public void removingItemsDecreasesSize(){
        TaskList newList = new TaskList();

        TaskItem newItem1 = new TaskItem("Success", "Success", "2020-01-01", false);
        TaskItem newItem2 = new TaskItem("Success 2", "Success 2", "2020-01-01", false);
        TaskItem newItem3 = new TaskItem("Success 3", "Success 3", "2020-01-01", false);

        newList.addTask(newItem1);
        newList.addTask(newItem2);
        newList.addTask(newItem3);

        assertEquals(3, newList.getTasks().size());
        newList.removeTask(0);
        assertEquals(2, newList.getTasks().size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        TaskList newList = new TaskList();

        TaskItem newItem1 = new TaskItem("Success", "Success", "2020-01-01", false);
        TaskItem newItem2 = new TaskItem("Success 2", "Success 2", "2020-01-01", false);
        TaskItem newItem3 = new TaskItem("Success 3", "Success 3", "2020-01-01", false);

        newList.addTask(newItem1);
        newList.addTask(newItem2);
        newList.addTask(newItem3);

        assertEquals(3, newList.getTasks().size());
        assertFalse(newList.removeTask(5));
    }

    @Test
    public void savedTaskListCanBeLoaded() throws IOException {
        TaskList newList = new TaskList();

        TaskItem newItem1 = new TaskItem("Success", "Success", "2020-01-01", false);
        TaskItem newItem2 = new TaskItem("Success 2", "Success 2", "2020-01-01", false);
        TaskItem newItem3 = new TaskItem("Success 3", "Success 3", "2020-01-01", false);

        newList.addTask(newItem1);
        newList.addTask(newItem2);
        newList.addTask(newItem3);

        String path = "test.txt";
        File file = new File("Saved_Lists//" + path);
        newList.saveList(file);

        File checkFile = new File("Saved_Lists//" + path);
        assertTrue(TaskApp.checkExists(checkFile));
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

        newList.addTask(newItem);
        assertTrue(newList.validEditIndex(0));
        assertFalse(newList.validEditIndex(2));
    }
}
//@Test
//public void editingTaskItemTitleChangesValue(){
//    TaskItem newItem = new TaskItem("Success", "Success", "2020-01-01", false);

//New values for title
//    String newTitle = "New title!";

//    newItem.setTitle(newTitle);
//    assertEquals("New title!", newItem.getTitle());
//}
