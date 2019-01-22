package entities;

import javax.persistence.*;

@Entity
@Table(name= "ERS_REIMBURSEMENT_TYPE")
public class Type {

    @Id
    @Column(name = "TYPEID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeId;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {

        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", type='" + type + '\'' +
                '}';
    }

    private String type;
}
