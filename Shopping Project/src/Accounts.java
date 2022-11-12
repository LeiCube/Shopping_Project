import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Accounts {
	public static ArrayList<String> UsernameArr = new ArrayList<>();
	public static ArrayList<String> PassWordArr = new ArrayList<>();
	public static ArrayList<String> TypeArr = new ArrayList<>();

	public static void createAccount() {
		System.out.println("Creating an account: ");

		String usernameString = UsernameChecker();

		String passwordString = PasswordChecker();

		String typeString = TypeChecker();

		UsernameArr.add(usernameString);
		PassWordArr.add(passwordString);
		TypeArr.add(typeString);//
		System.out.println("Creating account.... Done!");
		MainProject.Homepage();
	}

	public static String UsernameChecker() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Username: ");
		String username = scan.next();

		for (int i = 0; i < UsernameArr.size(); i++) {
			if (username.equals(UsernameArr.get(i))) {
				System.out.println("Username already used.");
				System.out.println("Account declined: Please try again");
				MainProject.Homepage();
			}
		}
		return username;
	}

	public static String PasswordChecker() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Password: ");
		String password = scan.next();

		if (password.length() < 5) {
			System.out.println("Password too weak.");
			System.out.println("Please don't use any spaces on your password");
			System.out.println("Account declined: Please try again");
			MainProject.Homepage();
		}
		return password;

	}

	public static String TypeChecker() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Type [admin / consumer]: ");
		String type = scan.next().toLowerCase();

		if (type.equals("admin") || (type.equals("consumer"))) {
		} else {
			System.out.println("admin or consumer only");
			createAccount();
		}

		return type;
	}

	public static void LogIn() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Account...");

		System.out.print("Username: ");
		String inUser = scan.next();

		int Counter = 0;
		int index = 0;
		for (int i = 0; i < UsernameArr.size(); i++) {
			if (inUser.equals(UsernameArr.get(i))) {
				Counter++;
				index = i;
				break;
			}
		}
		if (Counter == 0) {
			System.out.println("Account doesn't exist");
			MainProject.Homepage();
		}
		String LAUsername = UsernameArr.get(index);
		String LAPassword = PassWordArr.get(index);
		String LAType = TypeArr.get(index);

		Password(LAPassword);
		if (LAType.equals("admin")) {
			System.out.println("Welcome admin " + LAUsername + "...");
			MainProject.AdminPage();
		} else if (LAType.equals("consumer")) {
			System.out.println("Welcome consumer " + LAUsername + "...");
			MainProject.ConsumerPage();
		}
	}

	public static String Password(String LAPassword) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Password: ");
		String inPassword = scan.next();

		if (!Objects.equals(inPassword, LAPassword)) {
			System.out.println("Wrong password.");
			Password(LAPassword);
		}

		return inPassword;
	}

}
