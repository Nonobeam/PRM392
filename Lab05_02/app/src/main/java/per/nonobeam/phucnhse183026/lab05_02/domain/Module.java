package per.nonobeam.phucnhse183026.lab05_02.domain;

public class Module {
    private int image;
    private String summary;
    private String os;

    public Module(int image, String summary, String os) {
        this.image = image;
        this.summary = summary;
        this.os = os;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
