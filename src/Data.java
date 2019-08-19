import java.util.HashMap;

public  class Data {

    public static HashMap<String, Integer> getNumbers(){
        HashMap<String, Integer> phoneNumbersSTD = new HashMap<>();
        /*
            Napolnimo HashMap
            Ključ: STD,
            Vrednost: Tip telefonske številke
        */

        /*Skupna stevila (Mobitel + Telefon) */
        phoneNumbersSTD.put("30", 0);
        phoneNumbersSTD.put("34", 0);
        phoneNumbersSTD.put("35", 0);
        phoneNumbersSTD.put("40", 0);
        phoneNumbersSTD.put("44", 0);
        phoneNumbersSTD.put("45", 0);
        phoneNumbersSTD.put("50", 0);
        phoneNumbersSTD.put("54", 0);
        phoneNumbersSTD.put("55", 0);
        phoneNumbersSTD.put("70", 0);
        phoneNumbersSTD.put("74", 0);
        phoneNumbersSTD.put("75", 0);

        /*Mobilna števila (mobilna - skupna) */
        phoneNumbersSTD.put("31", 1);
        phoneNumbersSTD.put("38", 1);
        phoneNumbersSTD.put("39", 1);
        phoneNumbersSTD.put("41", 1);
        phoneNumbersSTD.put("48", 1);
        phoneNumbersSTD.put("49", 1);
        phoneNumbersSTD.put("51", 1);
        phoneNumbersSTD.put("58", 1);
        phoneNumbersSTD.put("59", 1);
        phoneNumbersSTD.put("61", 1);
        phoneNumbersSTD.put("68", 1);
        phoneNumbersSTD.put("69", 1);
        phoneNumbersSTD.put("71", 1);
        phoneNumbersSTD.put("78", 1);
        phoneNumbersSTD.put("79", 1);

        /* Telefonska števila (telefonska - skupna) */
        phoneNumbersSTD.put("12", 2);
        phoneNumbersSTD.put("13", 2);
        phoneNumbersSTD.put("16", 2);
        phoneNumbersSTD.put("17", 2);
        phoneNumbersSTD.put("22", 2);
        phoneNumbersSTD.put("23", 2);
        phoneNumbersSTD.put("26", 2);
        phoneNumbersSTD.put("27", 2);
        phoneNumbersSTD.put("32", 2);
        phoneNumbersSTD.put("33", 2);
        phoneNumbersSTD.put("36", 2);
        phoneNumbersSTD.put("37", 2);
        phoneNumbersSTD.put("42", 2);
        phoneNumbersSTD.put("43", 2);
        phoneNumbersSTD.put("46", 2);
        phoneNumbersSTD.put("47", 2);
        phoneNumbersSTD.put("52", 2);
        phoneNumbersSTD.put("53", 2);
        phoneNumbersSTD.put("56", 2);
        phoneNumbersSTD.put("57", 2);
        phoneNumbersSTD.put("72", 2);
        phoneNumbersSTD.put("73", 2);
        phoneNumbersSTD.put("76", 2);
        phoneNumbersSTD.put("77", 2);

        return phoneNumbersSTD;
    }
}
