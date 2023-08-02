package controller;

import model.UserData;

import java.io.IOException;

public interface DataSavingI {
    String saveUserData (UserData userData, String filesPath) throws Exception;
}
