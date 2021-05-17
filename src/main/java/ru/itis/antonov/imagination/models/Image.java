package ru.itis.antonov.imagination.models;

import javax.persistence.*;

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
    //todo likes and dislikes
}
