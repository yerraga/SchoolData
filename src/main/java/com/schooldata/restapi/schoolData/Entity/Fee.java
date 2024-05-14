package com.schooldata.restapi.schoolData.Entity;

import com.schooldata.restapi.schoolData.Enum.Standard;
import com.schooldata.restapi.schoolData.Enum.StudentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Fees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @NotNull(message = "Standard cannot be empty")
    @Enumerated(EnumType.STRING)
    @Column(name = "Standard")
    private Standard standard;
    @NotNull(message = "Student type cannot be empty")
    @Column (name = "`Student Type`")
    @Enumerated(EnumType.STRING)
    private StudentType studentType;
    @NotNull(message = "School fee cannot be empty")
    @Column (name = "`School Fee`")
    private int schoolFee;
    @NotNull(message = "Hostel fee cannot be empty")
    @Column (name = "`Hostel Fee`")
    private int hostelFee;
    @NotNull(message = "Uniform fee cannot be empty")
    @Column (name = "`Uniform Fee`")
    private int uniformFee;
    @NotNull(message = "Bus fee cannot be empty")
    @Column (name = "`Bus Fee`")
    private int busFee;
    @NotNull(message = "Examination fee cannot be empty")
    @Column (name = "`Examination fee`")
    private int examinationFee;
    @NotNull(message = "Tuition fee cannot be empty")
    @Column (name = "`Tuition fee`")
    private int tuitionFee;
    //@NotNull(message = "Total fee  for days scholar cannot be empty")
    @Column (name = "`Total Fee for Days Scholar`")
    private Long daysScholarFee;
    //@NotNull(message = "Total fee for hostler cannot be empty")
    @Column (name = "`Total Fee for Hostler`")
    private Long hostlerFee;

}
