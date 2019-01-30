package entities;

import javax.persistence.*;

@Entity
@Table(name = "ERS_USER_ROLES")
public class Role {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")

    private int roleId;

    public int getRoleId() {

        return roleId;
    }

    public void setRoleId(int roleId) {

        this.roleId = roleId;
    }

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {

        this.role = role;
    }


    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", role='" + role + '\'' +
                '}';
    }
}
