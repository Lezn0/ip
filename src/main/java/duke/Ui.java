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

    public static void getError(String input, String error){
        switch (error) {
        case "format":
            addLines("Please enter a valid action after the command, eg: " + input + " {action}");
            break;
        case "invalid":
            addLines("Please enter a valid command");
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
}
