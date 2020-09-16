package duke.list;

import duke.DukeException;

import java.util.ArrayList;

public class List {

    private static ArrayList<Task> items;
    private int size;

    public List(){
        items = new ArrayList<>();
        size = 0;
    }

    public void queryItems(){
        printLine();
        System.out.println("Here are the tasks in your list:");
        for(int i=0; i<size; i++) {
            System.out.println(i+1 + ". " + items.get(i));
        }
        printLine();
    }

    public void completeTask(String input){
        int index;
        printLine();
        try{
            index=Integer.parseInt(input)-1;
            items.get(index).markAsDone();
            System.out.println("Nice! I've marked this task as done:\n" + items.get(index));
        } catch (Exception e){
            System.out.println("invalid index for item to complete, try again");
        }
        printLine();
    }

    public void addItem(String item) throws DukeException {
        Task newTask = new Task(item.trim());
        items.add(newTask);
        size++;
        itemAddedMessage(newTask);
    }

    public void addDeadline(String input) throws DukeException{
        if(!input.contains("/by")){
            throw new DukeException("deadline");
        }
        String[] deadlineInputs = input.split("/by",2);
        Deadline newDeadline= new Deadline(deadlineInputs[0].trim(),deadlineInputs[1].trim());
        items.add(newDeadline);
        size++;
        itemAddedMessage(newDeadline);
    }

    public void addEvent(String input) throws DukeException {
        if(!input.contains("/at")){
            throw new DukeException("event");
        }
        String[] eventInputs = input.split("/at",2);
        Event newEvent= new Event(eventInputs[0].trim(),eventInputs[1].trim());
        items.add(newEvent);
        size++;
        itemAddedMessage(newEvent);
    }

    public void deleteItem(String input){
        int index;
        printLine();
        try{
            index=Integer.parseInt(input)-1;

            System.out.println(
                    "Noted. I've removed this task:\n" +
                    items.get(index) +
                    "\nNow you have "+ --size + " tasks in the list." );
            items.remove(index);
        } catch (Exception e){
            System.out.println("invalid index for item to delete, try again");
        }
        printLine();
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
