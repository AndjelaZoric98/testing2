import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Employee {
private int jmbg;
    private String firstName;
    private String lastName;
    private Date startingDate;
    private List<Company> companies;
    private int daysLeft;

    public Employee(String firstName, String lastName,int jmbg, Date startingDate, List<Company> companies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbg=jmbg;
        this.startingDate = startingDate;
        this.companies = companies;

    }

    public Employee(int jmbg) {
        this.jmbg = jmbg;
    }

    public boolean addCompany(Company c) {
        companies.add(c);
        return true;

    }


    public int showDays(Employee e) {
        daysLeft = 0;
        for (int i = 0; i < companies.size(); i++) {
            if ((Double) (e.companies.get(i).getTotalYears()) >= 5) {
                daysLeft = 21;

            } else if ((Double) (e.companies.get(i).getTotalYears()) >= 10) {
                daysLeft = 22;

            } else if ((Double) (e.companies.get(i).getTotalYears()) > +15) {
                daysLeft = 23;

            } else daysLeft = 20;
        }

        System.out.println("Broj slobodnih dana: " + daysLeft);
        return daysLeft;

    }

    public int takeVacation(Employee e) {

        Scanner s = new Scanner(System.in);
        System.out.println("Unesite datum početka odmora, prvo godina:");
        int year1 = s.nextInt();
        System.out.println("Mjesec");
        int month1 = s.nextInt();
        System.out.println("Dan");
        int day1 = s.nextInt();

        System.out.println("Unesite datum završetka odmora, prvo godina:");
        int year2 = s.nextInt();
        System.out.println("Mjesec");
        int month2 = s.nextInt();
        System.out.println("Dan");
        int day2 = s.nextInt();


        long p2 = ChronoUnit.DAYS.between(LocalDate.of(year1, month1, day1), LocalDate.of(year2, month2, day2));
        System.out.println("Broj dana odmora je:  " + p2);
        e.daysLeft = e.showDays(e) - (int) p2;
        System.out.println("Broj dana koje Vam je ostalo sada je: " + daysLeft);

        return (int) p2;

    }

    @Override
    public String toString() {
        String s = firstName + " " + lastName + ", počeo/la da radi : " + startingDate + "\nPrethodne kompanije: ";
        for (Company c : companies) {
            s += c.getNameC()+"\n";

        }
        return s;
    }

    public int getJmbg() {
        return jmbg;
    }
}
