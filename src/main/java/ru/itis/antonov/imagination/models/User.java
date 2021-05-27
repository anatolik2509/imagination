package ru.itis.antonov.imagination.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nickname;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private State state;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDate birthDate;


    @OneToMany(mappedBy = "author")
    private List<Image> posts;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "subscribes",
            joinColumns = {@JoinColumn(name = "user_from")},
            inverseJoinColumns = {@JoinColumn(name = "user_to")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_from", "user_to"})})
    private List<User> subscribes;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(name = "subscribes",
            joinColumns = {@JoinColumn(name = "user_to")},
            inverseJoinColumns = {@JoinColumn(name = "user_from")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_from", "user_to"})})
    private List<User> subscribers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "likes",
            uniqueConstraints = {@UniqueConstraint(columnNames = {"account", "image"})},
            joinColumns = {@JoinColumn(name = "account")},
            inverseJoinColumns = {@JoinColumn(name = "image")})
    private List<Image> liked;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "dislikes",
            uniqueConstraints = {@UniqueConstraint(columnNames = {"account", "image"})},
            joinColumns = {@JoinColumn(name = "account")},
            inverseJoinColumns = {@JoinColumn(name = "image")})
    private List<Image> disliked;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Album> albums;


    public enum State {
        NORMAL,
        BANNED,
        DELETED
    }

    public enum Role {
        USER, MODERATOR, ADMIN
    }
}
