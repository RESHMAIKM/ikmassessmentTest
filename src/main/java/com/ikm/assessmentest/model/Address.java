package com.ikm.assessmentest.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@Table(name="employee_address")
public class Address {

    @Id
    @Column(name="addressid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int addressid;

    @NotEmpty
    @Column(name="housename")
    String housename;

    @Column(name="place")
    String place;

    @NotBlank
    @Column(name="pincode")
    String pincode;

    @OneToOne
    @JoinColumn(name = "empid")
    private Employee employee;

    

}
