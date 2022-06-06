package Model;

public class Covid19InfoModel {
    // variables
    private int id;
    private String covid19InfoTitle;
    private String covid19InfoDate;
    private String covid19InfoContent;

    // Constructor
    public Covid19InfoModel(int id, String title, String date, String content) {
        this.id = id;
        this.covid19InfoTitle = title;
        this.covid19InfoDate = date;
        this.covid19InfoContent = content;
    }

    public String getCovid19InfoTitle() {
        return covid19InfoTitle;
    }

    public void setCovid19InfoTitle(String covid19InfoTitle) {
        this.covid19InfoTitle = covid19InfoTitle;
    }

    public String getCovid19InfoDate() {
        return covid19InfoDate;
    }

    public void setCovid19InfoDate(String covid19InfoDate) {
        this.covid19InfoDate = covid19InfoDate;
    }

    public String getCovid19InfoContent() {
        return covid19InfoContent;
    }

    public void setCovid19InfoContent(String covid19InfoContent) {
        this.covid19InfoContent = covid19InfoContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
