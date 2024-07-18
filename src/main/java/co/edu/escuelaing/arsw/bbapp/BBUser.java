package co.edu.escuelaing.arsw.bbapp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class BBUser {
    @Id
    public String name;

    public String pass;

    public BBUser() {
    }

    public BBUser(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "BBUser [name=" + name + ", pass=" + pass + "]";
    }

}
