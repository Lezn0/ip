import java.util.Scanner;

public class Duke {

    public static String addLines(String input){
        return "____________________________________________________________\n" +
                input+
                "\n____________________________________________________________\n";
    }

    public static void main(String[] args) {
        List list = new List();
        Scanner in = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String greetMsg = addLines("Hello! I'm Duke\n" + "What can I do for you?");
        String byeMsg = addLines("Bye. Hope to see you again soon!");
        System.out.println("Hello from\n" + logo);
        System.out.println(greetMsg);

        while(true) {
            String input = in.nextLine();
            if (!input.equals("bye")) {
                if(input.equals("list")){
                    list.queryItems();
                } else if(input.contains("done")) {
                    String index = input.replace("done ","");
                    list.completeTask(Integer.parseInt(index)-1);
                } else {
                    String line = addLines("added: " + input);
                    list.addItem(input);
                    System.out.println(line);
                }

            } else {
                break;
            }
        }

        System.out.println(byeMsg);
    }
}
