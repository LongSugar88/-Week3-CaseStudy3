package Method;

import Model.Card;
import Model.User;

import java.util.Date;

public class BuyCard {
    private static final String ADD_NEW_ORDER = "INSERT INTO order(name, quantity, date, card_id, user_id, price) VALUES (? , ?, ?, ?, ?, ?);";
    public static void buy(User user, Card card){
        String name = user.getName();
        int quantity = 1;
        Double price = card.getPrice();
        Date date = System.l;
        String quantity = String.valueOf(card.getQuantity());
        String image = card.getImage();
    }
}
