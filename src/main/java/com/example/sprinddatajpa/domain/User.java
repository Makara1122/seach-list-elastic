package com.example.sprinddatajpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;


import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_tbl")
@Document(indexName = "makara-tester-v2")
@JsonIgnoreProperties(ignoreUnknown = true)

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;


    private String name;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role_tbl",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    private Set<Role> roles;



}
