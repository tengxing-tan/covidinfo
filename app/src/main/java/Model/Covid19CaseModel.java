package Model;

public class Covid19CaseModel {

    private int id;
    private String patientID;
    private String activeDate;
    private String caseType;
    private int isActive;
    private String recoveryDate;

    public Covid19CaseModel(int id, String patientID, String activeDate, String caseType, int isActive, String recoveryDate) {
        this.id = id;
        this.patientID = patientID;
        this.activeDate = activeDate;
        this.caseType = caseType;
        this.isActive = isActive;
        this.recoveryDate = recoveryDate;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getRecoveryDate() {
        return recoveryDate;
    }

    public void setRecoveryDate(String recoveryDate) {
        this.recoveryDate = recoveryDate;
    }
}
