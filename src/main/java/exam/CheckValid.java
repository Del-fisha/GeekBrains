package exam;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.zip.DataFormatException;

public class CheckValid {
    public static void isValid(String stringData) {
        String[] arrayData = stringData.split(" ");
        try {
            checkLength(arrayData);
            checkBirthdayValid(arrayData[3]);
            checkPhoneNumber(arrayData[4]);
            checkMale(arrayData[5]);
        } catch (DataFormatException | ArrayIndexOutOfBoundsException | NumberFormatException
                 | StringIndexOutOfBoundsException | DatatypeConfigurationException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    private static void checkBirthdayValid(String birthday) throws DataFormatException {
        char[] birthArray = birthday.toCharArray();
        if (birthArray.length != 10) {
            System.out.println("Введён неверный формат даты рождения");
            throw new DataFormatException();
        }
        if (birthArray[2] != '.' || birthArray[5] != '.') {
            System.out.println("Дату необходимо писать через точки");
            throw new DataFormatException();
        }
        for (char character : birthArray) {
            if (!Character.isDigit(character) && character != '.') {
                System.out.println("В дате рождения не должно присутствовать ничего, кроме цифр");
                throw new DataFormatException();
            }
        }
    }

    private static void checkLength(String[] data) throws ArrayIndexOutOfBoundsException {
        if (data.length != 6) {
            System.out.println("Введено недопустимое количество информации");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private static void checkPhoneNumber(String phoneNumber) throws NumberFormatException {
        char[] phoneNumberArray = phoneNumber.toCharArray();

        for (char character : phoneNumberArray) {
            if (!Character.isDigit(character)) {
                System.out.println("Некорректно введён номер телефона");
                throw new NumberFormatException();
            }
        }
    }

    private static void checkMale(String male) throws StringIndexOutOfBoundsException, DatatypeConfigurationException {
        if (male.length() != 1) {
            System.out.println("Некорректно введён пол");
            throw new StringIndexOutOfBoundsException();
        }

        if (!male.equalsIgnoreCase("м") && !male.equalsIgnoreCase("ж")) {
            System.out.println("Пол может быть только М или Ж");
            throw new DatatypeConfigurationException();
        }
    }
}
