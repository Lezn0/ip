package duke.commands;

import duke.list.TaskList;

import java.time.LocalDate;

public class DueDateCommand extends Command{
    public DueDateCommand(String s, TaskList list) {
        try {
            LocalDate due = LocalDate.parse(s);
            list.printTasksDueByDate(due);
        } catch (Exception e){
            System.out.println("Invalid date, please use YYYY-MM-DD format");
        }
    }
}
