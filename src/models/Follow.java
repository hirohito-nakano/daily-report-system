package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "followsreports")
@NamedQueries({
    @NamedQuery(
            name = "getAllFollowsReports",
            query = "SELECT r FROM Follow AS r ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getFollowsReportsCount",
            query = "SELECT COUNT(r) FROM Follow AS r"
            ),
    @NamedQuery(
            name = "getMyAllFollowsReports",
            query = "SELECT r FROM Follow AS r WHERE r.employee = :employee ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getMyFollowsReportsCount",
            query = "SELECT COUNT(r) FROM Follow AS r WHERE r.employee = :employee"
            )
})
@Entity
public class Follow {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @JoinColumn(name = "follow_id", nullable = false)
    private Employee follow_employee;

//    @Column(name = "report_date", nullable = false)
//    private Date report_date;

//    @Column(name = "title", length = 255, nullable = false)
//    private String title;

//    @Lob
//    @Column(name = "content", nullable = false)
//    private String content;

    public Employee getFollow_employee() {
        return follow_employee;
    }

    public void setFollow_employee(Employee follow_employee) {
        this.follow_employee = follow_employee;
    }

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

//    public Date getReport_date() {
//        return report_date;
//    }
//
//    public void setReport_date(Date report_date) {
//        this.report_date = report_date;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}