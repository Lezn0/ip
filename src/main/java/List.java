public class List {

    private String[] items;
    private int size;

    List(){
        items = new String[100];
        size = 0;
    }

    public void addItem(String item){
        items[size] = (size+1) + "." + item;
        size++;
    }

    public String[] getItems(){
        return items;
    }
}
