package model;

import java.util.Date;

public class Programare {
    private int doctorId;
    private int patientId;
    private Date programDate;

    public Programare(int doctorId, int patientId, Date programDate) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.programDate = programDate;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Date getProgramDate() {
        return programDate;
    }

    public void setProgramDate(Date programDate) {
        this.programDate = programDate;
    }
}
