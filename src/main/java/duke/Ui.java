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
    public static void listAllCommands(){
        printLine();
        System.out.println("Here are all the current available commands:");
        System.out.println("    Add a new deadline: \"deadline {task} /by {time} \" format");
        System.out.println("    Add a new event: \"event {task} /at {time} \" format\");");
        System.out.println("    Add a new todo: \"todo {task}\" format");
        System.out.println("    List out all tasks: \"list\"");
        System.out.println("    Mark out task as completed: \"done {index of task in list}\"");
        System.out.println("    Delete task: \"delete {index of task in list}\"");
        System.out.println("    List all task due on date: \"due {date in YYYY-MM-DD format}\"");
        printLine();
    }
}
