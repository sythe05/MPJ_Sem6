import java.io.*;
import java.util.*;

class InvalidCustomerIdException extends Exception {
    public InvalidCustomerIdException(String msg) {
        super(msg);
    }
}

class MinimumBalanceException extends Exception {
    public MinimumBalanceException(String msg) {
        super(msg);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String msg) {
        super(msg);
    }
}

class Customer {
    int cid;
    String cname;
    double amount;

    Customer(int cid, String cname, double amount) {
        this.cid = cid;
        this.cname = cname;
        this.amount = amount;
    }

    public String toString() {
        return cid + "," + cname + "," + amount;
    }
}

public class BankingSystem {
    static final String FILE_NAME = "customers.txt";
    static Scanner sc = new Scanner(System.in);

    public static void createAccount() {
        try {
            System.out.print("Enter Customer ID (1 to 20): ");
            int cid = sc.nextInt();
            sc.nextLine();

            if (cid < 1 || cid > 20) {
                throw new InvalidCustomerIdException("Customer ID should be between 1 and 20.");
            }

            System.out.print("Enter Customer Name: ");
            String cname = sc.nextLine();

            System.out.print("Enter Initial Amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                throw new InvalidAmountException("Amount should be positive.");
            }

            if (amount < 1000) {
                throw new MinimumBalanceException("Account should be created with minimum Rs. 1000.");
            }

            Customer c = new Customer(cid, cname, amount);

            FileWriter fw = new FileWriter(FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(c.toString());
            bw.newLine();
            bw.close();

            System.out.println("Account created successfully and stored in file.");

        } catch (InvalidCustomerIdException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (InvalidAmountException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (MinimumBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type.");
            sc.nextLine();
        }
    }

    public static void withdrawAmount() {
        try {
            System.out.print("Enter Customer ID: ");
            int searchId = sc.nextInt();

            System.out.print("Enter Withdrawal Amount: ");
            double wth_amt = sc.nextDouble();

            if (wth_amt <= 0) {
                throw new InvalidAmountException("Entered amount should be positive.");
            }

            File file = new File(FILE_NAME);

            if (!file.exists()) {
                System.out.println("No customer records found.");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            ArrayList<String> records = new ArrayList<String>();
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int cid = Integer.parseInt(data[0]);
                String cname = data[1];
                double amount = Double.parseDouble(data[2]);

                if (cid == searchId) {
                    found = true;

                    if (wth_amt > amount) {
                        br.close();
                        throw new InsufficientFundsException("Withdrawal amount is greater than total balance.");
                    }

                    amount = amount - wth_amt;
                    records.add(cid + "," + cname + "," + amount);
                } else {
                    records.add(line);
                }
            }
            br.close();

            if (!found) {
                System.out.println("Customer ID not found.");
                return;
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
            for (String rec : records) {
                bw.write(rec);
                bw.newLine();
            }
            bw.close();

            System.out.println("Withdrawal successful. Record updated in file.");

        } catch (InvalidAmountException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type.");
            sc.nextLine();
        }
    }

    public static void displayCustomers() {
        try {
            File file = new File(FILE_NAME);

            if (!file.exists()) {
                System.out.println("No customer records found.");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            System.out.println("\nCustomer Records:");
            System.out.println("CID\tName\t\tAmount");
            System.out.println("--------------------------------");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println(data[0] + "\t" + data[1] + "\t\t" + data[2]);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Banking System Menu =====");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Display Customers");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        withdrawAmount();
                        break;
                    case 3:
                        displayCustomers();
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1 to 4.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric choice.");
                sc.nextLine();
                choice = 0;
            }

        } while (choice != 4);

        sc.close();
    }
}