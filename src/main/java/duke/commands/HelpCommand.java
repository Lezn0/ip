package duke.commands;

import duke.Ui;

public class HelpCommand extends Command{
    public HelpCommand(){
        Ui.listAllCommands();
    }
}
