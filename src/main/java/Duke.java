import java.util.Scanner;

public class Duke {
    private static final List LIST = new List();
    private static final Scanner IN = new Scanner(System.in);
    public static void main(String[] args) {
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

    private static void runCommand(String input) {
        while(!input.equals("bye")) {
            input = IN.nextLine();
            try {
                String[] splitInput = input.split(" ", 2);
                switch(splitInput[0]){
                case "bye":
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
                default:
                    addLines("invalid command!");
                }
            } catch (Exception e) {
                addLines("Please enter a valid action after the command");
            }
        }
    }

    public static void addLines(String input){
        System.out.println("____________________________________________________________\n" +
                input+
                "\n____________________________________________________________\n");
    }
}