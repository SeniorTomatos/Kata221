package hiber.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
public class User {

    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ToString.Include
    @Column(name = "name")
    private String firstName;

    @ToString.Include
    @Column(name = "last_name")
    private String lastName;

    @ToString.Include
    @Column(name = "email")
    private String email;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cars_id")
    private Car userCar;

    public User(String firstName, String lastName, String email, Car userCar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userCar = userCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(userCar, user.userCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, userCar);
    }

}
