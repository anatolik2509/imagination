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
    @ManyToOne
    private User author;
    private String storagePath;
    @ManyToOne(cascade = CascadeType.ALL)
    private Image parent;

    @OneToMany(orphanRemoval = true, mappedBy = "parent")
    private List<Image> child;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "image", orphanRemoval = true)
    private List<Comment> comments;
}
