import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Employee {

    private String firstName;
    private String lastName;
    private Date startingDate;
    private List<Company> companies;
private int daysLeft;

    public Employee(String firstName, String lastName, Date startingDate, List<Company> companies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startingDate = startingDate;
        this.companies = companies;
    }

    public boolean addCompany(Company c){
        companies.add(c);
        return true;

    }

    public int showDays(Employee e) {
        int x=0;
        for (int i = 0; i < companies.size(); i++) {
            if ((Double)(e.companies.get(i).getTotalYears()) >=5) {
                x= 21;

            } else if ((Double)(e.companies.get(i).getTotalYears() )>=10) {
                x= 22;

            } else if ((Double)(e.companies.get(i).getTotalYears()) >+15) {
                x= 23;

            }
            else x=20;
        }

        System.out.println("Broj slobodnih dana: " + x);
        return x;

    }

    public void takeVacation() {
        Scanner s=new Scanner(System.in);
        System.out.println("Unesite datum pocetka odmora, prvo godina:");
        int year1=s.nextInt();
        System.out.println("Mjesec");
        int month1=s.nextInt();
        System.out.println("Dan");
        int day1=s.nextInt();

        System.out.println("Unesite datum zavrsetka odmora, prvo godina:");
        int year2=s.nextInt();
        System.out.println("Mjesec");
        int month2=s.nextInt();
        System.out.println("Dan");
        int day2=s.nextInt();


        long p2 = ChronoUnit.DAYS.between(LocalDate.of(year1,month1,day1),LocalDate.of(year2,month2,day2));
        System.out.println("Broj dana je: " + p2);

    }

    @Override
    public String toString() {
        String s="Zaposleni/a : " + firstName + " " + lastName + ", poceo/la da radi : " + startingDate + "\nPrethodne kompanije: ";
        for (Company c: companies) {
            s+=c.getNameC();
            
        }
           return s;
        }



}
