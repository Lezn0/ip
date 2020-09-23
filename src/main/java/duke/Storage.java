package duke;

import duke.list.Deadline;
import duke.list.Event;
import duke.list.Task;
import duke.list.TaskList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private final String filePath;

    public Storage(String input){
        filePath = input;
        try {
            readFileContents();
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

    public void readFileContents () throws FileNotFoundException, DukeException {
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String[] splitFileInput = s.nextLine().split("\\|", 4);
            switch (splitFileInput[0]) {
            case "T":
                Task newTask = new Task(splitFileInput[2].trim());
                newTask.setDone(Boolean.parseBoolean(splitFileInput[1]));
                TaskList.addFileContents(newTask);
                break;
            case "D":
                Task newDeadline = new Deadline(splitFileInput[2].trim(), splitFileInput[3]);
                newDeadline.setDone(Boolean.parseBoolean(splitFileInput[1]));
                TaskList.addFileContents(newDeadline);
                break;
            case "E":
                Task newEvent = new Event(splitFileInput[2].trim(), splitFileInput[3]);
                newEvent.setDone(Boolean.parseBoolean(splitFileInput[1]));
                TaskList.addFileContents(newEvent);
                break;
            }
        }
    }

    public void appendToFile (Task input) throws IOException {
        FileWriter fw = new FileWriter(filePath, true);
        String fileInput = input.toFileInput();
        fw.write(fileInput);
        fw.close();
    }

    public void writeToFile (ArrayList < Task > items,int size) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (int i = 0; i < size; i++) {
            String fileInput = items.get(i).toFileInput();
            fw.write(fileInput);
        }
        fw.close();
    }

}