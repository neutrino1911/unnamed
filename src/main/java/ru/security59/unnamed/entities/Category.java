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
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "tiu_cat_id")
    private int tiuCatId;

    @Column(name = "tiu_id")
    private int tiuId;

    @Column(name = "uv_id")
    private int uvId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (tiuId != category.tiuId) return false;
        if (uvId != category.uvId) return false;
        if (tiuCatId != category.tiuCatId) return false;
        return name.equals(category.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + tiuId;
        result = 31 * result + uvId;
        result = 31 * result + tiuCatId;
        return result;
    }
}