import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Quantity: " + quantity + ", Price: $" + price;
    }
}

class Order {
    private int orderId;
    private String productName;
    private int quantity;

    public Order(int orderId, String productName, int quantity) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Product: " + productName + ", Quantity: " + quantity;
    }
}

class ProductRequest {
    private int requestId;
    private String productName;
    private int quantity;

    public ProductRequest(int requestId, String productName, int quantity) {
        this.requestId = requestId;
        this.productName = productName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Request ID: " + requestId + ", Product: " + productName + ", Quantity: " + quantity;
    }
}

class Feedback {
    private int feedbackId;
    private String feedbackText;

    public Feedback(int feedbackId, String feedbackText) {
        this.feedbackId = feedbackId;
        this.feedbackText = feedbackText;
    }

    @Override
    public String toString() {
        return "Feedback ID: " + feedbackId + ", Feedback: " + feedbackText;
    }
}

public class SupplyChainManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select a module:");
            System.out.println("1. Admin");
            System.out.println("2. Dealer");
            System.out.println("3. Client");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminModule();
                    break;
                case 2:
                    dealerModule();
                    break;
                case 3:
                    clientModule();
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void adminModule() {
        List<Product> products = new ArrayList<>();
        // Initialize some sample products
        products.add(new Product("Product A", 100, 10.0));
        products.add(new Product("Product B", 50, 20.0));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Admin Module");
            System.out.println("1. View Products");
            System.out.println("2. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Product List:");
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.println("Exiting Admin Module");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void dealerModule() {
        List<Product> inventory = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        int orderIdCounter = 1;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Dealer Module");
            System.out.println("1. View Inventory");
            System.out.println("2. Place Order");
            System.out.println("3. View Orders");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Inventory List:");
                    for (Product product : inventory) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.println("Place an Order");
                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    Product product = findProduct(inventory, productName);

                    if (product == null) {
                        System.out.println("Product not found in inventory.");
                    } else if (product.getQuantity() < quantity) {
                        System.out.println("Insufficient quantity in inventory.");
                    } else {
                        product.setQuantity(product.getQuantity() - quantity);
                        Order order = new Order(orderIdCounter++, productName, quantity);
                        orders.add(order);
                        System.out.println("Order placed successfully.");
                    }
                    break;
                case 3:
                    System.out.println("Order List:");
                    for (Order order : orders) {
                        System.out.println(order);
                    }
                    break;
                case 4:
                    System.out.println("Exiting Dealer Module");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static Product findProduct(List<Product> inventory, String productName) {
        for (Product product : inventory) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    private static void clientModule() {
        List<ProductRequest> productRequests = new ArrayList<>();
        List<Feedback> feedbackList = new ArrayList<>();
        int productRequestIdCounter = 1;
        int feedbackIdCounter = 1;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Client Module");
            System.out.println("1. Submit Product Request");
            System.out.println("2. Provide Feedback");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Submit a Product Request");
                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    ProductRequest request = new ProductRequest(productRequestIdCounter++, productName, quantity);
                    productRequests.add(request);
                    System.out.println("Product request submitted successfully.");
                    break;
                case 2:
                    System.out.println("Provide Feedback");
                    System.out.print("Enter your feedback: ");
                    scanner.nextLine();  // Consume newline character
                    String feedbackText = scanner.nextLine();
                    Feedback feedback = new Feedback(feedbackIdCounter++, feedbackText);
                    feedbackList.add(feedback);
                    System.out.println("Feedback provided successfully.");
                    break;
                case 3:
                    System.out.println("Exiting Client Module");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

