public class DukeException extends Exception{

    //format - wrong command format
    protected String error;

    DukeException(String error){
        this.error=error;
    }

    public void getError(String input){
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

    public static void addLines(String input){
        System.out.println("____________________________________________________________\n" +
                input+
                "\n____________________________________________________________\n");
    }
}
