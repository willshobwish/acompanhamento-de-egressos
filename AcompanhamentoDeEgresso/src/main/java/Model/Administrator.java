package Model;

public class Administrator extends User {

    public Administrator() {
        super("admin", "admin");
        this.updatePassword("admin");
    }
}
