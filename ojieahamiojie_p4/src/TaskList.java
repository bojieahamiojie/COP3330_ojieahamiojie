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

    public TaskList(List<TaskItem> tasks){
        this.tasks = tasks;
    }

    public void addTask(TaskItem item){
        tasks.add((TaskItem) item);
    }

    public List<TaskItem> getTasks(){
        return tasks;
    }

    public void setTasks(List<TaskItem> tasks){
        this.tasks = tasks;
    }

    public boolean removeTask(int choice){
        if(this.validEditIndex(choice)) {
            this.getTasks().remove(choice);
            return true;
        }
        return false;
    }

    public boolean completedTasks(){
        int count = 0;
        for(TaskItem temp : this.getTasks()){
            if(temp.isMarked())
                count++;
        }

        if(count == this.getTasks().size() - 1)
            return true;

        return false;
    }

    public boolean uncompletedTasks(){
        int count = 0;
        for(TaskItem temp : this.getTasks()){
            if(!temp.isMarked())
                count++;
        }

        if(count == this.getTasks().size() - 1)
            return true;

        return false;
    }

    public boolean validEditIndex(int choice){
        if(choice >= 0 && choice < this.getTasks().size())
            return true;

        return false;
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

    public boolean validUnmarkIndex(int choice){
        if(choice >= 0 && choice < this.getTasks().size()) {
            if (this.getTasks().get(choice).isMarked()) {
                this.getTasks().get(choice).setUnmarked();
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

    public void printUnmarked(){
        for(int i = 0; i < tasks.size(); i++){
            TaskItem temp = tasks.get(i);

            if(!temp.isMarked()){
                System.out.println(i + ") ");
                System.out.println("[" + temp.getDueDate() + "] ");
                System.out.println(temp.getTitle() + ": ");
                System.out.println(temp.getDescription());
            }
        }
    }

    public void printMarked(){
        for(int i = 0; i < tasks.size(); i++){
            TaskItem temp = tasks.get(i);

            if(temp.isMarked()){
                System.out.println(i + ") ");
                System.out.println("[" + temp.getDueDate() + "] ");
                System.out.println(temp.getTitle() + ": ");
                System.out.println(temp.getDescription());
            }
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
