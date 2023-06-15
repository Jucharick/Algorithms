// Структуры данных. Массивы. Алгоритмы массивов


// Структурами данных называют некоторый контейнер с данными, обладающий специфическим внутренним устройством
// (макетом) и логикой хранения. Различные макеты могут быть эффективны для некоторых операций и неэффективны для
// других.

// Массив - это контейнер, хранящий данные идентифицируемые по индексу. К любому элементу массива всегда можно обратиться по его индексу и
// достать или заменить его.
// Особенностью массива является то, что доступ к элементам по индексу осуществляется за константное время, т.е. имеет сложность O(1)


public class Lec_2 {
  public static void main(String[] args) {
    int[] array = new int[] {1,4,7,9,4,2,16,5,7,9,3};
    bubbleSort(array);

    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }

    System.out.println();

    int[] array2 = new int[] {11,34,5,1,4,7,9,4,2,16,5,7,9,3};
    directSort(array2);

    for (int i = 0; i < array2.length; i++) {
      System.out.print(array2[i] + " ");
    }
  }
  

  // сортировка пузырьком (не самая оптимальная, сложность O(n^2) высокая)
  public static void bubbleSort(int[] array) { // O(n) - если уже отсортирован, O(n^2) - если самый маленький элемент в конце массива (пройдемся по нему n раз)
    boolean finishSort;
    do {
      finishSort = true;
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i] > array[i+1]) {
          int temp = array[i];
          array[i] = array[i+1];
          array[i+1] = temp;
          finishSort = false;
        }
      }
    } while (!finishSort);
  }


  // Сортировка выбором (сложность поиска O(n^2), но технически кол-во операций будет меньше, чем у пузырьковой сортировки)
  public static void directSort(int[] array) {
     for (int i = 0; i < array.length; i++) {
      int minPosition = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minPosition]) {
          minPosition = j;
        }
      }
      if (minPosition != i) {
        int temp = array[i];
        array[i] = array[minPosition];
        array[minPosition] = temp;
      }
     }
  }
}
