package per.nonobeam.phucnhse183026.lab05_01.domain;

public class User {
    private String username;
    private String fullname;
    private String email;

    public User(String email, String fullname, String username) {
        this.email = email;
        this.fullname = fullname;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
