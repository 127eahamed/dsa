import java.util.ArrayList;
import java.util.PriorityQueue;

public class TriageSystem_1_AEhan {
    private ArrayList<MedicalProfessional> medicalProfessionals = new ArrayList<MedicalProfessional>();
    private PriorityQueue<Patient> patients = new PriorityQueue<>(new Patient.PatientSorter());
    public void add_patient(String name, int priority) {
        patients.add(new Patient(name, priority));
        if (!patients.isEmpty()) {
            for (MedicalProfessional medicalProfessional : medicalProfessionals) {
                if (medicalProfessional.isAvailable()) {
                    medicalProfessional.setPatient(patients.poll());
                }
            }
        }
    }
    public void add_medical_professional(String name) {
        MedicalProfessional medicalProfessional = new MedicalProfessional(name);
        medicalProfessionals.add(medicalProfessional);
        if (!patients.isEmpty()) {
            medicalProfessional.setPatient(patients.poll());
        }
    }
    public void update_patient_status(String professional_name, int status) {
        for (MedicalProfessional medicalProfessional : medicalProfessionals) {
            if (professional_name.equals(medicalProfessional.getName())) {
                if (status != -1) {
                    add_patient(medicalProfessional.getPatient().getName(), status);
                }
                medicalProfessional.setPatient(null);
            }
        }
    }
    public void print_status() {
        System.out.println("Medical Professionals:");
        for (MedicalProfessional medicalProfessional : medicalProfessionals) {
            System.out.println(medicalProfessional);
        }
        System.out.println("Waiting Patients:");
        print_pq(patients);
    }
    public static void print_pq(PriorityQueue<?> pq) {
        PriorityQueue<?> copy = new PriorityQueue<>(pq); while(!copy.isEmpty()) {
            System.out.println(copy.poll()); }
    }
}
