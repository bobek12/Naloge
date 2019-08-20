import javax.xml.crypto.Data;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {
            boolean runProgram = true;

            /* Glavni program */
            while (runProgram) {
                //Glavni Menu
                programMenu();
                String selectOption = s.nextLine();

                switch (selectOption) {
                    case "1":
                        System.out.println("Vpiši telefonsko številko:");
                        String writePhoneNumber = s.nextLine();

                        PhoneNumber phone = new PhoneNumber(writePhoneNumber);

                        if (phone.getPhoneNumber() != null)
                            phone.checkPhoneNumberTypeByRegex();

                        break;

                    case "2":
                        Database database = new Database();
                        database.insertPhoneNumber();

                    default:
                        runProgram = false;
                        break;
                }

            }
        }

    }
    /* Izpis podmenuja */
    public static void programMenu() {
        System.out.println("---------------------------");
        System.out.println("1. Vpis telefonske številke");
        System.out.println("2. Baza");
        System.out.println("3. Vpis v datoteko");
        System.out.println("4. Izhod");
        System.out.println("---------------------------");
    }

}

