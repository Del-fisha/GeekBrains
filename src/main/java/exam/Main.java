package exam;

public class Main {
    public static void main(String[] args) {
        String user = new UserInput().userData;
        try {
            CheckValid.isValid(user);
            WriteData.writeData(user);
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }
}