package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "comments", schema = "YNC",
        indexes = {@Index(name = "IDX_COMMENTS_DELECT_STATUS",columnList = "DELECT_STATUS"),
                @Index(name = "IDX_COMMENTS_MEMBER_ID", columnList = "MEMBER_ID"),
                @Index(name = "IDX_COMMENTS_POST_ID", columnList = "POST_ID"),
                @Index(name = "IDX_COMMENTS_REPORT_STATUS", columnList = "REPORT_STATUS")})
@SequenceGenerator(name = "comment_seq", sequenceName = "comment_seq", schema = "YNC", allocationSize = 1)
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "comment_seq")
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "member_id")
    private Integer member;

    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "delect_status")
    private Integer delectStatus;

    @Column(name = "report_status")
    private Integer reportStatus;
}
