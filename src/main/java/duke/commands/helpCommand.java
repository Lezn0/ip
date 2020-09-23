package duke.commands;

import duke.Ui;

public class helpCommand extends Command{
    public helpCommand(){
        Ui.listAllCommands();
    }
}
