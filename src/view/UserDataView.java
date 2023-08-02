package view;

import controller.DataParsing;
import controller.DataSaving;
import controller.UserFormatException;
import model.UserData;

import java.util.Arrays;
import java.util.Scanner;

public class UserDataView {
    private UserData userData;
    public UserDataView () {
        this.userData = new UserData();
    }
    private String userInput (String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }

    public void run () {
        boolean flag = false;
        while (!flag) {
            DataParsing dataParser = new DataParsing();
            try {
                this.userData = dataParser.stringToUser(userInput("""
                        Введите данные пользователя. Данные вводятся одной строкой без запятых:
                            Имя Отчество Фамилия, дата рождения, номер телефона, пол.
                        Введите пустую строку, если хотите выйти из приложения."""));
                flag = true;
            } catch (UserFormatException e) {
                if (e.getMessage().equals("Empty string")) {
                    System.out.println("Введена пустая строка.");
                    flag = true;
                } else {
                    System.out.println("Введены некорректные данные:" + e.getMessage()
                            + "\nПопробуйте еще раз.");
                }
            }
        }
        if (this.userData.notNull()) {
            DataSaving dataSaver = new DataSaving();
            try {
                System.out.println("Данные сохранены в файл " +
                        dataSaver.saveUserData(this.userData));
            } catch (Exception e) {
                Exception exception = e;
                flag = false;
                while (!flag) {
                    System.out.println("При сохранении файла возникла ошибка: " + exception.getMessage());
                    System.out.println(Arrays.toString(exception.getStackTrace()));
                    String newPath =
                            userInput("Введите новый путь для сохранения файла или "
                                    + "оставьте поле ввода пустым, чтобы выйти");
                    if (newPath.length() > 0) {
                        try {
                            System.out.println("Данные сохранены в файл " +
                                    dataSaver.saveUserData(userData, newPath));
                            flag = true;
                        } catch (Exception ex) {
                            exception = ex;
                        }
                    } else {
                        System.out.println("Данные не сохранены");
                        flag = true; }
                }
            }
        } else {
            System.out.println("Данные отсутствуют. Сохранять нечего.");
        }
    }
}
