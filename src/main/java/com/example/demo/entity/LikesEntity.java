package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "likes",schema = "YNC",
        indexes ={@Index(name = "IDX_LIKES_CREATE_DATE", columnList = "MEMBER_ID"),
                @Index(name = "IND_LIKES_MEMBER_ID", columnList = "MEMBER_ID")})
@SequenceGenerator(name = "like_seq", sequenceName = "like_seq", schema = "YNC", allocationSize = 1)
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LikesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "like_seq")
    @Column(name = "like_id")
    private Long likeId;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "create_date")
    private LocalDateTime createDate;
}
