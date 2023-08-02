package model;

public class UserData extends UserDataA{
    public UserData() {
        super();
    }
    public UserData (String firstName, String midName, String lastName,
                     String birthDate, Long phoneNumber, UserSex sex) {
        super (firstName, midName, lastName, birthDate, phoneNumber, sex);
    }
    public UserData (String firstName, String midName, String lastName,
                     String birthDate, Long phoneNumber, Character sexChar) {
        super (firstName, midName, lastName, birthDate, phoneNumber, UserSex.NO_DATA);
        if (sexChar.equals('f')) { super.setSex(UserSex.FEMALE); }
        if (sexChar.equals('m')) { super.setSex(UserSex.MALE); }
    }

    @Override
    public String toString () {
        StringBuilder result = new StringBuilder();
        result.append(super.getFirstName()).append(" ");
        result.append(super.getMidName()).append(" ");
        result.append(super.getLastName()).append(" ");
        result.append(super.getBirthDate()).append(" ");
        result.append(super.getPhoneNumber()).append(" ");
        if (super.getSex().equals(UserSex.MALE)) { result.append("m"); }
        if (super.getSex().equals(UserSex.FEMALE)) { result.append("f"); }
        return result.toString();
    }
    public boolean notNull () {
        return super.getFirstName() != null && super.getMidName() != null
                && super.getLastName() != null && super.getBirthDate() != null
                && super.getPhoneNumber() != null && super.getSex() != UserSex.NO_DATA;
    }
}
