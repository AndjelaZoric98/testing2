import java.util.ArrayList;
import java.util.List;

public class SynergyCompany {

    private  List<Employee> employees=new ArrayList<>();

    public SynergyCompany() {
    }

    @Override
    public String toString() {
        String s= "Synergy ima zaposlene:\n ";
        for (Employee e: employees) {
            s+=e.toString() + "\n";
        }
        return s;
    }

    public boolean addEmployee(Employee e){
        return employees.add(e);
    }

}