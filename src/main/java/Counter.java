import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Counter {

    private int countPerson = 0;
    private HashMap<String, Double> goods = new HashMap<String, Double>();

    Counter(int countPerson) {
        this.countPerson = countPerson;
    }

    public void askUser() {

        final String regex = "'.*?' [0-9]{2}.[0-9]{2}";

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите товар в формате \"'рубли.копейки' [10.45, 11.40]\"");

        // Получение ввода, парсинг
        String input = sc.nextLine();

        if (input.matches(regex)) {

            String[] inputArray = input.split(" ");

            // Попытка добавления товара
            if (addGoods(inputArray)) {

                // Спросить о продолжении сессии
                if (endSession(sc)) {
                    System.out.println("Сессия закончена. Спасибо!");
                    return;
                }

                // Снова спрашиваем про товар (Рекурсия)
                askUser();

            }

        }else {
            // Не соответсвует маске
            System.out.println("Введенный текст не соответсвует маске.");
            askUser();
        }

    }

    private boolean endSession(Scanner sc) {

        return sc.next().toUpperCase() == "ЗАВЕРШИТЬ";

    }

    private boolean addGoods(String[] input) {

        boolean success = true;

        goods.put(input[0], new Double(input[0]));

        return success;

    }

}