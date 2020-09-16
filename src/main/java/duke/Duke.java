package duke;

import duke.list.List;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Duke {
    private static final List LIST = new List();
    private static final Scanner IN = new Scanner(System.in);
    public static void main(String[] args) throws DukeException, FileNotFoundException {
        String input= "";
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello from\n" + logo);
        addLines("Hello! I'm Duke\n" + "What can I do for you?");
        runCommand(input);
    }

    private static void runCommand(String input) throws DukeException, FileNotFoundException {
        try {
            List.readFileContents();
        } catch (FileNotFoundException | DukeException e) {
            e.printStackTrace();
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
                    List.writeToFile();
                    addLines("Bye. Hope to see you again soon!");
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
                e.getError(input);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public static void addLines(String input){
        System.out.println("____________________________________________________________\n" +
                input+
                "\n____________________________________________________________");
    }
}