package duke;

import duke.commands.Command;
import duke.list.TaskList;

public class Duke {

    private TaskList list;
    private Storage storage;

    public static void main(String[] args){
        new Duke("data/duke.txt").run();
    }

    public Duke(String filePath) {
            Ui.greet();
            storage = new Storage(filePath);
            list = new TaskList(storage);
    }

    public void run() {
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