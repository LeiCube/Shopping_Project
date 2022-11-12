import java.util.ArrayList;
import java.util.Scanner;

public class MainProject {

	public static ArrayList<String> ConsPnameArr = new ArrayList<String>();
	public static ArrayList<Double> ConsPriceArr = new ArrayList<Double>();
	public static ArrayList<Integer> ConsQtyArr = new ArrayList<Integer>();
	public static ArrayList<Integer> ConsAmountArr = new ArrayList<Integer>();

	public static void main(String[] args) {
		Homepage();
	}

	public static void Homepage() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------------");
		System.out.println("Running system....");
		System.out.println("[1] Create an account");
		System.out.println("[2] Log-in");
		System.out.println("-------------------------------");
		String choice = scan.next();

		if (choice.equals("1")) {
			Accounts.createAccount();
		} else if (choice.equals("2")) {
			Accounts.LogIn();
		} else {
			System.out.println("[ERROR] Choose 1 or 2 only");
			Homepage();
		}

	}

	public static void AdminPage() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------------");
		System.out.println("[1] Maintenance");
		System.out.println("[2] Display Transactions");
		System.out.println("[3] To Exit...");
		System.out.println("-------------------------------");
		String choice = scan.next();

		if (choice.equals("1")) {
			AdminOptions.Maintenance();
		} else if (choice.equals("2")) {
			AdminOptions.DisplayTrans();
		} else if (choice.equals("3")) {
			Homepage();
		} else {
			System.out.println("Choose 1 - 3 only");
			AdminPage();
		}

	}

	public static void ConsumerPage() {
		Scanner scan = new Scanner(System.in);
		Items.DisplayItemsConsumer();

		int size = Items.PnameArr.size() + 1;
		System.out.println("[" + (size) + "]" + " To Exit...");
		System.out.println("---------------------------------------------------------");
		System.out.print("Do you want to purchase something? ");
		try {
			int choice = scan.nextInt();

			if (choice < size && choice > 0) {
				BuyPage.buy(choice);
			} else if (choice == size) {
				Homepage();
			} else if (choice > size || choice <= 0) {
				System.out.println("Choose from 1 - " + size + " only...");
				ConsumerPage();
			}
		} catch (Exception e) {
			System.out.println("[ERROR] Choose from 1 - " + size + " only...");
			ConsumerPage();
		}

	}

}
