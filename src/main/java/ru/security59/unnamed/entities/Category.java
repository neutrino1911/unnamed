package ru.security59.unnamed.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(exclude = {"id"})
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "tiu_cat_id")
    private Integer tiuCatId;

    @Column(name = "tiu_id")
    private Integer tiuId;

    @Column(name = "uv_id")
    private Integer uvId;

}