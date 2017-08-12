package ru.security59.unnamed.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@EqualsAndHashCode(exclude = {"id"})
@Table(name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text", columnDefinition = "TEXT")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_id")
    private User from;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_id")
    private User to;

    @Column(name = "date")
    private Date date;

}
