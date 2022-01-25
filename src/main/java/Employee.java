import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Employee {

    public static final Set<DayOfWeek> weekendDays = new HashSet<>(Arrays.asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY));
    private final String jmbg;
    private String firstName;
    private String lastName;
    private Date startingDate;
    private List<Company> companies;
    private int daysLeft;
    Scanner s= new Scanner(System.in);

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public Employee(String firstName, String lastName, String jmbg, Date startingDate, List<Company> companies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbg = jmbg;
        this.startingDate = startingDate;
        this.companies = companies;

    }

    public boolean addCompany(Company c) {
        companies.add(c);
        return true;

    }



    /*public int showDays(Employee e) {
        daysLeft = 0;
        for (int i = 0; i < companies.size(); i++) {
            if ((Double) (e.companies.get(i).getTotalYears()) >= 5) {
                daysLeft = 21;

            } else if ((Double) (e.companies.get(i).getTotalYears()) >= 10) {
                daysLeft = 22;

            } else if ((Double) (e.companies.get(i).getTotalYears()) > 15) {
                daysLeft = 23;

            } else daysLeft = 20;
        }

        System.out.println("Broj slobodnih dana: " + daysLeft);
        return daysLeft;

    }*/


public int showDays(Employee e){
        daysLeft= 0;
        for (int i=0;i<companies.size();i++){
            for (int j=1;j<14;j++){
                if ((Double) (e.companies.get(i).getTotalYears()) >= 5*j) {
                    daysLeft = 20+j;

                }else{
                    daysLeft=20;
                }
            }
        }
    System.out.println("Broj slobodnih dana: " + daysLeft);
    return daysLeft;

}

    public int takeVacation() {

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

        LocalDate startDate = LocalDate.of(year1, month1, day1);
        LocalDate endDate = LocalDate.of(year2, month2, day2);

        long p2 = ChronoUnit.DAYS.between(startDate, endDate);

        List<LocalDate> vacationDays = IntStream.iterate(0, i -> i + 1).limit(p2).mapToObj(startDate::plusDays).collect(Collectors.toList());
        List<LocalDate> list = new ArrayList<>();
        for (LocalDate day : vacationDays) {
            if (!weekendDays.contains(day.getDayOfWeek())) {
                list.add(day);
            }
        }
        vacationDays = list;

        System.out.println("Broj preostalih dana sada je:  " + (daysLeft-vacationDays.size()));
        return (int) p2;

    }

    public double totalYearsInAllCompanies(Employee e){
        return companies.stream().mapToDouble(Company::getTotalYears).sum();

    }
    @Override
    public String toString() {
        String s = firstName + " " + lastName + "(" + jmbg + ")" +", počeo/la da radi : " + startingDate + "\nPrethodne kompanije: ";
        for (Company c : companies) {
            s += "\n"+ c.getNameC();

        }
        System.out.println(s);
        System.out.println("Broj godina u svim kompanijama:"+ totalYearsInAllCompanies(this));
        System.out.println("Broj dana slobodnih: " + showDays(this));
        return s;
    }

    public String getJmbg() {
        return jmbg;
    }
}
