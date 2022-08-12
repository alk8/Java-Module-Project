import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;


public class Counter {

    private final int countPerson;
    private final HashMap<String, Double> goods = new HashMap<>();

    Counter(int countPerson) {
        this.countPerson = countPerson;
    }

    public void askUser() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите товар");

        // Получение товара
        String product = sc.next();

        if (endSession(product)) {
            System.out.println("Сессия закончена. Спасибо!");
            return;
        }

        System.out.println("Введите стоимость");

        // Стоимость
        String cost = addCost(sc);

        if (endSession(cost)) {
            System.out.println("Сессия закончена. Спасибо!");
            return;
        }

        // добавляем продукт
        goods.put(product, Double.parseDouble(cost));

        System.out.println("Добавлено успешно!");

        // Снова спрашиваем про товар (Рекурсия)
        askUser();

    }

    private String addCost(Scanner sc) {

        String cost = sc.next();

        if (!cost.matches("\\d+.\\d{2}")) {

            System.out.println("Значение не соответсвует маске XX.XX Введите стоимость заново");
            // (Рекурсия)
            cost = addCost(sc);
        }

        return cost;
    }

    private boolean endSession(String str) {

        if (str.equalsIgnoreCase("ЗАВЕРШИТЬ")) {

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            // вывести результаты
            System.out.println("Добавленные товары:");

            goods.forEach((key, value) ->
                    System.out.println("*** " + key + " | Стоимость " + value + " " + GetRubleAddition(value)));

            double total = goods.values().stream().mapToDouble(Double::doubleValue).sum();

            System.out.println("Всего потрачено: " + decimalFormat.format(total) + " " + GetRubleAddition(total));

            double fromOnePerson = total / countPerson;

            System.out.println("С человека - " + decimalFormat.format(fromOnePerson) +
                    " " + GetRubleAddition(fromOnePerson));

            return true;

        }

        return false;

    }

    private String GetRubleAddition(Double value) {

        int num = value.intValue();

        int preLastDigit = num % 100 / 10;
        if (preLastDigit == 1) {
            return "рублей";
        }

        switch (num % 10) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }

}
