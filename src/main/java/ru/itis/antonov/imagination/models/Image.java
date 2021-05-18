package ru.itis.antonov.imagination.models;

import javax.persistence.*;
import java.util.List;

@Entity
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
    @JoinTable(name = "likes", uniqueConstraints = {@UniqueConstraint(columnNames = {"user", "image"})})
    private List<User> likes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "dislikes", uniqueConstraints = {@UniqueConstraint(columnNames = {"user", "image"})})
    private List<User> dislikes;
}
