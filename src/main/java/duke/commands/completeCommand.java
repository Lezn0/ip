package duke.commands;

import duke.list.TaskList;

public class completeCommand extends Command{
    public completeCommand(String s, TaskList list) {
        list.completeTask(s);
    }
}
