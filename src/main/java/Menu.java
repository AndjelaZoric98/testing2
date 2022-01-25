import java.text.ParseException;
import java.util.Scanner;

public class Menu {
    SynergyCompany sc = new SynergyCompany();
    Scanner s = new Scanner(System.in);

    public Menu() throws ParseException {
        menu();
    }




    public void menu() throws ParseException {

        if (sc.getEmployees().isEmpty()) {

            sc.addE();
            menu();


        } else {
            System.out.println("MENI:\n1.Unos novog zaposlenog\n2.Pregled svih zaposlenih\n3.Odmor \n4.Dodaj kompaniju zaposlenom\n5.Prikaz zaposlenog");

            switch (s.nextInt()) {
                case 1:
                    sc.addE();
                    menu();
                case 2:
                    System.out.println(sc);
                    menu();

                case 3:
                    System.out.println("Unesite Vaš JMBG.");
                    s.nextLine();
                    String jmbg = s.nextLine();
                    for (int i = 0; sc.getEmployees().size() > i; i++) {
                        if (sc.getEmployees().get(i).getJmbg().equals(jmbg)) {
                            sc.getEmployees().get(i).takeVacation();
                            menu();
                        }
                    }
                    System.out.println("Nema zaposlenog sa unesenim matičnim brojem.");
                    menu();
                case 4:
                    System.out.println("Unesite ime kompanije");
                    s.nextLine();
                    String companyName = s.nextLine();
                    System.out.println("Unesite godine rada u kompaniji (DOUBLE): ");
                    double duration = s.nextDouble();

                    System.out.println("Unesite jmbg osobe kojoj se kompanija dodaje.");
                    s.nextLine();
                    String jmbg2 = s.nextLine();
                    for (int i = 0; sc.getEmployees().size() > i; i++) {

                        if (sc.findById(jmbg2)) {
                            sc.getEmployees().get(i).addCompany(new Company(companyName, duration));
                            menu();

                        }
                    }
                case 5:
                    System.out.println("Unesite Vaš JMBG.");
                    s.nextLine();
                    String jmbg3 = s.nextLine();
                    for (int i = 0; sc.getEmployees().size() > i; i++) {

                        if (sc.findById(jmbg3)) {
                            sc.getEmployees().get(i).toString();
                            menu();
                        }
                    }
            }
        }


    }


}
