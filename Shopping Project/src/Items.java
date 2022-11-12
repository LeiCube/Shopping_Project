import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Items {

	public static ArrayList<String> PnameArr = new ArrayList<>();
	public static ArrayList<String> DescArr = new ArrayList<>();
	public static ArrayList<Double> PriceArr = new ArrayList<>();
	public static ArrayList<Integer> QtyArr = new ArrayList<>();

	public static void DisplayItems() {
		DecimalFormat df = new DecimalFormat("0.00");
		if (PnameArr.isEmpty()) {
			System.out.println("---------------------------------------------------------");
			System.out.println("No Available Products Yet...");
			System.out.println("---------------------------------------------------------");
		} else {
			System.out.println("Available products are the following...");
			System.out.println("---------------------------------------------------------");
			for (int i = 0; i < PnameArr.size(); i++) {
				System.out.println("[" + (i + 1) + "] " + PnameArr.get(i) + " - " + DescArr.get(i) + " - P"
						+ df.format(PriceArr.get(i)) + " - " + QtyArr.get(i) + " Item/s");
			}
			System.out.println("---------------------------------------------------------");
		}

		AdminOptions.Maintenance();
	}

	public static void AddItems() {
		System.out.println("Adding products...");
		Scanner scan = new Scanner(System.in);
		String InPname;
		String InDesc;
		double InPrice;
		int InQty;

		try {
			System.out.println("Product name: ");
			InPname = scan.nextLine();
			System.out.println("Description: ");
			InDesc = scan.nextLine();
			System.out.println("Price: ");
			InPrice = scan.nextDouble();
			System.out.println("Quantity: ");
			InQty = scan.nextInt();
			PnameArr.add(InPname);
			DescArr.add(InDesc);
			PriceArr.add(InPrice);
			QtyArr.add(InQty);
			AdminOptions.Maintenance();
		} catch (Exception e) {
			System.out.println("[ERROR] Please input a number only");
			AdminOptions.Maintenance();
		}

		AdminOptions.Maintenance();
	}

	public static void EditItems() {
		System.out.println("Editing products...");
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("---------------------------------------------------------");
		System.out.println("Product List:");
		for (int i = 0; i < PnameArr.size(); i++) {
			System.out.println("[" + (i + 1) + "] " + PnameArr.get(i) + " - " + DescArr.get(i) + " - P"
					+ df.format(PriceArr.get(i)) + " - " + QtyArr.get(i) + " Item/s");
		}
		System.out.println("---------------------------------------------------------");

		System.out.print("What do you want to edit? ");
		try {
			int choice = scan.nextInt(); // 1
			if (choice <= PnameArr.size()) {
				System.out.println("[1] Product Name");
				System.out.println("[2] Description");
				System.out.println("[3] Price");
				System.out.println("[4] Quantity");
				System.out.println("[5] To Exit...");

				System.out.print("What to Change? ");
				String choice2 = scan.next(); // 1

				if (choice2.equals("1")) {
					System.out.println("OLD Product Name: " + PnameArr.get(choice - 1));
					System.out.print("Input NEW Product Name: ");
					String NewPname = scan2.nextLine();

					PnameArr.set(choice - 1, NewPname);
					AdminOptions.Maintenance();
				} else if (choice2.equals("2")) {
					System.out.println("OLD Description: " + DescArr.get(choice - 1));
					System.out.print("Input NEW Description: ");
					String NewDesc = scan2.nextLine();

					DescArr.set(choice - 1, NewDesc);
					AdminOptions.Maintenance();
				} else if (choice2.equals("3")) {
					System.out.println("OLD Price: " + PriceArr.get(choice - 1));
					System.out.print("Input NEW Price: ");
					double NewPrice = scan2.nextDouble();

					PriceArr.set(choice - 1, NewPrice);
					AdminOptions.Maintenance();
				} else if (choice2.equals("4")) {
					System.out.println("OLD Quantity: " + QtyArr.get(choice - 1));
					System.out.print("Input NEW Quantity: ");
					int NewQty = scan2.nextInt();

					QtyArr.set(choice - 1, NewQty);
					AdminOptions.Maintenance();
				} else if (choice2.equals("5")) {
					AdminOptions.Maintenance();
				} else {
					System.out.println("[ERROR] Choose 1 - 5 only");
					EditItems();
				}
			} else {
				System.out.println("Not in the Product list");
				AdminOptions.Maintenance();
			}
		} catch (Exception e) {
			System.out.println("[ERROR] Please input a number only");
			AdminOptions.Maintenance();
		}
	}

	public static void DeleteItems() {
		System.out.println("Deleting products...");
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("-------------------------------");
		for (int i = 0; i < PnameArr.size(); i++) {
			System.out.println("[" + (i + 1) + "] " + PnameArr.get(i) + " - " + DescArr.get(i) + " - P"
					+ df.format(PriceArr.get(i)) + " - " + QtyArr.get(i) + " Item/s");
		}
		System.out.println("-------------------------------");

		System.out.print("What do you want to delete? ");
		try {
			int Choice = scan.nextInt();

			if (Choice <= PnameArr.size()) {
				PnameArr.remove(Choice - 1);
				DescArr.remove(Choice - 1);
				PriceArr.remove(Choice - 1);
				QtyArr.remove(Choice - 1);
				System.out.println("Product Deleted...");
			} else {
				System.out.println("Not in the Product List");
			}
			AdminOptions.Maintenance();
		} catch (Exception e) {
			System.out.println("[ERROR] Please input a number only");
			AdminOptions.Maintenance();
		}
	}

	public static void DisplayItemsConsumer() {
		DecimalFormat df = new DecimalFormat("0.00");
		if (PnameArr.isEmpty()) {
			System.out.println("---------------------------------------------------------");
			System.out.println("No Available Products Yet...");
			System.out.println("---------------------------------------------------------");
		} else {
			System.out.println("Available products are the following...");
			System.out.println("---------------------------------------------------------");
			for (int i = 0; i < PnameArr.size(); i++) {
				System.out.println("[" + (i + 1) + "] " + PnameArr.get(i) + " - " + DescArr.get(i) + " - P"
						+ df.format(PriceArr.get(i)) + " - " + QtyArr.get(i) + " Item/s");
			}

		}
	}

}
