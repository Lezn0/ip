package duke.list;

import duke.DukeException;
import duke.Storage;
import duke.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import static duke.Ui.printLine;

public class TaskList {
    private Storage storage;
    private static ArrayList<Task> items;
    private static int size;

    /**
     * Constructor for TaskList
     * Read in stored data in duke.txt and makes a new directory for duke.txt
     * if it does not exist
     * @param inStorage Storage class that is linked to the file path of data
     */
    public TaskList(Storage inStorage) {
        items = new ArrayList<>();
        size = 0;
        storage = inStorage;
        try {
            storage.readFileContents();
        } catch (FileNotFoundException e) {
            File dir = new File("data");
            Ui.addLines("no file found");
            if (dir.mkdirs()) {
                Ui.addLines("Successfully made directory to store data!");
            }
        } catch (DukeException e){
            e.printStackTrace();
        }
    }

    /**
     *  Prints out all items inside the Task List
     */
    public void queryItems(){
        printLine();
        System.out.println("Here are the tasks in your list:");
        for(int i=0; i<size; i++) {
            System.out.println(i+1 + ". " + items.get(i));
        }
        printLine();
    }

    /**
     * Marks the isDone of item with corresponding index to be true
     * Warns user to retry if invalid index is provided
     * @param input String input of index
     */
    public void completeTask(String input){
        int index;
        printLine();
        try{
            index=Integer.parseInt(input)-1;
            items.get(index).markAsDone();
            System.out.println("Nice! I've marked this task as done:\n" + items.get(index));
            storage.writeToFile(items,size);
        } catch (Exception e){
            System.out.println("invalid index for item to complete, try again");
        }
        printLine();
    }

    /**
     * Adds a new Task to the Task List
     * @param item description of Task
     * @throws DukeException thrown in Task class
     * @throws IOException If task appending to file fails
     */
    public void addTask(String item) throws DukeException, IOException {
        Task newTask = new Task(item.trim());
        items.add(newTask);
        size++;
        storage.appendToFile(newTask);
        itemAddedMessage(newTask);
    }

    /**
     * Adds a new deadline to the Task List
     * @param input description with deadline
     * @throws DukeException If /by does not exist in input
     * @throws IOException If deadline appending to file fails
     */
    public void addDeadline(String input) throws DukeException, IOException {
        if(!input.contains("/by")){
            throw new DukeException("deadline");
        }
        String[] deadlineInputs = input.split("/by",2);
        Deadline newDeadline= new Deadline(deadlineInputs[0].trim(),deadlineInputs[1].trim());
        items.add(newDeadline);
        size++;
        storage.appendToFile(newDeadline);
        itemAddedMessage(newDeadline);
    }

    /**
     * Adds a new event to the Task List
     * @param input description with time for event
     * @throws DukeException If /at does not exist in input
     * @throws IOException If event appending to file fails
     */
    public void addEvent(String input) throws DukeException, IOException {
        if(!input.contains("/at")){
            throw new DukeException("event");
        }
        String[] eventInputs = input.split("/at",2);
        Event newEvent= new Event(eventInputs[0].trim(),eventInputs[1].trim());
        items.add(newEvent);
        size++;
        storage.appendToFile(newEvent);
        itemAddedMessage(newEvent);
    }

    /**
     * Adds item read from stored file duke.txt
     * @param item Task read from file
     */
    public static void addFileContents(Task item){
        items.add(item);
        size++;
    }

    /**
     * Deletes the item with corresponding index from the Task List
     * Warns user to retry if invalid index is provided
     * @param input String input of index
     */
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
            storage.writeToFile(items,size);
        } catch (Exception e){
            System.out.println("invalid index for item to delete, try again");
        }
        printLine();
    }

    /**
     * Prints message to inform user that task has been added
     * and how many items the list currently have
     * @param item Task added
     */
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

    /**
     * Prints tasks with description that contains key
     * @param key Keyword user is looking for
     */
    public void findTask(String key) {
        printLine();
        System.out.println("Here are the matching tasks in your list:");
        int count = 1;
        for (int i = 0; i < size; i++) {
            Task temp = items.get(i);
            if (temp.description.contains(key)) {
                System.out.println(count++ + ". " + items.get(i));
            }
        }
    }

    /**
     * Prints out tasks with due date corresponding to the user input due date
     * Only accepts YYYY-MM-DD format
     * @param due User input due date
     */
    public void printTasksDueByDate(LocalDate due) {
        printLine();
        System.out.println("Here are the tasks that are due on "+ due +" in your list:");
        for(int i=0; i<size; i++) {
            Task item = items.get(i);
            if(item.isDate && item.Date.equals(due)) {
                System.out.println(i + 1 + ". " + items.get(i));
            }
        }
        printLine();
    }
}
