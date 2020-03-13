package ru.denfad.demo.models;



import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name="photo_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="label")
    private String label;

    @Column(name="photo_url")
    private String photo_url;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="sight_id")
    private Sight sight;

    public Post(){}

    public Post(String label, String photo_url) {
        this.label = label;
        this.photo_url = photo_url;

    }

    public int getId() {
        return id;
    }



    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Sight getSight() {
        return sight;
    }

    public void setSight(Sight sight) {
        this.sight = sight;
    }
}
