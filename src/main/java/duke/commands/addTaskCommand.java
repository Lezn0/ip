package duke.commands;

import duke.DukeException;
import duke.list.TaskList;

import java.io.IOException;

public class addTaskCommand extends Command{
    public addTaskCommand(String type, String input, TaskList list) throws IOException, DukeException {
        switch(type){
        case "todo":
            list.addTask(input);
            break;
        case "deadline":
            list.addDeadline(input);
            break;
        case "event":
            list.addEvent(input);
            break;
        }
    }
}
