import java.util.ArrayList;
import java.util.Collections;

public class Main
{
    public static void main (String [] args)
    {
        Company company = new Company();
        company.setIncome(11_000_000);
        for (int i = 0; i < 180; i++ )
        {
            Operator operator = new Operator ();
            double salary = 30_000 + Math.random() * 10_000;
            operator.setFixedPartOfSalary(salary);
            company.hire(operator);
        }
        for (int i = 0; i < 80; i++ )
        {
            Manager manager = new Manager ();
            double salary = 50_000 + Math.random() * 10_000;
            manager.setFixedPartOfSalary(salary);
            company.hire(manager);
        }
        for (int i = 0; i < 10; i++ )
        {
            TopManager topManager = new TopManager ();
            topManager.setCompany(company);
            double salary = 70_000 + Math.random() * 10_000;
            topManager.setFixedPartOfSalary(salary);
            company.hire(topManager);
        }
        System.out.println("Самые высокие зарплаты в компании:");
        for (int i = 0; i < 15; i++)
            System.out.println(company.getTopSalaryStaff(270).get (i).getMonthSalary());
        System.out.println("Самые низкие зарплаты в компании:");
        for (int i = 0; i < 30; i++)
            System.out.println(company.getLowestSalaryStaff(270).get (i).getMonthSalary());
        for (int i = 0; i < 135; i++)
            company.fire(i);
        System.out.println("Самые высокие зарплаты в компании:");
        for (int i = 0; i < 15; i++)
            System.out.println(company.getTopSalaryStaff(135).get (i).getMonthSalary());
        System.out.println("Самые низкие зарплаты в компании:");
        for (int i = 0; i < 30; i++)
            System.out.println(company.getLowestSalaryStaff(135).get (i).getMonthSalary());
        ArrayList <Employee> staff = new ArrayList <> (company.getWorkers());
        Collections.sort (staff, (o1, o2) -> Double.compare(o1.getMonthSalary(), o2.getMonthSalary()));
        System.out.println("Сортировка сотрудников по зарплате:");
        for (Employee salary : staff)
            System.out.println (salary.getMonthSalary());
    }
}
