package entities;

import javax.persistence.*;

@Entity
@Table(name = "ERS_USER")
public class User{

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(unique = true)
    private String userName;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "ROLE_ID")
    private Role roleId;

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Role getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(int roleId) {
//        this.roleId = roleId;
  //  }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", roleId=" +
                '}';
    }
}
