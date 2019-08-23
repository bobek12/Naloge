import com.google.common.base.Functions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Ordering;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String file = "klici.cdr";

        try (Scanner s = new Scanner(System.in)) {
            boolean runProgram = true;

            /* Glavni program */
            while (runProgram) {
                /* Glavni Menu */
                programMenu();
                String selectOption = s.nextLine();

                switch (selectOption) {
                    /* Vpis telefonske številke */
                    case "1":
                        System.out.println("Vpiši telefonsko številko:");
                        String writePhoneNumber = s.nextLine();

                        PhoneNumber phone = new PhoneNumber(writePhoneNumber);

                        if (phone.getPhoneNumber() != null) {
                            System.out.println("Telefonska številka:  " + phone.getPhoneNumber() + " Tip telefonske številke:  " + phone.getType());
                            phone.addPhoneNumberToDb();
                        }
                        break;
                    /* Izpis vseh telefonskih števil */
                    case "2":
                        PhoneNumber.getAllPhoneNumbers();
                        break;
                    /* Izpis telefonskega števila glede na vnešeno tel. številko */
                    case "3":
                        System.out.println("Vpiši telefonsko številko:");
                        writePhoneNumber = s.nextLine();

                        PhoneNumber phoneNumber = new PhoneNumber(writePhoneNumber);

                        if (phoneNumber.getPhoneNumber() != null)
                            phoneNumber.getPhoneNumberByNumber(phoneNumber.getPhoneNumber());
                        break;
                    /* Izbriše telefonsko številko glede na vnešeno tel. številko */
                    case "4":
                        System.out.println("Vpiši telefonsko številko za brisanje:");
                        writePhoneNumber = s.nextLine();

                        PhoneNumber phoneNumberDel = new PhoneNumber(writePhoneNumber);
                        if (phoneNumberDel.getPhoneNumber() != null)
                            phoneNumberDel.deletePhoneNumberByNumber(phoneNumberDel.getPhoneNumber());
                        break;
                    /* Izbriše vse  telefonske številke iz DB */
                    case "5":
                        PhoneNumber.deleteAllPhoneNumbers();
                        break;
                    /* Izpis po tipu CDR */
                    case "6":
                        ListMultimap<String, Klic> multiMap = Klic.readFileToMultiMap(file);
                        Klic.GetAllUniqueKeyForPrint(multiMap);
                        Klic.getAllValuesByTheType(s, multiMap);

                        break;
                    case "7":
                        //TODO: sortiranje po velikosti
                        ListMultimap<String, Klic> multiMapSort = Klic.readFileToMultiMap(file);


                    default:
                        runProgram = false;
                        break;
                }
            }
        }
    }

    private static void sortMultimapByTimeOfCall(ListMultimap<String,Klic> multiMapSort) { }

    /* Izpis podmenuja */
    public static void programMenu() {
        System.out.println("---------------------------");
        System.out.println("1. Vpis telefonske številke");
        System.out.println("2. Izpis vseh telefonskih števil");
        System.out.println("3. Izpis telefonske številke");
        System.out.println("4. Brisanje telefonske številke");
        System.out.println("5. Brisanje vseh telefonskih številk");
        System.out.println("6. Izpis po tipu CDR ");
        System.out.println("---------------------------");
    }


}

