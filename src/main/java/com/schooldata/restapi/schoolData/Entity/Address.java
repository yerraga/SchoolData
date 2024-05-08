package com.schooldata.restapi.schoolData.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Address")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Address extends StudentEntity{

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "Admission_Number", referencedColumnName = "Admission_Number")
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;

	private Long pincode;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Admission_Number") // Use Admission_Number as foreign key
	private StudentEntity student;


}
