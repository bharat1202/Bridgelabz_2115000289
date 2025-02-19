import java.util.*;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity); // Higher severity first
    }
}

public class HospitalTriage {
    public static List<String> getTreatmentOrder(List<Patient> patients) {
        PriorityQueue<Patient> pq = new PriorityQueue<>(patients);
        List<String> treatmentOrder = new ArrayList<>();
        while (!pq.isEmpty()) {
            treatmentOrder.add(pq.poll().name);
        }
        return treatmentOrder;
    }

    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
            new Patient("John", 3), 
            new Patient("Alice", 5), 
            new Patient("Bob", 2)
        );
        System.out.println("Treatment Order: " + getTreatmentOrder(patients));
    }
}
