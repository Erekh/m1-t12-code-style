import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, int d) {
        double pay = a * Math.pow((1 + 0.06 / 12), 12 * d);
        return round(pay);
    }

    double calculateSimplePercent(double doubleAmount, int depositPeriod) {
        return round(doubleAmount + doubleAmount * 0.06 * depositPeriod);
    }

    double round(double value) {
       double scale = Math.pow(10, 2);
       return Math.round(value * scale) / scale;
    }

    void printMenu() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Введите сумму вклада в рублях:");
      int amount = scanner.nextInt();
      System.out.println("Введите срок вклада в годах:");
      int period = scanner.nextInt();
      System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
      int deposit = scanner.nextInt();
      double out = 0;
      if (deposit == 1) {
          out = calculateSimplePercent(amount, period);
      } else if (deposit == 2) {
          out = calculateComplexPercent(amount, period);
      }
      System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

public static void main(String[] args){
        new DepositCalculator().printMenu();
}




}
