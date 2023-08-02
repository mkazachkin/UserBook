package controller;

import model.UserData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataSaving implements DataSavingI{
    @Override
    public String saveUserData (UserData userData, String filesPath) throws Exception {
        if (filesPath.charAt(filesPath.length() - 1) != File.separator.charAt(0)) {
            filesPath += File.separator;
        }
        String fp = filesPath + userData.getLastName().toLowerCase() + ".txt";
        try {
            FileWriter writer = new FileWriter (fp, true);
            writer.write(userData.toString());
            writer.append("\n");
            writer.flush();
            return fp;
        } catch (IOException e) {
            throw (new IOException("File output failed. Path: " + fp));
        } catch ( Exception e ) {
            throw (new Exception("Unknown error. Path: " + fp));
        }
    }
    public String  saveUserData(UserData userData) throws Exception {
        return saveUserData (userData, System.getProperty("user.home"));
    }
}
