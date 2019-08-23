import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Klic {
    private String cdrType;
    private String aPhoneNumber;
    private String bPhoneNumber;
    private String timeOfCall;
    private String callLenght;
    
    public Klic(String cdrType, String aPhoneNumber, String bPhoneNumber, String timeOfCall, String callLenght) {

        this.cdrType = cdrType;
        this.aPhoneNumber = aPhoneNumber;
        this.bPhoneNumber = bPhoneNumber;
        this.timeOfCall = timeOfCall;
        this.callLenght = callLenght;
    }

    public String getCdrType() {
        return cdrType;
    }

    public String getaPhoneNumber() {
        return aPhoneNumber;
    }

    public String getbPhoneNumber() {
        return bPhoneNumber;
    }

    public String getTimeOfCall() {
        return timeOfCall;
    }

    public String getCallLenght() {
        return callLenght;
    }

    public static ListMultimap<String, Klic> readFileToMultiMap(String file){
        ListMultimap<String, Klic> multimap = ArrayListMultimap.create();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                String[] a = (br.readLine().split(";"));

                Klic callInfo = new Klic(a[0], a[1], a[2], a[3], a[4]);
                multimap.put(callInfo.getCdrType(), callInfo);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return multimap ;
    }

    public static void GetAllUniqueKeyForPrint(ListMultimap<String,Klic> multiMap) {
        System.out.println("Vsi ključi");

        var uniqueKeys = multiMap.keySet().toArray();

        for (Object b : uniqueKeys) {
            System.out.println(b);
        }
    }

    public static void getAllValuesByTheType(Scanner s, ListMultimap<String, Klic> multiMap) {
        System.out.println("Izberi tip CDR-ja");
        String selectOption = s.nextLine();

        if (multiMap.containsKey(selectOption)) {
            for (Klic e : multiMap.get(selectOption)) {
                System.out.println(e.getCdrType() + " " + e.getaPhoneNumber() + " " + e.getbPhoneNumber() + " " + e.getTimeOfCall() + " " + e.getCallLenght());
            }
        } else {
            System.out.println("CDR ne obstaja");

        }
    }

}
