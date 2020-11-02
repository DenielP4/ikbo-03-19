package practice16;

import java.util.Collection;

public class RestaurantOrder extends OrderManager {
    public RestaurantOrder() {
    }

    public RestaurantOrder(Collection<Item> collection) {
        super(collection);
    }
}
