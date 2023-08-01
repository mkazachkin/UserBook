package controller;

import model.UserData;

public interface DataSavingI {
    void saveUserData (UserData userData, String filesPath);
}
