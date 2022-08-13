import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int countPerson = 0;

        System.out.println("Добрый день!");
        Scanner sc = new Scanner(System.in);
           
        while (true){

            System.out.println("Сколько вас?");

            try {

                countPerson = sc.nextInt();

                if (countPerson == 1) {

                    System.out.println("Для одного человека в приложении нет необходимости");

                } else if (countPerson < 1) {

                    System.out.println("Ошибочное значение. Повторите ввод");

                } else {

                    break;

                }

            } catch (Exception e){

                System.out.println("Введено неправильное значение повторите ввод");
                
            }

        }

        // Пользователь ввел корректное количество. Приступаем к расчетам
        Counter counter = new Counter(countPerson);
        counter.askUser();

    }


}
