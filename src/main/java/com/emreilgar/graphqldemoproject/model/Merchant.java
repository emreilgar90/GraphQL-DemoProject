package com.emreilgar.graphqldemoproject.model;

import com.emreilgar.graphqldemoproject.model.enums.CompanyType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="merchants")
public class Merchant extends BaseEntity{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME",nullable = false,length = 50)
    private String name;

    @Column(name = "SURNAME", nullable = false,length = 50)
    private String surname;

    @Column(name = "TAX_NUMBER", nullable = false,length = 100)
    private String taxNumber;

    @Column(name = "IDENTITY_NUMBER", nullable = false,length = 11)
    private String identityNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "COMPANY_TYPE", nullable = false,length = 50)
    private CompanyType companyType;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)// ilgili ilişkide ki tabloya da değişikliği yansıt
    private List<Contact> contacts;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="ADDRESS_ID",referencedColumnName = "ID",nullable = false)
    private Address address;

}
