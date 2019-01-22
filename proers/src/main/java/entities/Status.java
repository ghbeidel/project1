package entities;

import javax.persistence.*;

@Entity
@Table(name = "ERS_REIMBURSEMENT_STATUS")
public class Status {

    @Id
    @Column(name = "StatusId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", status='" + status + '\'' +
                '}';
    }

    private String status;

}
