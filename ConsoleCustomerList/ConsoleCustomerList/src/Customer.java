import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer
{
    private String name;
    private String phone;
    private String eMail;

    Pattern namePattern = Pattern.compile("\\s*\\w+\\s+\\w+\\s*");

    Pattern eMailPattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");

    Pattern phonePattern = Pattern.compile("(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$");

    public Customer(String name, String phone, String eMail)
    {
        Matcher nameMatcher = namePattern.matcher(name);
        if (nameMatcher.find())
            this.name = name;
        else throw new IllegalArgumentException
                ("Name is not correct. Correct name: Василий Петров");
        Matcher phoneMatcher = phonePattern.matcher(phone);
        if (phoneMatcher.find())
            this.phone = phone;
        else throw new IllegalArgumentException
                ("Phone is not correct. Correct phone: +79215637722");
        Matcher eMailMatcher = eMailPattern.matcher(eMail);
        if (eMailMatcher.find())
            this.eMail = eMail;
        else throw new IllegalArgumentException
                ("Email is not correct. Correct eMail: vasily.petrov@gmail.com");
    }

    public String toString()
    {
        return name + " - " + eMail + " - " + phone;
    }
}
