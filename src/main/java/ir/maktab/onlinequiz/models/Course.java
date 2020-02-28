package ir.maktab.onlinequiz.models;

import ir.maktab.onlinequiz.enums.CourseStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseCode;

    @ManyToOne
    private Lesson lesson;

    @ManyToOne
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    @Temporal(TemporalType.DATE)
    private Date startCourse;

    @Temporal(TemporalType.DATE)
    private Date endCourse;

    @Enumerated(EnumType.STRING)
    private CourseStatus courseStatus;
}
