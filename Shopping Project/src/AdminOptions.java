import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AdminOptions {

	public static void Maintenance() {
		Scanner scan = new Scanner(System.in);
		System.out.println("[1] Display");
		System.out.println("[2] Add");
		System.out.println("[3] Edit");
		System.out.println("[4] Delete");
		System.out.println("[5] To Exit...");
		System.out.println("What do you want to do? ");
		String choice = scan.next();

		if (choice.equals("1")) {
			Items.DisplayItems();
		} else if (choice.equals("2")) {
			Items.AddItems();
		} else if (choice.equals("3")) {
			Items.EditItems();
		} else if (choice.equals("4")) {
			Items.DeleteItems();
		} else if (choice.equals("5")) {
			MainProject.AdminPage();
		} else {
			System.out.println("[ERROR]\nPlease Choose again...");
			Maintenance();
		}
		scan.close();
	}

	public static void DisplayTrans() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Date\t\tProduct Name\t\tPrice\t\tQty\tConsumer Payment\n");
		DecimalFormat df = new DecimalFormat("0.00");

		Date date = new Date();
		SimpleDateFormat dateform = new SimpleDateFormat("MM/dd/yyyy");
		String time = dateform.format(date);

		if (MainProject.ConsPnameArr.isEmpty()) {
			System.out.println("No Transactions yet...");
		} else {
			for (int i = 0; i < MainProject.ConsPnameArr.size(); i++) {
				System.out.println(time + "\t" + MainProject.ConsPnameArr.get(i) + "\t\tP"
						+ df.format(MainProject.ConsPriceArr.get(i)) + "\t\t" + MainProject.ConsQtyArr.get(i) + "\t"
						+ MainProject.ConsAmountArr.get(i));
			}
		}

		System.out.println("[1] To Exit...");
		String choice = scan.next();

		if (choice.equals("1")) {
			MainProject.AdminPage();
		} else {
			AdminOptions.DisplayTrans();
		}

	}

}
