import java.text.DecimalFormat;
import java.util.Scanner;

public class BuyPage {

	static void buy(int choice) {
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		try {
			int index = choice - 1;// 0
			System.out.print("Quantity: ");
			int qty = scan.nextInt();

			if (qty <= Items.QtyArr.get(index)) {

				try {
					double price = Items.PriceArr.get(index) * qty;
					System.out.println("Total Price: P" + df.format(price));
					System.out.print("Money: ");
					int amount = scan.nextInt();

					if (amount > price) {
						int NewQty = (Items.QtyArr.get(index)) - qty;
						Items.QtyArr.set(index, NewQty);
						double change = amount - price;
						System.out.println("Successful, your change is P" + df.format(change));
						System.out.println("Would you want to buy again?");

						MainProject.ConsPnameArr.add(Items.PnameArr.get(index));
						MainProject.ConsPriceArr.add(Items.PriceArr.get(index));
						MainProject.ConsQtyArr.add(qty);
						MainProject.ConsAmountArr.add(amount);
						MainProject.ConsumerPage();
					} else if (amount == price) {
						int NewQty = Items.QtyArr.get(index) - qty;
						Items.QtyArr.set(index, NewQty);
						System.out.println("Successful, Exact amount received!");
						System.out.println("Would you want to buy again?");

						MainProject.ConsPnameArr.add(Items.PnameArr.get(index));
						MainProject.ConsPriceArr.add(Items.PriceArr.get(index));
						MainProject.ConsQtyArr.add(qty);
						MainProject.ConsAmountArr.add(amount);
						MainProject.ConsumerPage();
					} else {
						System.out.println("Unsuccessful, Not enough Money...");
						MainProject.ConsumerPage();
					}
				} catch (Exception e) {
					System.out.println("[ERROR] Please input a number only");
					MainProject.ConsumerPage();
				}
			} else {
				System.out.println(Items.QtyArr.get(index) + " Items remaining in " + Items.PnameArr.get(choice - 1));
				MainProject.ConsumerPage();
			}
		} catch (Exception e) {
			System.out.println("[ERROR] Please input a number only");
			MainProject.ConsumerPage();
		}

	}

}
