

public class Manager implements Employee
{
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
    private double earnedMoney = Math.random() * (140_000 - 115_000) + 115_000;
    @Override
    public double getMonthSalary() {
        monthSalary = 0.05 * earnedMoney + getFixedPartOfSalary();
        return monthSalary;
    }
}
