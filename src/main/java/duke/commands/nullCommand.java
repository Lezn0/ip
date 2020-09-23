package duke.commands;

import duke.DukeException;
import duke.Ui;

public class nullCommand extends Command{
    public nullCommand() throws DukeException {
        throw new DukeException("invalid");
    }
}
