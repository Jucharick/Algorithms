import java.util.ArrayList;
import java.util.List;

public class Lec_1 {

  public static void main(String[] args) {
    List<Integer> availableDivider = findAvailableDivider(12);
    for (Integer integer : availableDivider) {
      System.out.println(integer);
    }

    List<Integer> simpleNumbers = findSimpleNumbers(100);
    for (Integer integer : simpleNumbers) {
      System.out.println(integer);
    }
  }


  // Линейная зависимость - характеризуется симметричным ростом количества шагов относительно увеличения
  // объема входных данных.
  public static List<Integer> findAvailableDivider(int number) {
    List<Integer> result = new ArrayList<>();

    for (int i = 1; i <= number; i++) {
      if (number % i == 0) {
        result.add(i);
      }
    }

    return result;
  }


  // Квадратичная зависимость - характеризуется резким ростом сложности относительно роста 
  // размера входных данных
  public static List<Integer> findSimpleNumbers(int maxNumber) { // простые числа - делятся без остатка только на 1 и на самих себя
    List<Integer> result = new ArrayList<>();

    for (int i = 1; i <= maxNumber; i++) {
      boolean simple = true;
      for (int j = 2; j < i; j++) { //  не проверяем деление на 1 и само на себя
        if (i % j == 0) {
          simple = false;
        }
      }
      if (simple){
        result.add(i);
      }
    }

    return result;
  }

}

