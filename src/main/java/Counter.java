import java.util.HashMap;
import java.util.Scanner;


public class Counter {

    private final int countPerson;
    private final HashMap<String, Double> goods = new HashMap<>();

    Counter(int countPerson) {
        this.countPerson = countPerson;
    }

    public void askUser() {

        final String regex = "'.*?' \\d+.\\d{2}";

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите товар в формате \"'рубли.копейки' [10.45, 11.40]\"");

        // Получение ввода, парсинг
        String input = sc.nextLine();
        // Валидность ввода
        if (input.matches(regex)) {

            String[] inputArray = input.split(" ");

            // добавляем продукт
            goods.put(inputArray[0], Double.parseDouble(inputArray[1]));

            // Спросить о продолжении сессии
            if (endSession(sc)) {
                System.out.println("Сессия закончена. Спасибо!");
                return;
            }

            // Снова спрашиваем про товар (Рекурсия)
            askUser();

        } else {
            // Не соответсвует маске
            System.out.println("Введенный текст не соответсвует маске.");
            // И опять спрашиваем (Рекурсия)
            askUser();
        }

    }

    private boolean endSession(Scanner sc) {

        if (sc.next().equalsIgnoreCase("ЗАВЕРШИТЬ")){
            // вывести результаты
            System.out.println("Итоги расчета:");

            goods.forEach((key,value)-> System.out.println("*** Товар - " + key + " | Стоимость " + value));

            double total = goods.values().stream().mapToDouble(Double::doubleValue).sum();

            System.out.println("Всего потрачено: " + total);

            double fromOnePerson = total / countPerson;

            System.out.println("С человека - " + fromOnePerson + " " + GetRubleAddition((int)fromOnePerson));

            System.out.println("Спасибо за использование. И пока)))");

            return true;

        }

        return false;

    }

    private String GetRubleAddition(int num)
    {
        int preLastDigit = num % 100 / 10;
        if (preLastDigit == 1)
        {
            return "рублей";
        }

        switch (num % 10)
        {
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
