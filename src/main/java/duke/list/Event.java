package duke.list;

import duke.DukeException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected String at;
    protected LocalDate Date;
    public Event(String description, String at) throws DukeException {
        super(description);
        if(!at.equals("")) {
            try {
                Date = LocalDate.parse(at);
                isDate = true;
            } catch (Exception e) {
                this.at = at;
            }
        } else {
            throw new DukeException("event");
        }
    }
    @Override
    public String toString() {
        if(isDate) {
            return "[D]" + super.getDescription() + " (by: " + Date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
        } else {
            return "[D]" + super.getDescription() + " (by: " + at + ")";
        }

    }

    @Override
    public String toFileInput(){
        if(isDate) {
            return "D|" + super.getInfo() + "|" + Date + "\n";
        } else {
            return "D|" + super.getInfo() + "|" + at + "\n";
        }
    }
}