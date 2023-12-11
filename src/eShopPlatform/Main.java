package eShopPlatform;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements ShoppingCartObserver {

	public static void main(String[] args) {
		ShoppingCartSubject shoppingCartSubject = new ShoppingCartSubject();

		shoppingCartSubject.addObserver(new Main());
		eShopInventory inventory = new eShopInventory();
		ProductDirector director = new ProductDirector();
		ProductBuilder builder = new ProductBuilder();
		List<Product> shoppingCart = new ArrayList<>();

		// Construct and add products to the inventory
		director.constructProduct(builder, "Dairy", "Milk", 2);
		builder.setStock(5);
		Product milk1 = builder.getProduct();
		inventory.addProduct(milk1);

		director.constructProduct(builder, "Dairy", "Cheese", 5);
		builder.setStock(5);
		Product cheese1 = builder.getProduct();
		inventory.addProduct(cheese1);

		director.constructProduct(builder, "Dairy", "Yogurt", 1);
		builder.setStock(5);
		Product yogurt1 = builder.getProduct();
		inventory.addProduct(yogurt1);

		director.constructProduct(builder, "Clothing", "Pants", 40);
		builder.setStock(3);
		Product pants1 = builder.getProduct();
		inventory.addProduct(pants1);

		director.constructProduct(builder, "Electronics", "Smartphone", 699);
		builder.setStock(10);
		Product smartphone = builder.getProduct();
		inventory.addProduct(smartphone);

		director.constructProduct(builder, "Utilities", "ScrewDriver", 50);
		builder.setStock(10);
		Product screwdriver = builder.getProduct();
		inventory.addProduct(screwdriver);

		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			displayMainMenu();
			choice = getUserChoice(scanner, 3);

			switch (choice) {
			case 1:
				displayCart(shoppingCart, shoppingCartSubject, scanner);
				break;
			case 2:
				displayCategories(inventory, shoppingCart, scanner);
				break;
			case 3:
				System.out.println("Exiting the eShop Platform. Goodbye!");
				break;
			}

		} while (choice != 3);

		scanner.close();
	}

	private static void displayMainMenu() {
		System.out.println("Welcome to the eShop Platform");
		System.out.println("1. Cart");
		System.out.println("2. Display Inventory");
		System.out.println("3. Exit");
	}

	private static void displayCart(List<Product> shoppingCart, ShoppingCartSubject subject, Scanner scanner) {
		int total = 0;
		if (shoppingCart.isEmpty()) {
			System.out.println("Your shopping cart is empty.");
		} else {
			System.out.println("Shopping Cart:");
			for (int i = 0; i < shoppingCart.size(); i++) {
				Product product = shoppingCart.get(i);
				total = (int) (total + product.getPrice());
				System.out.println( product.getName() + ", Price: " + product.getPrice());
			}
			System.out.println("Your total cost is: " + total);

			System.out.println("\n" + "1" + ". Back to Main Menu");
			System.out.println("2" + ". Purchase");
			int cartChoice = getUserChoice(scanner, 2);

			if (cartChoice ==   1) {
				return;
			} else if (cartChoice ==  2) {

				System.out.println("\nSelect Delivery method:");
				System.out.println("1. Pickup point");
				System.out.println("2. In Store");
				int deliveryChoice = getUserChoice(scanner, 2);
				switch (deliveryChoice) {
				case 1:
					System.out.println("Pickup point chosen");
					break;
				case 2:
					System.out.println("In Store chosen");
				}

				System.out.println("\nSelect payment method:");
				System.out.println("1. Cash");
				System.out.println("2. Card");

				int paymentChoice = getUserChoice(scanner, 2);

				switch (paymentChoice) {
				case 1:
					System.out.println("Thank you for your purchase! Payment completed with cash.");
					break;
				case 2:
					System.out.println("Thank you for choosing card payment.");
					try {
						Thread.sleep(500);
						System.out.print("Initiating card scan");
						Thread.sleep(500);
						System.out.print(".");
						Thread.sleep(500);
						System.out.print(".");
						Thread.sleep(500);
						System.out.println(".");
						Thread.sleep(500);
						System.out.print("Scanning card");
						Thread.sleep(500);
						System.out.print(".");
						Thread.sleep(500);
						System.out.print(".");
						Thread.sleep(500);
						System.out.println(".");
						Thread.sleep(500);
						System.out.print("Card scanned. Processing payment");
						Thread.sleep(500);
						System.out.print(".");
						Thread.sleep(500);
						System.out.print(".");
						Thread.sleep(500);
						System.out.println(".");
						Thread.sleep(500);
						System.out.print("Insuficient funds");
						Thread.sleep(500);
						System.out.print(".");
						Thread.sleep(500);
						System.out.print(".");
						Thread.sleep(500);
						System.out.println(".");
						Thread.sleep(500);
						System.out.print("HaHa just Kidding");
						Thread.sleep(500);
						System.out.print(".");
						Thread.sleep(500);
						System.out.print(".");
						Thread.sleep(500);
						System.out.println(".");
						Thread.sleep(500);
						System.out.print("Payment completed with card. Thank you for your purchase!");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				default:
					System.out.println("Invalid payment option. Payment failed.");
				}

				for (Product product : shoppingCart) {
					product.reduceStock(1);
				}

				shoppingCart.clear();
				subject.updateShoppingCart(shoppingCart);
			} else {
				System.out.println("Invalid choice.");
			}
		}
	}

	private static void displayCategories(eShopInventory inventory, List<Product> shoppingCart, Scanner scanner) {
		int categoryChoice;

		do {
			System.out.println("Categories:");
			for (int i = 0; i < inventory.getCategories().size(); i++) {
				System.out.println((i + 1) + ". " + inventory.getCategory(i));
			}

			System.out.println((inventory.getCategories().size() + 1) + ". Back to Main Menu");
			categoryChoice = getUserChoice(scanner, inventory.getCategories().size() + 1);

			if (categoryChoice == inventory.getCategories().size() + 1) {

				return;
			}

			String chosenCategory = inventory.getCategory(categoryChoice - 1);

			do {
				System.out.println("\nProducts in " + chosenCategory + ":");
				List<Product> productsInCategory = inventory.getProductsInCategory(chosenCategory);
				for (int i = 0; i < productsInCategory.size(); i++) {
					Product product = productsInCategory.get(i);
					System.out.println((i + 1) + ". Name: " + product.getName() + ", Price: " + product.getPrice()
							+ ", Stock: " + product.getStock());
				}

				System.out.println("\n" + (productsInCategory.size() + 1) + ". Back to Categories");
				// System.out.println((productsInCategory.size() + 2) + ". Back to Main Menu");
				int productChoice = getUserChoice(scanner, productsInCategory.size() + 1);

				if (productChoice == productsInCategory.size() + 1) {
					break;
				}

				Product selectedProduct = productsInCategory.get(productChoice - 1);
				System.out.println("Adding " + selectedProduct.getName() + " to the cart.");
				shoppingCart.add(selectedProduct);

			} while (true);

		} while (true);
	}

	private static int getUserChoice(Scanner scanner, int maxOption) {
		int choice;
		do {
			System.out.print("Choose an option: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.next();
			}
			choice = scanner.nextInt();

			if (choice < 1 || choice > maxOption) {
				System.out.println("Not a valid option.Try again");
			}

		} while (choice < 1 || choice > maxOption);

		return choice;
	}

	@Override
	public void update(List<Product> shoppingCart) {

		// mam decis sa nu las nimic aici ca nu arata frumos in opinia mea
		// System.out.println("Shopping Cart Updated:");
//        displayCart(shoppingCart,shoppingCart, scanner);
	}

}