package org.nexters.az.user.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String identification;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column(nullable = false)
    private String hashedPassword;

    @Builder
    public User(String identification, String nickname, String hashedPassword) {
        this.identification = identification;
        this.nickname = nickname;
        this.hashedPassword = hashedPassword;
        this.rating = Rating.NEW_RECRUIT;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
