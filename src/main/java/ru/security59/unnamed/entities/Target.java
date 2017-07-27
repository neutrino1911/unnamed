package ru.security59.unnamed.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Targets")
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id")
    private Category category;

    @Column(name = "currency")
    private String currency;

    @Column(name = "last_id")
    private int lastId;

    @Column(name = "unit")
    private String unit;

    @Column(name = "url", length = 1023)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vend_id")
    private Vendor vendor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Target target = (Target) o;

        if (!category.equals(target.category)) return false;
        if (!vendor.equals(target.vendor)) return false;
        if (!currency.equals(target.currency)) return false;
        if (!unit.equals(target.unit)) return false;
        return url.equals(target.url);
    }

    @Override
    public int hashCode() {
        int result = category.hashCode();
        result = 31 * result + vendor.hashCode();
        result = 31 * result + currency.hashCode();
        result = 31 * result + unit.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }

    public int getNextId() {
        if (lastId == 0)  lastId = vendor.getId() * 1000000 + category.getId() * 1000;
        return ++lastId;
    }
}