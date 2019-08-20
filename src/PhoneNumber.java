public class PhoneNumber {
    private String phoneNumber;

    public PhoneNumber (String phoneNumber){
        setPhoneNumber(phoneNumber);
    }

    /* Nastavimo objekt v primeru, da je vpisan niz pravilen */
    private void setPhoneNumber(String phoneNumber) {
        boolean validate = validatePhoneNumber(phoneNumber);

        if(validate)
            this.phoneNumber = phoneNumber;
        else
            System.out.println("Neveljavna številka");
    }

    /* Preveri dolžino niza in veljavnost */
    private boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^386[0-9]{8}$");
    }

    /* Preveri Telefonsko številko na podalgi primerjave z regex izrazi */
    public void checkPhoneNumberTypeByRegex() {
        String phoneNumberStd = this.phoneNumber.substring(3,5);
        String typeOfPhoneNumber;

        /*Telefonska številka ali mobilna številka */
        if(phoneNumberStd.matches("^([347][01])|([4][39])|([5][1])|([6][4598])$"))
            typeOfPhoneNumber = "Mobilni telefon";
        else
            typeOfPhoneNumber = "Telefon";

        System.out.println(typeOfPhoneNumber);
    }

    //GETER --> za pridobitev vpisanega števila
    public String getPhoneNumber() {
        return phoneNumber;
    }
}