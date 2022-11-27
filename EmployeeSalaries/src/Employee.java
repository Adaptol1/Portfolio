import java.math.BigDecimal;

public interface Employee extends Comparable <Employee>
{
    public double getMonthSalary ();
    @Override
    default int compareTo(Employee employee) {
        if (getMonthSalary() > employee.getMonthSalary())
            return -1;
        if (getMonthSalary() < employee.getMonthSalary())
            return 1;
        return 0;
    }
}


