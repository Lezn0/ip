package duke.commands;

import duke.DukeException;

public class NullCommand extends Command{
    public NullCommand() throws DukeException {
        throw new DukeException("invalid");
    }
}
