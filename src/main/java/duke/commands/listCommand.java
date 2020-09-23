package duke.commands;

import duke.list.TaskList;

public class listCommand extends Command{
    public listCommand(TaskList list){
        list.queryItems();
    }
}
