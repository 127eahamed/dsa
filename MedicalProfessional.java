public class MedicalProfessional {
    private Patient patient;
    private final String name;

    public MedicalProfessional(String name) {
        this.name = name;
        this.patient = null;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAvailable() {
        return this.patient == null;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    public String toString() {
        String result = this.name + " treating ";
        if(this.patient == null) result += "noone";
        else result += this.patient.toString();
        return result;
    }


}