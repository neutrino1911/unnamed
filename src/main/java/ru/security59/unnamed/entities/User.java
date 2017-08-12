package ru.security59.unnamed.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = {"id", "sentMessages", "receivedMessages"})
@JsonIgnoreProperties({"sentMessages", "receivedMessages"})
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "hash")
    private String hash;

    @ManyToMany(mappedBy = "from")
    private Set<Message> sentMessages;

    @ManyToMany(mappedBy = "to")
    private Set<Message> receivedMessages;

}
