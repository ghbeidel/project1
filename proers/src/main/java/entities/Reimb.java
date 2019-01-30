package entities;

import org.hibernate.SessionFactory;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;


@Entity
@Table(name = "ERS_REIMBURSEMENTS")
public class Reimb {



    @Id
    @Column(name = "REIMBURSEMENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reimbId;

    public Reimb (){}
    public Reimb(Timestamp submitted, String description, float amount, Status statusId, Type typeId, User author) {
        this.submitted = submitted;
        this.description = description;
        this.amount = amount;
        this.statusId = statusId;
        this.typeId = typeId;
        this.author = author;
    }

    private java.sql.Timestamp submitted;
    private java.sql.Timestamp resolved;
    private String description;
    private java.sql.Blob reciept;


    private float amount;

    public int getReimbId() {
        return reimbId;
    }

    public void setReimbId(int reimbId) {
        this.reimbId = reimbId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Timestamp getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    public Timestamp getResolved() {
        return resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Blob getReciept() {
        return reciept;
    }

    public void setReciept(Blob receipt) {
        this.reciept = receipt;
    }

    public Type getTypeId() {
        return typeId;
    }

    public void setTypeId(Type typeId) {
        this.typeId = typeId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }




    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "STATUSID")
    private Status statusId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "TypeID")
    private Type typeId;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "AUTHOR")
    private User author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "RESOLVER")
    private User resolver;

    public User getResolver() {
        return resolver;
    }

    public void setResolver(User resolver) {
        this.resolver = resolver;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Reimb{" +
                "reimbId=" + reimbId +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", reciept=" + reciept +
                ", typeId=" + typeId +
                ", statusId=" + statusId +
                ", author=" + author +
                ", resolver=" + resolver +
                '}';
    }



}
