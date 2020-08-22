import java.util.Scanner;

public class Duke {

    public static String addLines(String input){
        return "____________________________________________________________\n" +
                input+
                "\n____________________________________________________________\n";
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String greetMsg = addLines(" Hello! I'm Duke\n" + " What can I do for you?");
        String byeMsg = addLines(" Bye. Hope to see you again soon!");
        System.out.println("Hello from\n" + logo);
        System.out.println(greetMsg);

        while(true) {
            String input = in.nextLine();
            if (!input.equals("bye")) {
                String line = addLines(input);
                System.out.println(line);
            } else {
                break;
            }
        }
        System.out.println(byeMsg);
    }
}
