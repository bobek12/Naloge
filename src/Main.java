import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        boolean runProgram = true;

        /* Glavni program */
        while(runProgram){
            //Glavni Menu
            programMenu();
            String selectOption = s.nextLine();

            switch (selectOption){
                case "1":
                    System.out.println("Vpiši telefonsko številko:");
                    String writePhoneNumber = s.nextLine();

                    PhoneNumber phone = new PhoneNumber(writePhoneNumber);

                    if(phone.getPhoneNumber() != null){
                        //Pod-menu - Vpis telefonske številke
                        programMenuFirst();
                        String selectValidation = s.nextLine();

                        switch(selectValidation){
                            case "1":
                                phone.checkPhoneNumberType();
                                break;

                            case "2":
                                phone.checkPhoneNumberTypeByRegex();
                                break;
                        }
                    }
                    break;
                default:
                    runProgram = false;
                    break;
            }
        }
    }

    /* Izpis menuja */
    public static void programMenuFirst() {
        System.out.println("---------------------------");
        System.out.println("1. Preveri ali gre za mobilno ali telefonsko številko\n2. Regex preverjanje");
        System.out.println("---------------------------");
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

