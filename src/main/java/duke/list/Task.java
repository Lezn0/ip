package duke.list;

import duke.DukeException;

import java.time.LocalDate;

public class Task {

    public boolean isDate;
    protected String description;
    protected boolean isDone;
    protected LocalDate Date;

    public Task(String description) throws DukeException {
        if(!description.equals("")) {
            this.description = description;
            this.isDone = false;
        } else {
            throw new DukeException("todo");
        }

    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone(){
        isDone = true;
    }

    public String toString(){
        return "[T][" + getStatusIcon() + "]" + description;
    }

    public void setDone(boolean done){
        this.isDone=done;
    }

    protected String getDescription() {
        return "[" + getStatusIcon() + "]" + description;
    }

    public String toFileInput(){
        return "T|" + isDone + "|" + description + "\n";
    }

    protected String getInfo(){
        return isDone + "|" + description;
    }
}
