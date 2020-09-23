package duke;

import duke.commands.Command;
import duke.list.TaskList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Duke {

    private TaskList list;
    private Storage storage;

    public static void main(String[] args){
        new Duke("data/duke.txt").run("data/duke.txt");
    }

    public Duke(String filePath) {
            Ui.greet();
            storage = new Storage(filePath);
            list = new TaskList(storage);
    }

    public void run(String filePath) {
        boolean isExit = false;
        String inputCommand="";
        while (!isExit) {
            try {
                inputCommand = Parser.readCommand();
                Command c = Parser.runCommand(inputCommand,list);
                isExit = c.isExit();
            } catch (DukeException e) {
                Ui.getError(inputCommand, e.error);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}