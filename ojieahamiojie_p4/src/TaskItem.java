public class TaskItem {
    private String title;
    private String description;
    private String dueDate;
    private boolean marked;

    public TaskItem(){
        this.title = "";
        this.description = "";
        this.dueDate = "";
        this.marked = false;
    }

    public TaskItem(String title, String description, String dueDate, boolean marked){
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.marked = marked;
    }

    public String getTitle(){
        return title;
    }

    public boolean setTitle(String title){
        if(!this.validateTitle(title)){
            System.out.println("\nWARNING: Title must be at least 1 character long; task not created\n");
            return false;
        }
        this.title = title;
        return true;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDueDate(){
        return dueDate;
    }

    public boolean setDueDate(String dueDate){
        if(!this.validateData(dueDate)){
            System.out.println("\nWARNING: Invalid due date; task not created\n");
            return false;
        }
        this.dueDate = dueDate;
        return true;
    }

    public boolean isMarked(){
        return marked;
    }

    public void setMarked(){
        this.marked = true;
    }

    public void setUnmarked(){
        this.marked = false;
    }

    public boolean validateTitle(String title){
        if(title.length() < 1)
            return false;

        return true;
    }

    public boolean validateData(String date){
        String[] parsedDate = date.split("-");

        if(parsedDate.length != 3)
            return false;

        String year = parsedDate[0];
        String month = parsedDate[1];
        String day = parsedDate[2];

        if(year.length() != 4 || !(year.matches("[0-9]+")))
            return false;
        if(month.length() != 2 || !(month.matches("[0-9]+")))
            return false;
        if (day.length() != 2 || !(day.matches("[0-9]+")))
            return false;

        return true;
    }
}