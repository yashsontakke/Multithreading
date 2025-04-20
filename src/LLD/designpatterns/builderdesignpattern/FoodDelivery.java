package LLD.designpatterns.builderdesignpattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class User {
    private Long id;
    private String name;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() { return name; }
}

 class Restaurant {
    private Long id;
    private String name;

    public Restaurant(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() { return name; }
}

// make quantity mutable
 class OrderItem {
    private String itemName;
    private int quantity;

    public OrderItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return itemName + " x" + quantity;
    }
}


class Order {
    private final User user;
    private final Restaurant restaurant;
    private final List<OrderItem> items;
    private final String deliveryAddress;

    // Constructor is private to enforce use of builder
    private Order(OrderBuilder builder) {
        this.user = builder.user;
        this.restaurant = builder.restaurant;
        this.items = builder.items;
        this.deliveryAddress = builder.deliveryAddress;
    }

    // Getters
    public User getUser() { return user; }
    public Restaurant getRestaurant() { return restaurant; }
    public List<OrderItem> getItems() { return items; }
    public String getDeliveryAddress() { return deliveryAddress; }

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user.getName() +
                ", restaurant=" + restaurant.getName() +
                ", items=" + items +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                '}';
    }

    // Static nested Builder class
    public static class OrderBuilder {
        private User user;
        private Restaurant restaurant;
        private List<OrderItem> items = new ArrayList<>();
        private String deliveryAddress;

        public OrderBuilder setUser(User user) {
            this.user = user;
            return this;
        }

        public OrderBuilder setRestaurant(Restaurant restaurant) {
            this.restaurant = restaurant;
            return this;
        }

        public OrderBuilder addItem(OrderItem item) {
            this.items.add(item);
            return this;
        }

        public OrderBuilder setDeliveryAddress(String address) {
            this.deliveryAddress = address;
            return this;
        }

        public Order build() {
            // Basic validation
            if (user == null || restaurant == null || items.isEmpty()) {
                throw new IllegalStateException("Order must have user, restaurant, and at least one item.");
            }
            return new Order(this);
        }
    }


}

// Mutable
class Cart {
    private Map<String, OrderItem> items = new HashMap<>();

    //User adds/removes items in a Cart (mutable).
    public void addItem(String itemName, int quantity) {
        items.merge(itemName, new OrderItem(itemName, quantity),
                (oldItem, newItem) -> {
                    oldItem.setQuantity(oldItem.getQuantity() + newItem.getQuantity());
                    return oldItem;
                });
    }

    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    public void updateItemQuantity(String itemName, int quantity) {
        if (items.containsKey(itemName)) {
            if (quantity <= 0) {
                items.remove(itemName);
            } else {
                items.get(itemName).setQuantity(quantity);
            }
        }
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items.values());
    }

    public void clear() {
        items.clear();
    }
}

public class FoodDelivery {
    public static void main(String[] args) {
        User user = new User(1L, "Yash");
        Restaurant restaurant = new Restaurant(101L, "Pizza Palace");

        // Cart operations
        Cart cart = new Cart();
        cart.addItem("Burger", 2);
        cart.addItem("Fries", 1);
        cart.updateItemQuantity("Fries", 3);
        cart.removeItem("Burger");

        // Create Order
        Order.OrderBuilder builder = new Order.OrderBuilder()
                .setUser(user)
                .setRestaurant(restaurant)
                .setDeliveryAddress("Maple Street");

        for (OrderItem item : cart.getItems()) {
            builder.addItem(item);
        }

        Order order = builder.build();

        System.out.println(order);

        // Clear cart after order
        cart.clear();
    }
}

