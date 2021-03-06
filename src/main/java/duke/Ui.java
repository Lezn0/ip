package duke;

public class Ui {
    private static final String logo = " ____        _        \n"
                                    + "|  _ \\ _   _| | _____ \n"
                                    + "| | | | | | | |/ / _ \\\n"
                                    + "| |_| | |_| |   <  __/\n"
                                    + "|____/ \\__,_|_|\\_\\___|\n";
    public static void greet(){
        System.out.println("Hello from\n" + logo);
        addLines("Hello! I'm Duke\n" + "What can I do for you?");
    }

    public static void addLines(String input){
        System.out.println("____________________________________________________________\n" +
                input+
                "\n____________________________________________________________");
    }

    public static void printLine(){
        System.out.println("____________________________________________________________");
    }
    public static void inValidCommad(){

    }
    public static void leaveMsg(){
        addLines("Bye. Hope to see you again soon!");
    }

    /**
     * Prints to the user what went wrong with the command they entered
     * @param input User input
     * @param error error occurred
     */
    public static void getError(String input, String error){
        switch (error) {
        case "format":
            addLines("Please enter a valid action after the command, eg: " + input + " {action}");
            break;
        case "invalid":
            addLines("Please enter a valid command, try using \"help\"");
            break;
        case "deadline":
            addLines("Please input a valid deadline using the \"deadline {task} /by {time} \" format");
            break;
        case "event":
            addLines("Please input a valid event using the \"event {task} /at {time} \" format\");");
            break;
        case "todo":
            addLines("Please input a valid todo using the \"todo {task}\" format");
        }
    }

    /**
     * Prints out all commands available to the program and their syntax
     */
    public static void listAllCommands(){
        printLine();
        System.out.println("Here are all the current available commands:");
        System.out.println("    1. Add a new deadline: \"deadline [task description] /by [date in string or YYYY-MM-DD]\"");
        System.out.println("    2. Add a new event: \"event [task description] /at [date in string or YYYY-MM-DD]\"");
        System.out.println("    3. Add a new todo: \"todo [task description]\" format");
        System.out.println("    4. List out all tasks: \"list\"");
        System.out.println("    5. Mark out task as completed: \"done [index of task in list]\"");
        System.out.println("    6. Delete task: \"delete [index of task in list]\"");
        System.out.println("    7. List all task due on date: \"due [date in YYYY-MM-DD format]\"");
        System.out.println("    8. Find item with key: \"find [key]\"");
        System.out.println("    9. End program: \"bye\"");
        printLine();
    }
}
