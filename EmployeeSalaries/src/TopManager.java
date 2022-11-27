

public class TopManager implements Employee
{
    private Company company;
    private double monthSalary;
    private double fixedPartOfSalary;
    protected void setFixedPartOfSalary (double fixedPartOfSalary)
    {
        this.fixedPartOfSalary = fixedPartOfSalary;
    }
    protected double getFixedPartOfSalary ()
    {
        return fixedPartOfSalary;
    }
    public void setCompany (Company company)
    {
        this.company = company;
    }
    @Override
    public double getMonthSalary () {
        if (company.getIncome() > 10_000_000)
        monthSalary = getFixedPartOfSalary() * 2.5;
        else monthSalary = getFixedPartOfSalary();
        return monthSalary;
    }
}
