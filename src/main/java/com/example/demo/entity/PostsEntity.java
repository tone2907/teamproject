package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "posts", schema = "YNC",
        indexes = {@Index(name = "IDX_POSTS_DELECT_STATUS", columnList = "DELECT_STATUS"),
                @Index(name = "IDX_POSTS_MEMBER_ID", columnList = "MEMBER_ID"),
                @Index(name = "IDX_POSTS_POST_TYPE",columnList = "POST_TYPE"),
                @Index(name = "IDX_POST_REPORT_STATUS",columnList = "REPORT_STATUS"),
                @Index(name = "IDX_POSTS_VIEWS_COUNT",columnList = "VIEWS_COUNT")})
@SequenceGenerator(name = "post_seq", sequenceName = "post_seq", schema = "YNC", allocationSize = 1)
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "post_seq")
    @Column(name = "post_id")
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MembersEntity member;

    @Column(name = "post_type")
    private Integer postType;

    @Column(name = "title", length = 60, unique = true)
    private String title;

    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "image")
    private String image;

    @Column(name = "views_count")
    private Integer viewCount;

    @Column(name = "delect_status")
    private Boolean delectStatus;

    @Column(name = "report_status")
    private Boolean reportStatus;

    @OneToMany(mappedBy = "postsEntity", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("comment asc")
    private List<CommentsEntity> comments;
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}

