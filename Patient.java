import java.util.Comparator;

public class Patient implements Comparable<Patient> {

    public static class PatientSorter implements Comparator<Patient> {

        public int compare(Patient one, Patient two) {
            return (-1)*one.compareTo(two);
        }
    }
    private int priority;
    private final String name;

    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Patient o) {
        return this.getPriority() - o.getPriority();
    }


    public String toString() {
        return name + " with a priority level of " + priority;
    }
}