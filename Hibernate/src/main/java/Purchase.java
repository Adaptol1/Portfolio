import javax.persistence.*;
import java.security.Key;
import java.util.Date;

@Entity
@Table(name = "Purchaselist")
public class Purchase
{
    @EmbeddedId
    private PurchaseId id;

    private int price;

    @Column (name = "subscription_date")
    private Date subscriptionDate;

    public PurchaseId getId() {
        return id;
    }

    public void setId(PurchaseId id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
