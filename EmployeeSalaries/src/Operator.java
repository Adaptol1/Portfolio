

public class Operator implements Employee
{
    private double fixedPartOfSalary;
    protected void setFixedPartOfSalary (double fixedPartOfSalary)
    {
        this.fixedPartOfSalary = fixedPartOfSalary;
    }
    protected double getFixedPartOfSalary ()
    {
        return fixedPartOfSalary;
    }

    @Override
    public double getMonthSalary() {
        return getFixedPartOfSalary();
    }
}
