public class List {

    private Task[] items;
    private int size;

    List(){
        items = new Task[100];
        size = 0;
    }

    public void queryItems(){
        System.out.println("____________________________________________________________\n" +
                "Here are the tasks in your list: ");
        int count=1;
        for(Task item: items){
            if(item!=null) {
                System.out.println(count+". "+item.toString());
                count++;
            } else {
                break;
            }
        }
        System.out.println("____________________________________________________________");
    }

    public void completeTask(int index){
        System.out.println("____________________________________________________________");
        if(items[index]!=null && index<100) {
            items[index].markAsDone();
            System.out.println("Nice! I've marked this task as done: ");
            System.out.println(items[index].toString());
        } else {
            System.out.println("invalid index, try again");
        }
        System.out.println("____________________________________________________________");
    }

    public void addItem(String item){
        Task newTask = new Task(item.trim());
        items[size] = newTask;
        size++;
        itemAddedMessage(newTask);
    }

    public void addDeadline(String input){
        String[] deadlineInputs = input.split("/by",2);
        Deadline newDeadline= new Deadline(deadlineInputs[0].trim(),deadlineInputs[1].trim());
        items[size] = newDeadline;
        size++;
        itemAddedMessage(newDeadline);
    }
    public void addEvent(String input){
        String[] eventInputs = input.split("/at",2);
        Event newEvent= new Event(eventInputs[0].trim(),eventInputs[1].trim());
        items[size] = newEvent;
        size++;
        itemAddedMessage(newEvent);
    }
    private void itemAddedMessage(Task item){
        System.out.println("____________________________________________________________\n" +
                "Got it. I've added this task: \n" +
                item.toString());
        if(size>1) {
            System.out.println("Now you have " + size + " tasks in the list.");
        } else{
            System.out.println("Now you have " + size + " task in the list.");
        }
        System.out.println("____________________________________________________________");

    }
}
