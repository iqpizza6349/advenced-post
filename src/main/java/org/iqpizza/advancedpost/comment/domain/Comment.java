package org.iqpizza.advancedpost.comment.domain;

import jakarta.persistence.*;
import lombok.*;
import org.iqpizza.advancedpost.user.domain.User;
import org.springframework.data.annotation.CreatedBy;

@Getter
@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @CreatedBy
    @ManyToOne(optional = false)
    private User commenter;

    @ManyToOne
    private Comment rootComment;

}
