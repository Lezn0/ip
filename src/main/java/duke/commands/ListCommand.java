package duke.commands;

import duke.list.TaskList;

public class ListCommand extends Command{
    public ListCommand(TaskList list){
        list.queryItems();
    }
}
