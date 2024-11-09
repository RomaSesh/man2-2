import java.util.Random;
import java.util.Scanner;

public class man {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Man man = null; // Экземпляр класса Man, изначально равен null
        boolean infinity = true; // Переменная для управления циклом

        while (infinity) {
            System.out.print("Введите команду: ");
            String userCommand = scanner.nextLine();

            switch (userCommand) {
                case "exit": {
                    infinity = false; // Завершение цикла
                    break;
                }
                case "help": {
                    System.out.println("Список команд:");
                    System.out.println("---");
                    System.out.println("create_man : команда создает человека (экземпляр класса Man)");
                    System.out.println("kill_man : команда убивает человека");
                    System.out.println("talk : команда заставляет человека говорить (если создан экземпляр класса)");
                    System.out.println("go : команда заставляет человека идти (если создан экземпляр класса)");
                    System.out.println("---");
                    break;
                }
                case "create_man": {
                    if (man != null) { // Проверяем, создан ли уже человек
                        man.kill(); // Убиваем его, если он существует
                    }
                    System.out.print("Пожалуйста, введите имя создаваемого человека: "); // Запрос имени
                    String userName = scanner.nextLine(); // Получаем имя
                    man = new Man(userName); // Создаем нового человека
                    System.out.println("Человек успешно создан: " + man.getName()); // Сообщаем о создании
                    break;
                }
                case "kill_man": {
                    if (man != null) {
                        man.kill(); // Убиваем человека
                    } else {
                        System.out.println("Сначала создайте человека с помощью команды create_man.");
                    }
                    break;
                }
                case "talk": {
                    if (man != null) {
                        man.talk(); // Человек говорит
                    } else {
                        System.out.println("Сначала создайте человека с помощью команды create_man.");
                    }
                    break;
                }
                case "go": {
                    if (man != null) {
                        man.go(); // Человек идет
                    } else {
                        System.out.println("Сначала создайте человека с помощью команды create_man.");
                    }
                    break;
                }
                default: {
                    System.out.println("Ваша команда не определена, пожалуйста, повторите снова.");
                    System.out.println("Для вывода списка команд введите команду help.");
                    System.out.println("Для завершения программы введите команду exit.");
                    break;
                }
            }
        }

        scanner.close();
        System.out.println("Программа завершена.");
    }
}

class Man {
    private String name; // строка, содержащая имя
    private int age; // целое число, содержащая возраст
    private int health; // целое число, отражающее уровень здоровья
    private boolean isLife; // булево, означающее жив ли данный человек
    private static final Random rnd = new Random(); // Создаем экземпляр Random
    // Конструктор класса
    public Man(String _name) {
        this.name = _name;
        this.isLife = true;
        // Генерируем возраст от 15 до 50
        this.age = rnd.nextInt(36) + 15; // Генерация возраста от 15 до 50
        // Генерируем здоровье от 10 до 100%
        this.health = rnd.nextInt(91) + 10; // Генерация здоровья от 10 до 100
    }

    // Метод для получения имени
    public String getName() {
        return name;
    }

    // Метод для получения возраста
    public int getAge() {
        return age;
    }

    // Метод для получения уровня здоровья
    public int getHealth() {
        return health;
    }

    // Метод, возвращающий показатель - жив ли данный человек
    public boolean isAlive() {
        return isLife;
    }

    // Метод "говорить"
    public void talk() {
        System.out.println(name + " говорит: Привет!");
    }

    // Метод "идти"
    public void go() {
        // Если объект жив
        if (isLife) {
            // Если показатель здоровья больше 40
            if (health > 40) {
                // Генерируем строку текста
                String outString = name + " мирно прогуливается по городу.";
                // Выводим в консоль
                System.out.println(outString);
            } else {
                // Генерируем строку текста
                String outString = name + " болен и не может гулять по городу.";
                // Выводим в консоль
                System.out.println(outString);
            }
        } else {
            // Генерируем строку текста
            String outString = name + " не может идти, он умер.";
            // Выводим в консоль
            System.out.println(outString);
        }
    }

    // Метод "убить"
    public void kill() {
        // Устанавливаем значение isLife в false
        isLife = false;
        System.out.println(name + " теперь мертв.");
    }
}

