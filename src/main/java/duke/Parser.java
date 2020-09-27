package duke;

import duke.commands.*;
import duke.list.TaskList;

import java.io.IOException;
import java.util.Scanner;

public class Parser {
    private static final Scanner IN = new Scanner(System.in);
    private static String input= "";

    /**
     * Reads the next line that user inputs and returns it as a String
     * @return User input
     */
    public static String readCommand(){
        input = IN.nextLine();
        return input;
    }

    /**
     * Reads user commands and calls corresponding command
     * @param input user input
     * @param list  ArrayList of tasks
     * @return Command commands called by user
     * @throws DukeException if command is invalid
     * @throws IOException if error occurs modifying the file to store data
     */
    public static Command runCommand(String input, TaskList list) throws DukeException, IOException {
        String[] splitInput = input.split(" ", 2);
        if(splitInput.length==1 && !input.equals("bye") && !input.equals("list") && !input.equals("help")){
            throw new DukeException("format");
        }
        switch(splitInput[0]) {
        case "bye":
            return new ExitCommand();
        case "list":
            return new ListCommand(list);
        case "done":
            return new CompleteCommand(splitInput[1],list);
        case "todo":
        case "deadline":
        case "event":
            return new AddTaskCommand(splitInput[0], splitInput[1],list);
        case "delete":
            return new DeleteCommand(splitInput[1], list);
        case "due":
            return new DueDateCommand(splitInput[1],list);
        case "help":
            return new HelpCommand();
        case "find":
            return new FindCommand(splitInput[1], list);
        default:
            return new NullCommand();
        }

    }
}
