// Для описания сложности существует общепринятая нотация - О(f(n)), где n - размер входных данных.

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Lec_1 {

  public static void main(String[] args) {
    List<Integer> availableDivider = findAvailableDivider(13);
    for (Integer integer : availableDivider) {
      System.out.println(integer);
    }

    List<Integer> simpleNumbers = findSimpleNumbers(13);
    for (Integer integer : simpleNumbers) {
      System.out.println(integer);
    }

    double resultDice = findSum(9);
    System.out.println(resultDice);

    AtomicInteger counter = new AtomicInteger(0);
    int fib = fib(10, counter);
    System.out.println("Fibonacci number " + fib);
    System.out.println("counter_Fibonacci " + counter.get());
  }


  // Линейная зависимость - характеризуется симметричным ростом количества шагов относительно увеличения
  // объема входных данных.
  // алгоритм перебора массива циклом for имеет сложность O(n)
  public static List<Integer> findAvailableDivider(int number) {
    List<Integer> result = new ArrayList<>();

    int counter = 0; // для подсчета операций

    for (int i = 1; i <= number; i++) {
      counter ++;
      if (number % i == 0) {
        result.add(i);
      }
    }

    System.out.println("Counter availableDivider: " + counter); // O(n) - рост операций линейный
    return result;
  }


  // Квадратичная зависимость - характеризуется резким ростом сложности относительно роста 
  // размера входных данных
  // использование вложенного цикл for уже будет имеет сложность O(n^2), например, при n = 3 цикл
  // сделает 9 итераций, а при n = 4 уже 16 и т.д.
  public static List<Integer> findSimpleNumbers(int maxNumber) { // простые числа - делятся без остатка только на 1 и на самих себя
    List<Integer> result = new ArrayList<>();

    int counter = 0; // для подсчета операций

    for (int i = 1; i <= maxNumber; i++) {
      boolean simple = true;
      for (int j = 2; j < i; j++) { //  не проверяем деление на 1 и само на себя
        counter ++;
        if (i % j == 0) {
          simple = false;
        }
      }
      if (simple){
        result.add(i);
      }
    }

    System.out.println("Counter simple_numbers: " + counter); // O(n^2) - рост операций не реальный квадратичный, при maxNumber = 13 операций 66
    return result;
  }


  // Экспоненциальная зависимость
  public static double findSum(int sum) { // вероятность выпадения суммы при бросании трех игральных кубиков
    int successResult = 0;
    int counter = 0; 

    for (int i = 1; i <= 6; i++) {
      for (int j = 1; j <= 6; j++){
        for (int k = 1; k <= 6; k++){
          counter ++;
          if (i + j + k == sum){
            successResult++;
          }
        }
      }
    }
  
    System.out.println("Counter three_dice: " + counter);
    return ((double) successResult) / ((double) counter);
  }


  // Числа фибоначи - сложность алгоритма 2^(n-1)
  public static int fib(int position, AtomicInteger counter) {
    counter.incrementAndGet();

    if (position == 1) {
      return 0;
    }

    if (position == 2 || position == 3) {
      return 1;
    }

    return fib(position - 1, counter) + fib(position - 2, counter);
  }

}
/*

# Правила объединения сложности:

● Вызов нескольких методов на каждом шаге: O(2n) == O(n)
Обход половины размерности массива: O(n/2) == O(n)

● Вызов нескольких методов вне цикла:
O(2+n) == O(n)

method1() - имеет сложность O(n^3)
method2() - имеет сложность O(n^2)

● Если внутри method1() будет вызываться method2(),
то их сложности перемножаются: O(n^3) * O(n^2) == O(n^5)

● Если методы будут вызываться последовательно, то их сложности складываются, т.е. берется
максимальная из них: O(n^3) + O(n^2) == O(n^3)


# Какая бывает сложность алгоритмов:

● O(1) - константная. Не зависит от объема данных. Например - поиск по хэш-таблице

● O(log n) - логарифмическая. Увеличение размера почти не сказывается на количестве итераций.
Например - бинарный поиск, поиск по сбалансированному дереву

● O(n) - линейная. Увеличение сложности эквивалентно увеличению размера. Например - поиск по
неотсортированному массиву

● O(n * log n) - увеличение размера заметно сказывается на сложности. Например - быстрая
сортировка

● O(n^2) - квадратичная. Увеличение размера очень сильно сказывается на сложности. Например -
пузырьковая сортировка

● O(2^n) - экспоненциальная. С увеличением размера на 1, сложность возрастает вдвое
 
 */


