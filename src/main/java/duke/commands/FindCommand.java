package duke.commands;

import duke.list.TaskList;

public class FindCommand extends Command{

    public FindCommand(String key, TaskList list) {
        list.findTask(key);
    }
}
