package duke.list;

import duke.DukeException;

public class List {

    private static Task[] items;
    private int size;

    public List(){
        items = new Task[100];
        size = 0;
    }

    public void queryItems(){
        printLine();
        System.out.println("Here are the tasks in your list:");
        for(int i=0; i<size; i++) {
            System.out.println(i+1 + ". " + items[i]);
        }
        printLine();
    }

    public void completeTask(String input){
        int index;
        printLine();
        try{
            index=Integer.parseInt(input)-1;
            items[index].markAsDone();
            System.out.println("Nice! I've marked this task as done:\n"+items[index]);
        } catch (Exception e){
            System.out.println("invalid index, try again");
        }
        printLine();
    }

    public void addItem(String item) throws DukeException {
        Task newTask = new Task(item.trim());
        items[size] = newTask;
        size++;
        itemAddedMessage(newTask);
    }

    public void addDeadline(String input) throws DukeException{
        if(!input.contains("/by")){
            throw new DukeException("deadline");
        }
        String[] deadlineInputs = input.split("/by",2);
        Deadline newDeadline= new Deadline(deadlineInputs[0].trim(),deadlineInputs[1].trim());
        items[size] = newDeadline;
        size++;
        itemAddedMessage(newDeadline);
    }

    public void addEvent(String input) throws DukeException {
        if(!input.contains("/at")){
            throw new DukeException("event");
        }
        String[] eventInputs = input.split("/at",2);
        Event newEvent= new Event(eventInputs[0].trim(),eventInputs[1].trim());
        items[size] = newEvent;
        size++;
        itemAddedMessage(newEvent);
    }

    private void printLine(){
        System.out.println("____________________________________________________________");
    }

    private void itemAddedMessage(Task item){
        printLine();
        System.out.println("Got it. I've added this task:\n" + item);
        if(size>1) {
            System.out.println("Now you have " + size + " tasks in the list.");
        } else{
            System.out.println("Now you have " + size + " task in the list.");
        }
        printLine();
    }
}
