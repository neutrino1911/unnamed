package ru.security59.unnamed.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(exclude = {"id"})
@Table(name = "Target")
@ToString(exclude = {"category", "vendor"})
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id")
    private Category category;

    @Column(name = "currency")
    private String currency;

    @Column(name = "last_id")
    private long lastId;

    @Column(name = "unit")
    private String unit;

    @Column(name = "url", length = 1023)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vend_id")
    private Vendor vendor;

    public long getNextId() {
        if (lastId == 0) lastId = vendor.getId() * 1000000 + category.getId() * 1000;
        return ++lastId;
    }
}