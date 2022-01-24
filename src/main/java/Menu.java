import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {
    SynergyCompany sc = new SynergyCompany();

    public Menu() throws ParseException {
        menu();
    }


    public void menu() throws ParseException {

        Scanner s = new Scanner(System.in);


        System.out.println("MENI:\n1.Unos novog zaposlenog\n2.Pregled svih zaposlenih\n3.Odmor");
        switch (s.nextInt()) {
            case 1:
                System.out.println("Koliko zaposlenih želite da dodate? ");
                int noOfEmployees = s.nextInt();
                int no = 0;
                while (noOfEmployees > no) {
                    System.out.println("Unesite ime zaposlenog.");
                    String name = s.nextLine();
                    System.out.println("Unesite prezime zaposlenog.");
                    String lName = s.nextLine();
                    System.out.println("Unesite jmbg zaposlenog:");
                    int jmbg = s.nextInt();
                    System.out.println("Unesite datum početka rada.Prvo godina:");
                    String year = s.nextLine();
                    System.out.println("Mjesec:");
                    String month = s.nextLine();
                    year += month;
                    System.out.println("Dan:");
                    String day = s.nextLine();
                    year += day;
                    List<Company> lista = new ArrayList<>();

                    System.out.println("Unesite ime firme.");
                    String cName = s.nextLine();
                    System.out.println("Unesite staž.");
                    Double totalY = s.nextDouble();
                    Company c = new Company(cName, totalY);

                    lista.add(c);

                    Date d = new SimpleDateFormat("yyyyMMdd").parse(year);
                    Employee e = new Employee(name, lName, jmbg, d, lista);
                    sc.addEmployee(e);
                    no++;
                }
            case 2:
                System.out.println(sc);
                menu();

            case 3:
                System.out.println("Unesite Vaš JMBG.");
                for (int i = 0; sc.getEmployees().size() > i; i++) {
                    if (sc.getEmployees().get(i).getJmbg() == s.nextInt()) {
                        sc.getEmployees().get(i).takeVacation(sc.getEmployees().get(i));
                    } else {
                        System.out.println("Nema zaposlenog sa unesenim matičnim brojem.");
                        menu();
                    }

                }

                menu();
                break;

        }
    }


}
