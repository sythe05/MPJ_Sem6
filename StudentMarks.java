import java.util.Scanner;

public class StudentMarks {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] name = new String[10];
        int[] sub1 = new int[10];
        int[] sub2 = new int[10];
        char[] grade = new char[10];

        int totalSub1 = 0, totalSub2 = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Name: ");
            name[i] = sc.nextLine();

            System.out.print("Subject 1 Marks: ");
            sub1[i] = sc.nextInt();

            System.out.print("Subject 2 Marks: ");
            sub2[i] = sc.nextInt();
            sc.nextLine();

            totalSub1 += sub1[i];
            totalSub2 += sub2[i];

            int avg = (sub1[i] + sub2[i]) / 2;

            if (avg >= 90)
                grade[i] = 'A';
            else if (avg >= 70)
                grade[i] = 'B';
            else if (avg >= 60)
                grade[i] = 'C';
            else if (avg >= 40)
                grade[i] = 'D';
            else
                grade[i] = 'F';
        }

        System.out.println("\n----- Student Details -----");
        for (int i = 0; i < 10; i++) {
            System.out.println("\nStudent " + (i + 1));
            System.out.println("Name: " + name[i]);
            System.out.println("Subject 1 Marks: " + sub1[i]);
            System.out.println("Subject 2 Marks: " + sub2[i]);
            System.out.println("Grade: " + grade[i]);
        }

        System.out.println("\n----- Subject Summary -----");
        System.out.println("Total Subject 1 Marks: " + totalSub1);
        System.out.println("Average Subject 1 Marks: " + (totalSub1 / 10.0));

        System.out.println("Total Subject 2 Marks: " + totalSub2);
        System.out.println("Average Subject 2 Marks: " + (totalSub2 / 10.0));

        sc.close();
    }
}
