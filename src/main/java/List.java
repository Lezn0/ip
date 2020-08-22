public class List {

    private Task[] items;
    private int size;

    List(){
        items = new Task[100];
        size = 0;
    }
    public void queryItems(){

        System.out.println("____________________________________________________________\nHere are the tasks in your list: ");
        int count=1;
        for(Task item: items){
            if(item!=null) {
                System.out.println(count + "." + "[" + item.getStatusIcon() + "]" + item.description);
                count++;
            } else break;
        }
        System.out.println("____________________________________________________________\n");

    }

    public void completeTask(int index){

        items[index].markAsDone();
        System.out.println("____________________________________________________________");
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println("[" + items[index].getStatusIcon() + "]" + items[index].description);
        System.out.println("____________________________________________________________\n");

    }
    public void addItem(String item){
        Task newTask = new Task(item);
        items[size] = newTask;
        size++;
    }

    public Task[] getItems(){
        return items;
    }
}
