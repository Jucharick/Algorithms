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

    System.out.println();

    int[] array3 = new int[] {11,34,5,2,16,5,7,9,3};
    insterSort(array3);
    for (int i = 0; i < array3.length; i++) {
      System.out.print(array3[i] + " ");
    }

    System.out.println();

    int findValue = 5;
    System.out.println("Искомый индекс: " + findIndex(findValue, array));
    System.out.println("Искомый индекс: " + binarySearch(findValue, array, 0, array.length-1));

    int[] array4 = new int[] {35,1,22,11,34,5,2,16,5,7,9,3};
    quickSort(array4, 0, array4.length-1);
    for (int i = 0; i < array4.length; i++) {
      System.out.print(array4[i] + " ");
    }

    System.out.println();

    int[] array5 = new int[] {35,1,5,2,16,5,7,9,3};
    quickSort(array5, 0, array5.length-1);
    for (int i = 0; i < array5.length; i++) {
      System.out.print(array5[i] + " ");
    }
  }
  

  // Сортировка пузырьком (не самая оптимальная, сложность O(n^2) высокая)
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


  // Сортировка выбором (сложность O(n^2), но технически кол-во операций будет меньше, чем у пузырьковой сортировки)
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


  // Сортировка вставками (сложность O(n^2), но технически кол-во операций будет меньше, чем у пузырьковой сортировки, но больше, чем у сортировки вставками)
  public static void insterSort(int[] array) {
     for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array [i]) {
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
     }
  }


  // Алгоритмы поиска. Простой перебор (сложность поиска O(n))
  public static int findIndex(int value, int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == value) {
        return i;
      }
    }
    return -1;
  }


  //   Бинарный поиск - тип поискового алгоритма, который последовательно
  // делит пополам заранее ОТСОРТИРОВАННЫЙ массив данных, чтобы обнаружить
  // нужный элемент. Другие его названия — двоичный поиск, метод половинного
  // деления, дихотомия. Принцип работы алгоритма бинарного поиска. Основная
  // последовательность действий алгоритма выглядит так: Сортируем массив
  // данных. Делим его пополам и находим середину.

  // Бинарный поиск (сложность поиска O(log n))
  public static int binarySearch(int value, int[] array, int min, int max) {
    int midpoint;
    if (min > max) {
      return -1;
    } else {
      midpoint = (max - min)/2 + min;
    }
    if (array[midpoint] < value) {
      return binarySearch(value, array, midpoint + 1, max);
    } else {
      if (array[midpoint] > value) {
      return binarySearch(value, array, min, midpoint - 1);
      } else {
        return midpoint;
      }
    }
  }


  // Продвинутые алгоритмы сортировки


  // Суть быстрой сортировки – разделить массив на 2
  // части таким образом, чтобы справа все числа были больше, чем слева, при этом их
  // порядок относительно друг друга не важен. И далее этот же подход будет применяться 
  // для каждой из получившихся частей, равно как предусматривает принцип «разделяй и властвуй». 
  // При этом, в отличии от бинарного поиска, количество операций в момент разделения не
  // константное, а линейное – необходимо сравнить все элементы правой и левой
  // части с неким эталоном и при необходимо – поменять их местами. В данном
  // алгоритме такой элемент называется пивотом.
  // Пивот - от английского поворот (pivot).

  // Быстрая сортировка (quicksort) - сложность O(n log n), но если мы пытаемся отсортировать уже отсортированный массив пивотом 
  // будет элемент с индексом 0, то сложность сортировки будет O(n^2), т.к. нам придется перебрать весь массив
   public static void quickSort(int[] array, int startPos, int endPos) {
    int leftPos = startPos;
    int rightPos = endPos;
    int pivot = array[(startPos + endPos)/2];
    do {
      while (array[leftPos] < pivot) {
        leftPos++;
      }
      while (array[rightPos] > pivot) {
        rightPos--;
      }
      if (leftPos <=rightPos) {
        if (leftPos < rightPos) {
          int temp = array[leftPos];
          array[leftPos] = array[rightPos];
          array[rightPos] = temp;
        }
        leftPos++;
        rightPos--;
      }
      
    } while (leftPos <= rightPos);

    if (leftPos < endPos) {
      quickSort(array, leftPos, endPos);
    }
    if (startPos < rightPos) {
      quickSort(array, startPos, rightPos);
    }
  }


  // Особенность данной сортировки в использовании дополнительной структуры
  // данных называемой бинарной кучей (пирамидой).
  // Бинарная куча представляет из себя древовидную структуру, когда у каждого
  // объекта может быть до 2 детей. При этом строится из массива она предельно
  // просто – первый элемент массива является корнем, 2 и 3 его детьми, 4 и 5 детьми
  // элемента 2 и т.д. пока в массиве остаются элементы.
  // если принять элемент с индексом i за родителя, то индексы его дочерних
  // элементов будут 2 * i + 1 и 2 * i + 2

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

  public static void heapify(int[] array, int heapSize, int rootIndex) {
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
