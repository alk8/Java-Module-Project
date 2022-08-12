import java.util.HashMap;
import java.util.Scanner;
public class Counter {

    private int countPerson = 0;
    private HashMap<String,Double> goods = new HashMap<String,Double>();

    Counter(int countPerson){
        this.countPerson = countPerson;
    }

    public void askUser(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите товар в формате \"'рубли.копейки' [10.45, 11.40]\"");

        String input = sc.next();

        // Проверить формат ввода

        // Парсинг строки

        // Попытка добавления товара

        // Спросить о продолжении сессии
        if (endSession(sc)){
            System.out.println("Сессия закончена. Спасибо!");
            return;
        }

        // Снова спрашиваем про товар (Рекурсия)
        askUser();

    }

    private boolean endSession(Scanner sc){

        return sc.next().toUpperCase() == "ЗАВЕРШИТЬ";

    }

    private boolean addGoods(){

        boolean success = true;


    }

}