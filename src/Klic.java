import com.google.common.collect.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Klic {
    private String cdrType;
    public String getCdrType() {
        return cdrType;
    }

    private String aPhoneNumber;
    public String getaPhoneNumber() {
        return aPhoneNumber;
    }

    private String bPhoneNumber;
    public String getbPhoneNumber() {
        return bPhoneNumber;
    }

    private String timeOfCall;
    public String getTimeOfCall() {
        return timeOfCall;
    }

    private String callLenght;
    public String getCallLenght() {
        return callLenght;
    }

    public Klic(String cdrType, String aPhoneNumber, String bPhoneNumber, String timeOfCall, String callLenght) {
        this.cdrType = cdrType;
        this.aPhoneNumber = aPhoneNumber;
        this.bPhoneNumber = bPhoneNumber;
        this.timeOfCall = timeOfCall;
        this.callLenght = callLenght;
    }
    /* Prepis vrednosti iz datoteke v Multimap */
    public static Multimap<String, Klic> readFileToMultiMap(String file) {
        Multimap<String, Klic> multiMapSorted = MultimapBuilder.treeKeys().treeSetValues(compareGetTimeOfCall()).build();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                String[] a = (br.readLine().split(";"));
                Klic callInfo = new Klic(a[0], a[1], a[2], a[3], a[4]);
                multiMapSorted.put(callInfo.getCdrType(), callInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return multiMapSorted;
    }
    /* Custom comparator */
    private static Comparator<Klic> compareGetTimeOfCall() {
        return (lhs, rhs) -> ComparisonChain.start().compare(Klic.convertUnixTimeStamp(rhs.getTimeOfCall()), Klic.convertUnixTimeStamp(lhs.getTimeOfCall())).result();
    }
    /* Izpis vseh tipov CDR, ki so UNIQ */
    public static void GetAllUniqueKeyForPrint(Multimap<String, Klic> multiMap) {
        System.out.println("Vsi ključi");
        var uniqueKeys = multiMap.keySet().toArray();

        for (Object b : uniqueKeys) {
            System.out.println(b);
        }
    }
    /* Izpis vseh klicov po Tipu CDR */
    public static void getAllValuesByTheType(Scanner s, Multimap<String, Klic> multiMap) {
        System.out.println("Izberi tip CDR-ja");
        String selectOption = s.nextLine();

        if (multiMap.containsKey(selectOption)) {
            for (Klic e : multiMap.get(selectOption)) {
                System.out.println(e.getCdrType() + " " + e.getaPhoneNumber() + " " + e.getbPhoneNumber() + " " + e.getTimeOfCall() + "(" + new Date(Long.parseLong(e.getTimeOfCall()) * 1000) + ") " + e.getCallLenght());
            }
        } else {
            System.out.println("CDR ne obstaja");
        }
    }
    /* UnixTimeStamp pretvorba v Datum */
    private static Date convertUnixTimeStamp(String date){
        return new Date(Long.parseLong(date) * 1000);
    }
}
