import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.management.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class Main
{
    private static String dbUrl = "jdbc:mysql://localhost:3306/skillbox";
    private static String user = "root";
    private static String password = "2442297";
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(dbUrl, user, password);
            String sqlTable = "CREATE TABLE LinkedPurchaseList\n" +
                    "(\n" +
                    "    student_name           VARCHAR (500) NOT NULL,\n" +
                    "    course_name            VARCHAR (500) NOT NULL\n" +
                    ")";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlTable);
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String purchaseHql = "From " + Purchase.class.getSimpleName();
        List<Purchase> purchaseList = session.createQuery(purchaseHql).getResultList();
        System.out.println(purchaseList.size());
        for (Purchase purchase : purchaseList) {
            LinkedPurchaseList row = new LinkedPurchaseList();
            row.setId(purchase.getId());
            row.getId().setCourseName(purchase.getId().getCourseName());
            row.getId().setStudentName(purchase.getId().getStudentName());
            session.save(row);
        }
        transaction.commit();
        sessionFactory.close();
    }
}
