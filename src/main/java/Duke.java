import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        List list = new List();
        Scanner in = new Scanner(System.in);
        String input= "";
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello from\n" + logo);
        addLines("Hello! I'm Duke\n" + "What can I do for you?");

        while(!input.equals("bye")) {
            input = in.nextLine();
            String[] splitInput = input.split(" ", 2);
            switch(splitInput[0]){
            case "bye":
                addLines("Bye. Hope to see you again soon!");
                break;
            case "list":
                list.queryItems();
                break;
            case "done":
                list.completeTask(Integer.parseInt(splitInput[1])-1);
                break;
            case "todo":
                list.addItem(splitInput[1]);
                break;
            case "deadline":
                list.addDeadline(splitInput[1]);
                break;
            case "event":
                list.addEvent(splitInput[1]);
                break;
            default:
                addLines("invalid input!");
            }
        }
    }

    public static void addLines(String input){
        System.out.println("____________________________________________________________\n" +
                input+
                "\n____________________________________________________________\n");
    }
}