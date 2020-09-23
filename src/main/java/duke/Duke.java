package duke;

import java.io.FileNotFoundException;
public class Duke {
    public static void main(String[] args) throws DukeException, FileNotFoundException {
        Ui.greet();
        Parser.runCommand("data/duke.txt");
    }
}