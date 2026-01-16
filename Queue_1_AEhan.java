import java.util.Scanner;

public class Queue_1_AEhan {
    public static void main(String[] args) {
        Queue<String> people = new Queue<String>();
        Scanner scn = new Scanner(System.in);
        int count;
        while (true) {
            System.out.print("How many people are on line: ");
            if (scn.hasNextInt()) {
                count = scn.nextInt();
                if (count >= 0) {
                    scn.nextLine();
                    break;
                }
            }
            System.out.println("Enter a positive integer");
            scn.nextLine();
        }
        for (int i = 0; i < count; i++) {
            System.out.print("Please enter the next person who got onto the line: ");
            people.enqueue(scn.nextLine());
        }
        int carsPerCoaster;
        while (true) {
            System.out.print("How many cars on the coaster: ");
            if (scn.hasNextInt()) {
                carsPerCoaster = scn.nextInt();
                if (carsPerCoaster > 0) {
                    scn.nextLine();
                    break;
                }
            }
            System.out.println("Enter a positive integer greater than 0");
            scn.nextLine();
        }
        int seatsPerCar;
        while (true) {
            System.out.print("How many seats in each car: ");
            if (scn.hasNextInt()) {
                seatsPerCar = scn.nextInt();
                if (seatsPerCar > 0) {
                    scn.nextLine();
                    break;
                }
            }
            System.out.println("Enter a positive integer greater than 0");
            scn.nextLine();
        }
        int runs;
        while (true) {
            System.out.print("How many times should the coaster run: ");
            if (scn.hasNextInt()) {
                runs = scn.nextInt();
                if (runs > 0) {
                    scn.nextLine();
                    break;
                }
            }
            System.out.println("Enter a positive integer greater than 0");
            scn.nextLine();
        }
        for (int i = 0; i < runs; i++) {
            int peoplePerRun = carsPerCoaster * seatsPerCar;
            System.out.println();
            System.out.println("Run #" + (i - -1));
            for (int person = 0; person < peoplePerRun; person++) {
                if (people.isEmpty()) {
                    break;
                }
                System.out.println(people.dequeue());
            }
        }
    }
}
