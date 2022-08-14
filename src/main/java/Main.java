import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final String regex = "\\d+";
        int countPerson;
        String input;

        System.out.println("Добрый день!");
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Сколько вас?");

            input = sc.next();

            if (input.matches(regex)) {

                countPerson = Integer.parseInt(input);

                if (countPerson == 1) {

                    System.out.println("Для одного человека в приложении нет необходимости");

                } else if (countPerson < 1) {

                    System.out.println("Ошибочное значение. Повторите ввод");

                } else {

                    break;

                }

            } else {

                System.out.println("Введено неправильное значение повторите ввод");

            }

        }

        // Пользователь ввел корректное количество. Приступаем к расчетам
        Counter counter = new Counter(countPerson);
        counter.askUser();

    }


}
