// Связный список
// Связный список – базовая структура данных, состоящая из узлов, где каждый узел
// содержит одну или две ссылки, который ссылаются на следующий или на
// следующий и предыдущий узел соответственно.

// Структурно, связные списки бывают однонаправленными – когда каждый узел
// содержит информацию только о следующем элементе цепочки, и
// двунаправленными – когда каждый узел ссылается на следующий и предыдущий
// узлы. 
// Первый узел связного списка принято называть head, т.к. именно с него
// начинается обход. Последний элемент принято называть tail, благодаря которому
// можно обойти связный список не только от начала, но и в обратной
// последовательности (для двунаправленного) или просто добавить новый узел в
// конец цепочки.

// Преимущества связного списка
// ● Массовые вставки и удаления в конец\начало
// списка
// ● Массовые вставки и удаления в середину
// списка, если операция поиска выполняется
// единожды
// ● Динамическая расширяемость 

public class Lec_3 {
  private Node head;
  private Node tail;

  public Node findNode(int value) { // сложность  O(n)
    Node currentNode = head;
    while (currentNode.nextNode != null) {
      currentNode = currentNode.nextNode;
      if (currentNode.value == value) {
        return currentNode;
      }
    }
    return null;
  }

  public void addLast(int value) {
    Node node = new Node();
    node.value = value;
    if (head == null) {
      head = node;
      tail = node;
    } else {
      tail.nextNode = node;
      node.previousNode = tail;
      tail = node;
    }
  }

  public void add(int value, Node node) {
    Node next = node.nextNode;
    Node newNode = new Node();
    newNode.value = value;
    node.nextNode = newNode;
    newNode.previousNode = node;
    if (next == null) {
      tail = newNode;
    } else {
      next.previousNode = newNode;
      newNode.nextNode = next;
    }
  }

  public void delete(Node node) {
    Node  previous = node.previousNode;
    Node next = node.nextNode;
    if (previous == null) {
      next.previousNode = null;
      head = next;
    } else {
      if (next == null) {
        previous.nextNode = null;
        tail = previous;
      } else {
        previous.nextNode = next;
        next.previousNode = previous;
      }
    }
  }

  public void revert(){
    Node currentNode = head;
    while (currentNode != null) {
      Node next = currentNode.nextNode;
      Node  previous = currentNode.previousNode;
      currentNode.nextNode = previous;
      currentNode.previousNode = next;
      if (previous == null) {
        tail = currentNode;
      }
      if (next == null) {
        head = currentNode;
      }
      currentNode = next;
    }
  }

  class Node { // Node - классическое название для подобных структур
    private int value;
    private Node nextNode;
    private Node previousNode;
  }
}
