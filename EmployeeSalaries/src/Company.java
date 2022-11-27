import java.util.ArrayList;
import java.util.Collections;

public class Company
{
    private final ArrayList<Employee> workers = new ArrayList<>();
    private double income;
    public void setIncome (double income)
    {
        this.income = income;
    }
    public double getIncome ()
    {
        return income;
    }
    public void hire (Employee employee)
    {
        workers.add(employee);
    }
    public void hireAll (ArrayList<Employee> employees)
    {
        for (int i = 0; i < employees.size(); i++)
            workers.add(employees.get(i));
    }
    public void fire (int i)
    {
        workers.remove(i);
    }
    public ArrayList <Employee> getTopSalaryStaff (int count)
    {
        if (count > 0 && count <= (workers.size() + 1))
        {
            ArrayList <Employee> topSalaryStaff = new ArrayList<>(count);
            Collections.sort(workers);
            for (int i = 0; i < count; i++)
                topSalaryStaff.add(workers.get(i));
            return topSalaryStaff;
        }
        else throw new RuntimeException();
    }
    public ArrayList <Employee> getLowestSalaryStaff (int count)
    {
        if (count > 0 && count <= (workers.size()))
        {
            ArrayList<Employee> lowestSalaryStaff = new ArrayList<>(count);
            Collections.sort(workers);
            for (int i = 0; i < count; i++)
                lowestSalaryStaff.add(workers.get(workers.size() - 1 - i));
            return lowestSalaryStaff;
        }
        else throw new RuntimeException();
    }
    public ArrayList <Employee> getWorkers (){
        return workers;
    }
}
