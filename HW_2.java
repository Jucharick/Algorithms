import java.util.Random;
import java.util.Arrays;

public class HW_2 {
    public static void main(String[] args) {
    int[] array = new int[25];
    for (int i = 0; i < array.length; i++)
      array[i] = new Random().nextInt(50);
    
    System.out.println(Arrays.toString(array));

    heapSort(array);
    System.out.println(Arrays.toString(array));
  }




  // Сортировка кучей (пирамидальная)
  public static void heapSort(int[] array) {
    // построение кучи (перегруппируем массив)
    for (int i = array.length / 2 - 1; i >= 0; i--) {
      heapify(array, array.length, i);
    }

    // один за другим извлекаем элементы из кучи
    for (int i = array.length - 1; i > 0; i--) {
      // премещаем текущий корень в конец
      int temp = array[0];
      array[0] = array[i];
      array[i] = temp;

      // вызываем процедуру heapify на уменьшенной куче
      heapify(array, i, 0);
    }
  }

  private static void heapify(int[] array, int heapSize, int rootIndex) {
    int largest = rootIndex; // инициализируем самый большой элемент как корень
    int leftChild = 2 * rootIndex + 1; // левый  2*rootIndex + 1
    int rightChild = 2 * rootIndex + 2; // правый  2*rootIndex + 2

    // если левый дочерний элемент больше корня
    if (leftChild < heapSize && array[leftChild] > array[largest]) {
      largest = leftChild;
    }

    // если правый дочерний элемент больше чем самый большой элемент на данный момент
    if (rightChild < heapSize && array[rightChild] > array[largest]) {
      largest = rightChild;
    }

    // если самый большой элемнт не корень
    if (largest != rootIndex) {
      int temp = array[rootIndex];
      array[rootIndex] = array[largest];
      array[largest] = temp;
      
      // рекурсивно преобразуем в двоичную кучу затронутое поддерево
      heapify(array, heapSize, largest);
    }
  }
}
