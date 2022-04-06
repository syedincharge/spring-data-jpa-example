package com.rizvi.spring.entity;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "Please Add Department Name")
/*    @Length(max = 5, min = 1)
    @Size(max = 10, min = 0 )
    @Email
    @Positive
    @Negative
    @PositiveOrZero
    @Future
    @FutureOrPresent
    @PastOrPresent*/
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;



}
