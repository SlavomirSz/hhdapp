public class Subscriber {

    private int id;
    private String fisrtName;
    private String lastName;
    private String email;
    private boolean status;

    public Subscriber(){    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
