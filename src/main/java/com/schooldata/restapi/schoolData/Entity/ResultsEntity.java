package com.schooldata.restapi.schoolData.Entity;

import com.schooldata.restapi.schoolData.Enum.Examinations;
import com.schooldata.restapi.schoolData.Enum.PassedOrFailed;
import com.schooldata.restapi.schoolData.Enum.Standard;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Results")
@Data
public class ResultsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "StudentId")
    private Long studentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "Standard")
    private Standard standard;

    @Column(name = "`Academic Year`")
    private String academicYear;

    @Column(name = "`Student Name`")
    private String studentName;

    @Enumerated(EnumType.STRING)
    @Column(name = "Examination")
    private Examinations examination;

    @Column(name = "Telugu")
    private double teluguMarks;

    @Column(name = "Hindi")
    private double hindiMarks;

    @Column(name = "English")
    private double englishMarks;

    @Column(name = "Mathematics")
    private double mathematicsMarks;

    @Column(name = "Science")
    private double scienceMarks;

    @Column(name = "`Physics and Chemistry`")
    private double physicsAndChemistryMarks;

    @Column(name = "Social")
    private double socialMarks;

    @Column(name = "`Total Marks`")
    private double totalMarks;

    @Enumerated(EnumType.STRING)
    @Column(name = "`Passed or Failed`")
    private PassedOrFailed passedOrFailed;

    @PostLoad
    @PostPersist
    @PostUpdate
    private void calculatePassedOrFailed() {
        if (examination == Examinations.UNITTEST_I || examination == Examinations.UNITTEST_II ||
                examination == Examinations.UNITTEST_III || examination == Examinations.UNITTEST_IV) {
            if (standard != Standard.TEN && standard != Standard.NINE && standard != Standard.EIGHT) {
                this.passedOrFailed = (teluguMarks < 15 || hindiMarks < 15 || englishMarks < 15 || mathematicsMarks < 15 ||
                        scienceMarks < 15 || socialMarks < 15) ? PassedOrFailed.F : PassedOrFailed.P;
            } else {
                this.passedOrFailed = (teluguMarks < 15 || hindiMarks < 15 || englishMarks < 15 || mathematicsMarks < 15 ||
                        physicsAndChemistryMarks < 15 || socialMarks < 15) ? PassedOrFailed.F : PassedOrFailed.P;
            }
        } else if (examination == Examinations.QUATERLY_EXAMINATIONS || examination == Examinations.HALF_YEARLY_EXAMINATIONS ||
                examination == Examinations.ANUAL_EXAMINATIONS) {
            if (standard != Standard.TEN && standard != Standard.NINE && standard != Standard.EIGHT) {
                this.passedOrFailed = (teluguMarks < 50 || hindiMarks < 50 || englishMarks < 50 || mathematicsMarks < 50 ||
                        scienceMarks < 50 || socialMarks < 50) ? PassedOrFailed.F : PassedOrFailed.P;
            } else {
                this.passedOrFailed = (teluguMarks < 50 || hindiMarks < 50 || englishMarks < 50 || mathematicsMarks < 50 ||
                        physicsAndChemistryMarks < 50 || socialMarks < 50) ? PassedOrFailed.F : PassedOrFailed.P;
            }
        } else {
            this.passedOrFailed = null;
        }
    }
}
