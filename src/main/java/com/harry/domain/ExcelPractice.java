package com.harry.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "excel_practice")
@Entity
@Data
@EqualsAndHashCode(doNotUseGetters = true)
public class ExcelPractice implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id_", length = 32, nullable = false)
    private String id;

    @Column(name = "hospital_Id")
    private String hospitalId;

    @Column(name = "hospital_name")
    private String hospitalName;



}
