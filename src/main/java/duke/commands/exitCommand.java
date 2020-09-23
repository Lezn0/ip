package duke.commands;

import duke.Ui;

public class exitCommand extends Command{

    public exitCommand(){
        Ui.leaveMsg();
    }

    @Override
    public boolean isExit(){
        return true;
    }
}
