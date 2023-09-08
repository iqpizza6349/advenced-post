package org.iqpizza.advancedpost.post.domain;

import jakarta.persistence.*;
import lombok.*;
import org.iqpizza.advancedpost.user.domain.User;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 32767)
    private String content;

    @Builder.Default
    @Column(nullable = false)
    private int heart = 0;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @Builder.Default
    @Column(nullable = false)
    private boolean deleted = false;

    @CreatedBy
    @ManyToOne(optional = false)
    private User author;

}
