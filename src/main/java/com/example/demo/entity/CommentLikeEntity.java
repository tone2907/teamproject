package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "comment_like",schema = "YNC",
        indexes = {@Index(name = "IDX_CL_COMMENT_ID",columnList = "COMMENT_ID"),
                @Index(name = "IDX_CL_LIKE_ID", columnList = "LIKE_ID")})
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentLikeEntity {
    @Id
    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "like_id")
    private Integer likeId;
}
