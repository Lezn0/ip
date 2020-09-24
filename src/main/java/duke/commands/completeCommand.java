package duke.commands;

import duke.list.TaskList;

public class CompleteCommand extends Command{
    public CompleteCommand(String s, TaskList list) {
        list.completeTask(s);
    }
}
