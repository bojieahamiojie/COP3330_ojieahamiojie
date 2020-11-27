import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<TaskItem> tasks;

    public TaskList(){
        this.tasks = new ArrayList<>();
    }

    public void addTask(TaskItem item){
        tasks.add(item);
    }

    public List<TaskItem> getTasks(){
        return tasks;
    }

    public boolean removeTask(int choice){
        if(this.validEditIndex(choice)) {
            this.getTasks().remove(choice);
            return true;
        }
        return false;
    }

    public boolean validEditIndex(int choice){
        return choice >= 0 && choice < this.getTasks().size();
    }

    public boolean validMarkIndex(int choice){
        if(choice >= 0 && choice < this.getTasks().size()) {
            if (!(this.getTasks().get(choice).isMarked())) {
                this.getTasks().get(choice).setMarked();
                return true;
            }
        }
        return false;
    }

    public void printElements(){
        for(int i = 0; i < tasks.size(); i++){
            System.out.println(i + ") ");
            TaskItem temp = tasks.get(i);

            if(temp.isMarked())
                System.out.println("*** ");
            System.out.println("[" + temp.getDueDate() + "] ");
            System.out.println(temp.getTitle() + ": ");
            System.out.println(temp.getDescription());
        }
    }

    public void saveList(File file) throws IOException{
        FileWriter fw = new FileWriter(file);
        for(TaskItem temp : tasks){
            String line = temp.getTitle() + "|";
            line += temp.getTitle() + "|";
            line += temp.getDueDate() + "|";
            line += temp.isMarked() + "\n";
            fw.write(line);
        }
        fw.close();
    }
}
