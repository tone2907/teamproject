package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;

@Table(name = "members", schema = "YNC",
        indexes = {@Index(name = "IDX_MEMBER_DELECT_STATUS", columnList = "DELECT_STATUS")})
@SequenceGenerator(name = "member_seq", sequenceName = "member_seq", schema = "YNC", allocationSize = 1)
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MembersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
    @Column(name = "member_id")
    private Long member;

    @Column(name = "password")
    private String password;

    @Column(name = "TEL", length = 14, unique = true)
    private String tel;

    @Column(name = "email", length = 320)
    private String email;

    @Column(name = "name", length = 60, unique = true)
    private String name;

    @Column(name = "delect_status")
    private Boolean delectStatus;

    @Column(name = "role")
    private Integer role;
}
