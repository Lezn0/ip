package duke.commands;

import duke.list.TaskList;

import java.util.Comparator;

public class deleteCommand extends Command {
    public deleteCommand(String s, TaskList list) {
        list.deleteItem(s);
    }
}
