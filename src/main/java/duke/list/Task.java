package duke.list;

import duke.DukeException;

public class Task {

    protected String description;
    protected boolean isDone;

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

    public String getDescription() {
        return "[" + getStatusIcon() + "]" + description;
    }
}
