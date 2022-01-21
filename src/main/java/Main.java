import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Scanner s=new Scanner(System.in);
        System.out.println("Unesite ime zaposlenog");
        String name=s.nextLine();
        System.out.println("Unesite prezime zaposlenog");
        String lName=s.nextLine();
        System.out.println("Unesite datum pocetka rada.Prvo godina");
        String year=s.nextLine();
        System.out.println("Mjesec");
        String month=s.nextLine();
        year+=month;
        System.out.println("Dan");
        String day=s.nextLine();
        year+=day;
        System.out.println("Unesite ime kompanije gdje je radio");
        String cName=s.nextLine();
        System.out.println("Unesite staz");
        Double totalY=s.nextDouble();
        Company c= new Company(cName,totalY);

        List<Company> lista= new ArrayList<>();
        lista.add(c);
           Date d= new SimpleDateFormat( "yyyyMMdd" ).parse( year );
            Employee e= new Employee(name,lName,d,lista);

       SynergyCompany sc=new SynergyCompany();
       sc.addEmployee(e);
        System.out.println(sc);
e.showDays(e);
e.takeVacation();

    }
}
