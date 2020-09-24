package duke.commands;

import duke.list.TaskList;

import java.util.Comparator;

public class DeleteCommand extends Command {
    public DeleteCommand(String s, TaskList list) {
        list.deleteItem(s);
    }
}
