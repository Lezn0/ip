package duke.list;

import duke.DukeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) throws DukeException {
        super(description);
        if(!by.equals("")) {
            try {
                Date = LocalDate.parse(by);
                isDate = true;
            } catch (Exception e) {
                this.by = by;
            }
        } else {
            throw new DukeException("deadline");
        }
    }

    @Override
    public String toString() {
        if(isDate) {
            return "[D]" + super.getDescription() + " (by: " + Date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
        } else {
            return "[D]" + super.getDescription() + " (by: " + by + ")";
        }

    }

    @Override
    public String toFileInput(){
        if(isDate) {
            return "D|" + super.getInfo() + "|" + Date + "\n";
        } else {
            return "D|" + super.getInfo() + "|" + by + "\n";
        }
    }
}