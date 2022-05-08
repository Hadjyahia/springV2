package com.example.test.models;


import com.example.test.Enum.Region;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class AppUser implements Serializable {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private int id;
    private String username;
    private String email;
    private String phone;
    private String password;
    @Enumerated(EnumType.STRING)
    private Region region;
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
    private Boolean enabled=false;
    private String genre;
    private int age;
    private String poids;
    private String taille;
    private String typeSang;
    private int nbDemandeSang=0;
    private int nbDonSang=0;
    private int nbPoints=0;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}
