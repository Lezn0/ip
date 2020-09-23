package duke;

public class DukeException extends Exception{

    public String error;
    //format - wrong command format

    public DukeException(String error){
        this.error=error;
    }
}
