package htwberlin.HTWSportPlanner;

public class ScraperEntry {

    private String titel;
    private String tag;
    private String ort;
    private String zeit;
    private String zeitraum;
    private String leitung;
    private String beschreibung;

    public ScraperEntry() {
    }

    public ScraperEntry(String titel, String tag, String ort, String zeit, String zeitraum, String leitung, String beschreibung) {
        this.titel = titel;
        this.tag = tag;
        this.ort = ort;
        this.zeit = zeit;
        this.zeitraum = zeitraum;
        this.leitung = leitung;
        this.beschreibung = beschreibung;
    }

    public String getTitel() {
        return titel;
    }

    public String getTag() {
        return tag;
    }

    public String getOrt() {
        return ort;
    }

    public String getZeit() {
        return zeit;
    }

    public String getZeitraum() {
        return zeitraum;
    }

    public String getLeitung() {
        return leitung;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setZeit(String zeit) {
        this.zeit = zeit;
    }

    public void setZeitraum(String zeitraum) {
        this.zeitraum = zeitraum;
    }

    public void setLeitung(String leitung) {
        this.leitung = leitung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
