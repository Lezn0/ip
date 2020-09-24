package duke.commands;

import duke.Ui;

public class ExitCommand extends Command{

    public ExitCommand(){
        Ui.leaveMsg();
    }

    @Override
    public boolean isExit(){
        return true;
    }
}
