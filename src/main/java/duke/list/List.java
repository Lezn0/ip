package duke.list;

import duke.DukeException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.util.ArrayList;

public class List {

    private static ArrayList<Task> items;
    private static int size;

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

    public void addItem(String item) throws DukeException, IOException {
        Task newTask = new Task(item.trim());
        items.add(newTask);
        size++;
        appendToFile(newTask);
        itemAddedMessage(newTask);
    }

    public void addDeadline(String input) throws DukeException, IOException {
        if(!input.contains("/by")){
            throw new DukeException("deadline");
        }
        String[] deadlineInputs = input.split("/by",2);
        Deadline newDeadline= new Deadline(deadlineInputs[0].trim(),deadlineInputs[1].trim());
        items.add(newDeadline);
        size++;
        appendToFile(newDeadline);
        itemAddedMessage(newDeadline);
    }

    public void addEvent(String input) throws DukeException, IOException {
        if(!input.contains("/at")){
            throw new DukeException("event");
        }
        String[] eventInputs = input.split("/at",2);
        Event newEvent= new Event(eventInputs[0].trim(),eventInputs[1].trim());
        items.add(newEvent);
        size++;
        appendToFile(newEvent);
        itemAddedMessage(newEvent);
    }

    private static void printLine(){
        System.out.println("____________________________________________________________");
    }

    public static void readFileContents() throws FileNotFoundException, DukeException {
        try {
            File f = new File("data/duke.txt"); // create a File for the given file path
            Scanner s = new Scanner(f); // create a Scanner using the File as the source
            while (s.hasNext()) {
                String[] splitFileInput = s.nextLine().split(" ", 4);
                switch (splitFileInput[0]) {
                case "T":
                    Task newTask = new Task(splitFileInput[2].trim());
                    newTask.isDone = Boolean.parseBoolean(splitFileInput[1]);
                    items.add(newTask);
                    break;
                case "D":
                    Task newDeadline = new Deadline(splitFileInput[2].trim(), splitFileInput[3]);
                    newDeadline.isDone = Boolean.parseBoolean(splitFileInput[1]);
                    items.add(newDeadline);
                    break;
                case "E":
                    Task newEvent = new Event(splitFileInput[2].trim(), splitFileInput[3]);
                    newEvent.isDone = Boolean.parseBoolean(splitFileInput[1]);
                    items.add(newEvent);
                    break;
                default:
                    continue;
                }
                size++;
            }
        } catch (FileNotFoundException e) {
            printLine();
            File dir = new File("data");
            dir.mkdirs();
            System.out.println("no file found");
            printLine();
        }
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
            writeToFile();
        } catch (Exception e){
            System.out.println("invalid index for item to delete, try again");
        }
        printLine();
    }
    private static void appendToFile(Task input) throws IOException {
        FileWriter fw = new FileWriter("data/duke.txt",true);
        String fileInput = input.toFileInput();
        fw.write(fileInput);
        fw.close();
    }

    public static void writeToFile() throws IOException {
        FileWriter fw = new FileWriter("data/duke.txt");
        for(int i=0; i<size ;i++){
            String fileInput = items.get(i).toFileInput();
            fw.write(fileInput);
        }
        fw.close();
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
