package duke.list;

import duke.DukeException;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) throws DukeException {
        super(description);
        if(!by.equals("")) {
            this.by = by;
        } else {
            throw new DukeException("deadline");
        }
    }

    @Override
    public String toString() {
        return "[D]" + super.getDescription() + " (by: " + by + ")";
    }

    @Override
    public String toFileInput(){
        return "D " + super.getInfo() + " " + by + "\n";
    }
}