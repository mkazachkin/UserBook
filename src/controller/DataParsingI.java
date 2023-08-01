package controller;

import model.UserData;

public interface DataParsingI {
    UserData stringToUser (String userString) throws UserFormatException;
}
