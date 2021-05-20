package ru.itis.antonov.imagination.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private User author;
    private String storagePath;
    @ManyToOne
    private Image parent;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "likes", uniqueConstraints = {@UniqueConstraint(columnNames = {"account", "image"})},
            joinColumns = {@JoinColumn(name = "image")},
            inverseJoinColumns = {@JoinColumn(name = "account")})
    private List<User> likes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "dislikes", uniqueConstraints = {@UniqueConstraint(columnNames = {"account", "image"})},
            joinColumns = {@JoinColumn(name = "image")},
            inverseJoinColumns = {@JoinColumn(name = "account")})
    private List<User> dislikes;
}
