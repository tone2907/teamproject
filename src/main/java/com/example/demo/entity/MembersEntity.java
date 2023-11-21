package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;

@Table(name = "members", schema = "YNC",
        indexes = {@Index(name = "IDX_MEMBER_ADMIN_STATUS", columnList = "ADMIN_STATUS"),
                @Index(name = "IDX_MEMBER_DELECT_STATUS", columnList = "DELECT_STATUS")})
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
    private Long memberId;

    @Column(name = "reg_id", length = 10, unique = true)
    private String regId;

    @Column(name = "pw")
    private String pw;

    @Column(name = "TEL", length = 14, unique = true)
    private String tel;

    @Column(name = "email", length = 320)
    private String email;

    @Column(name = "nickname", length = 60, unique = true)
    private String nickname;

    @Column(name = "delect_status")
    private Integer delectStatus;

    @Column(name = "admin_status")
    private Integer adminStatus;
}
