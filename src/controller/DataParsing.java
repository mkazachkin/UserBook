package controller;

import model.UserData;
import model.UserSex;
import java.time.Year;

public class DataParsing implements DataParsingI{
    @Override
    public UserData stringToUser(String userString) throws UserFormatException {
        String birthDate;
        Integer phoneNumber;
        UserSex sex;
        if (userString.length() == 0) { throw new UserFormatException("Empty string"); }
        String [] userData = userString.replaceAll("\s+", " ")
                .trim().split(" ");
        if (userData.length > 6) { throw new UserFormatException("Too many entries"); }
        if (userData.length < 6) { throw new UserFormatException("Not enough entries"); }
        if (!checkDate(userData[3])) { throw new UserFormatException("Wrong birthdate format"); }
        if ((!userData[5].equals("m")) && (!userData[5].equals("f"))) {
            throw new UserFormatException("Wrong sex format");
        }
        userData[4] = userData[4].replaceAll("\\+", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll("-", "");;
        try { Long.parseLong(userData[4]); }
        catch (Exception e) {
            throw new UserFormatException("Wrong phone format");
        }
        return new UserData(
                userData[0],
                userData[1],
                userData[2],
                userData[3],
                Long.parseLong(userData[4]),
                userData[5].charAt(0));
    }

    private boolean checkDate(String userDate) {
        String[] dateNums = userDate.split("\\.");
        int[] limits = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (dateNums.length != 3) return false;
        try {
            int date = Integer.parseInt(dateNums[0]);
            int month = Integer.parseInt(dateNums[1]) - 1;
            int year = Integer.parseInt(dateNums[2]);
            if ((date > limits[month]) || (date < 1)) {
                return false;
            }
            if ((year > Year.now().getValue()) || (year < 1900)) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
