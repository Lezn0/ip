package duke.list;

import duke.DukeException;

public class Event extends Task {

    protected String at;

    public Event(String description, String at) throws DukeException {
        super(description);
        if(!at.equals("")) {
            this.at = at;
        } else {
            throw new DukeException("event");
        }
    }
    @Override
    public String toString() {
        return "[E]" + super.getDescription() + "(at: " + at + ")";
    }

    @Override
    public String toFileInput(){
        return "E " + super.getInfo() + " " + at + "\n";
    }

}