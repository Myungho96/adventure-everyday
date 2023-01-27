package com.ssafy.antenna.domain.adventure;

import com.ssafy.antenna.domain.Base;
import com.ssafy.antenna.domain.category.Category;
import com.ssafy.antenna.domain.like.AdventureLike;
import com.ssafy.antenna.domain.post.CheckpointPost;
import com.ssafy.antenna.domain.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
public class Adventure extends Base {
    @Id @GeneratedValue
    private Long adventureId;
    // Req로 받는 것들.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;
    @Column(columnDefinition = "varchar(255) not null")
    private String feat;
    @Column(columnDefinition = "varchar(255) not null")
    private String title;
    @Column(columnDefinition = "varchar(255) default null")
    private String content;
    @Column(columnDefinition = "int not null")
    private int difficulty;
    @Lob
    @Column(columnDefinition = "blob default null")
    private byte[] photo;
    @Column(columnDefinition = "int default 6")
    private int validDate;

    // 따로 넣어줄 것들.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;
    @Column(columnDefinition = "double default 0")
    private String avgReviewRate;
    @Column(columnDefinition = "datetime(6) default null")
    private LocalDateTime endDate;

    // 양방향.
    @OneToMany(mappedBy = "adventure", cascade = CascadeType.ALL)
    private List<AdventureInProgress> adventuresInProgress;
    @OneToMany(mappedBy = "adventure", cascade = CascadeType.ALL)
    private List<AdventurePlace> adventurePlaces = new ArrayList<>();
    @OneToMany(mappedBy = "adventure", cascade = CascadeType.ALL)
    private List<AdventureLike> adventureLikes = new ArrayList<>();
    @OneToMany(mappedBy = "adventure", cascade = CascadeType.ALL)
    private List<AdventureReview> adventureReviews = new ArrayList<>();
    @OneToMany(mappedBy = "adventure", cascade = CascadeType.ALL)
    private List<CheckpointPost> checkpointPosts = new ArrayList<>();

}
