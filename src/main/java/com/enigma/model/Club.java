package com.enigma.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clubs")
public class Club {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "club_id")
    private String clubId;

    @Column(name = "club_name")
    private String clubName;

    @ManyToMany(mappedBy = "clubs")
    private List<Student> students = new ArrayList<>();

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Club{" +
                "clubId='" + clubId + '\'' +
                ", clubName='" + clubName + '\'' +
                //", students=" + students +
                '}';
    }
}
