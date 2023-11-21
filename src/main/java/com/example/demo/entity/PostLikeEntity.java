package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "post_like",schema = "YNC",
        indexes = {@Index(name = "IDX_PL_LIKE_ID", columnList = "LIKE_ID"),
                @Index(name = "IDX_PL_POST_ID", columnList = "POST_ID")})
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostLikeEntity {
    @Id
    @Column(name = "post_id",unique = true)
    private Integer postId;

    @Column(name = "like_id",unique = true)
    private Integer likeId;
}
