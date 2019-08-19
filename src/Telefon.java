import java.util.HashMap;
import java.util.Map;

public class Telefon {
    private String phoneNumber;

    public Telefon (String phoneNumber){
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

    /* Preveri Telefonsko številko na podalgi primerjav STD v HASH tabeli. */
    public void checkPhoneNumberType() {
        String phoneNumberStd = this.phoneNumber.substring(3,5);

        HashMap<String, Integer> phoneNumbers = Podatki.getNumbers();

        int typeOfPhoneNumber = -1;

        for(Map.Entry<String, Integer> entry : phoneNumbers.entrySet()){
            if(entry.getKey().equals(phoneNumberStd))
                typeOfPhoneNumber =  entry.getValue();
        }

        getMessageAboutNumberType(typeOfPhoneNumber);
    }

    /* Preveri Telefonsko številko na podalgi primerjave z regex izrazi */
    public void checkPhoneNumberTypeByRegex() {
        String phoneNumberStd = this.phoneNumber.substring(3,5);

        int typeOfPhoneNumber = -1;

        /*Telefonska številka ali mobilna številka */
        if(phoneNumberStd.matches("^[3457][045]$"))
            typeOfPhoneNumber = 0;
        /* Mobilna številka */
        else if(phoneNumberStd.matches("^[34567][014589]$"))
            typeOfPhoneNumber = 1;
        /* Telefonska številka */
        else if(phoneNumberStd.matches("^[123457][0234567]$"))
            typeOfPhoneNumber = 2;
        /* Neznan številka */
        else if(phoneNumberStd.matches("^[890][0123456789]$"))
            typeOfPhoneNumber = 3;

        getMessageAboutNumberType(typeOfPhoneNumber);
    }

    /* Pridobimo sporočilo za izpis tipa vpisane številke na podlagi tipa */
    private void getMessageAboutNumberType(int typeOfPhoneNumber) {
        String message;

        switch (typeOfPhoneNumber){
            case 0 :
                message = "Mobilni ali stacionarni telefon";
                break;
            case 1 :
                message = "Mobilni telefon";
                break;
            case 2 :
                message = "Stacionarni telefon";
                break;
            default:
                message = "Neznano";
                break;
        }
        System.out.println(message);
    }

    //GETER --> za pridobitev vpisanega števila
    public String getPhoneNumber() {
        return phoneNumber;
    }
}