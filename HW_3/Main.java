package HW_3;

public class Main {
  public static void main(String[] args) {
    LinkedList list= new LinkedList();
    list.add(4);
    list.add(5);
    list.add(2);
    list.add(1);
    list.add(3);

    list.print();

    list.revert();
    list.print();

  }
}
