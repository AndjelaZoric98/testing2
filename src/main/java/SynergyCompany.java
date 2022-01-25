import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class SynergyCompany {

    private List<Employee> employees = new ArrayList<>();
    Scanner s = new Scanner(System.in);


    public SynergyCompany() {
    }

    @Override
    public String toString() {
        String s = "Zaposleni: ";
        for (Employee e : employees) {
            s += e.toString() + "\n";
        }
        return s;
    }

    public boolean addEmployee(Employee e) {
        return employees.add(e);
    }

    public boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }

    public boolean findById(String id) {
        while (id.length() != 13 && !isNumeric(id)) {
            System.out.println("JMBG mora imati tačno 13 cifara. Pokušajte ponovo. ");
            String id2 = s.nextLine();
            findById(id2);
        }
        if (employees.isEmpty()) {
            return false;
        }
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getJmbg().equals(id)) {
                return true;
            }
        }
        return false;

    }

    public void addE() throws ParseException {
        System.out.println("Koliko zaposlenih želite da dodate? ");
        //2 puta pita pitanje..
        int noOfEmployees;
        if(isNumeric(s.nextLine())) {
            noOfEmployees = Integer.parseInt(s.nextLine());
            int no = 0;
            while (noOfEmployees > no) {
                System.out.println("Unesite ime zaposlenog.");

                String name = s.nextLine();
                System.out.println("Unesite prezime zaposlenog.");
                String lName = s.nextLine();
                System.out.println("Unesite jmbg zaposlenog:");
                String jmbg = s.nextLine();
                while (findById(jmbg)) {
                    System.out.println("Već postoji zaposleni sa unesenim jmbg-om. Probajte opet.");
                    jmbg = s.nextLine();


                }
                findById(jmbg);
                System.out.println("Unesite datum početka rada u formatu yyyy-mm-dd:");
                //isto 2 puta trazi da se unese
                if (s.nextLine().length() == 8) {
                     String year = s.nextLine();
                    List<Company> lista = new ArrayList<>();
                    System.out.println("Unesite ime firme.");
                    String cName = s.nextLine();
                    System.out.println("Unesite staž.");
                    Double totalY = s.nextDouble();
                    Company c = new Company(cName, totalY);
                    lista.add(c);
                    Date d = new SimpleDateFormat("yyyyMMdd").parse(year);
                    Employee e = new Employee(name, lName, jmbg, d, lista);
                    this.addEmployee(e);
                    no++;
                }else{
                    System.out.println("Pogrešan format za datum.");
                    return;
                }
            }
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
