package ru.denfad.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "name")
    private String name;

    @Column(name="status")
    private String status;

    @Column(name="avatar_url")
    private String avatar_url;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sight> sights;

    public User(){}

    public User(String name, String status, String avatar_url){
        this.name=name;
        this.status=status;
        this.avatar_url=avatar_url;
        posts=new ArrayList<>();
        sights= new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Sight> getSights() {
        return sights;
    }

    public void setSights(List<Sight> sights) {
        this.sights = sights;
    }

    public void addSight(Sight sight){
        sight.setUser(this);
        sights.add(sight);
    }

    public  void addPost(Post post){
        post.setUser(this);
        posts.add(post);
    }

    public void removeSight(Sight sight){
        sights.remove(sight);
    }

    public void removePost(Post post){
        posts.remove(post);
    }
}
