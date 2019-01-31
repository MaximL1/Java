package md.codefactory.html.gramada;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class User {

    private @Id @GeneratedValue Long id;
    private String name;
    private String role;

    public User() {
    }

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
