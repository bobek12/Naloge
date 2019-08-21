public class PhoneNumber {
    private String phoneNumber;
    private int type;

    public PhoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
    }

    /* Nastavimo objekt v primeru, da je vpisan niz pravilen */
    private void setPhoneNumber(String phoneNumber) {
        boolean validate = validatePhoneNumber(phoneNumber);

        if (validate) {
            this.phoneNumber = phoneNumber;
            this.type = checkPhoneNumberTypeByRegex();
        } else
            System.out.println("Neveljavna številka");
    }
    /* Preveri dolžino niza in veljavnost */
    private boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^386[0-9]{8}$");
    }
    /* Preveri Telefonsko številko na podalgi primerjave z regex izrazi */
    public int checkPhoneNumberTypeByRegex() {
        String phoneNumberStd = this.phoneNumber.substring(3, 5);
        int typeOfPhoneNumber;

        /*Telefonska številka ali mobilna številka */
        if (phoneNumberStd.matches("^([347][01])|([4][39])|([5][1])|([6][4598])$"))
            typeOfPhoneNumber = 1;
        else
            typeOfPhoneNumber = 2;

        return typeOfPhoneNumber;
    }
    /* Kliče helper v Database za import telefonske številke v DB */
    public void addPhoneNumberToDb() {
        Database.insertPhoneNumber(getPhoneNumber(), getType());
    }
    /* Kliče helper v Database za pridobitev vse telefonskih številk iz DB */
    public static void getAllPhoneNumbers() {
        Database.selectAllPhoneNumbers();
    }
    /* Kliče helper v Database za pridobitev telefonskih številk glede na vpisano telefonsko številko iz DB */
    public void getPhoneNumberByNumber(String phoneNumber){
            Database.selectPhoneNumber(phoneNumber);
    }
    /* Kliče helper v Database za brisanje telefonskih številk glede na vpisano telefonsko številko iz DB */
    public void deletePhoneNumberByNumber(String phoneNumber) {
            Database.deletePhoneNumber(phoneNumber);
    }
    /* Kliče helper v Database za brisanje vshe telefonskih številk iz DB */
    public static void deleteAllPhoneNumbers() {
        Database.deleteAllNumbers();
    }
    /* GETER --> za pridobitev vpisanega števila */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /* GETER --> za pridobitev tipa števila */
    public int getType() {
        return type;
    }
}