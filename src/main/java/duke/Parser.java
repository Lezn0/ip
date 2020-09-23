package duke;

import duke.list.TaskList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Parser {
    private static TaskList LIST;
    private static final Scanner IN = new Scanner(System.in);
    private static String input= "";

    public static void runCommand(String filePath) throws DukeException, FileNotFoundException {
        try {
            LIST = new TaskList(filePath);
        } catch (Exception e) {
            LIST = new TaskList();
        }

        while(!input.equals("bye")) {
            input = IN.nextLine();
            try {
                String[] splitInput = input.split(" ", 2);
                if(splitInput.length==1 && !input.equals("bye") && !input.equals("list")){
                    throw new DukeException("format");
                }
                switch(splitInput[0]) {
                case "bye":
                    Ui.addLines("Bye. Hope to see you again soon!");
                    break;
                case "list":
                    LIST.queryItems();
                    break;
                case "done":
                    LIST.completeTask(splitInput[1]);
                    break;
                case "todo":
                    LIST.addItem(splitInput[1]);
                    break;
                case "deadline":
                    LIST.addDeadline(splitInput[1]);
                    break;
                case "event":
                    LIST.addEvent(splitInput[1]);
                    break;
                case "delete":
                    LIST.deleteItem(splitInput[1]);
                    break;
                default:
                    if (splitInput.length == 2){
                        throw new DukeException("invalid");
                    }
                }
            } catch (DukeException e) {
                Ui.getError(input, e.error);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
