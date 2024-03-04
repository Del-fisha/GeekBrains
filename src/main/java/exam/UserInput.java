package exam;

import java.util.Scanner;

public class UserInput {
    public String userData;
    public UserInput() {
        System.out.println("Введите следующие данные, разделенные пробелом:");
        System.out.println("Фамилия Имя Отчество дата _ рождения номер _ телефона пол");
        try (Scanner scanner = new Scanner(System.in)) {
            this.userData = scanner.nextLine();
        }
    }
}
