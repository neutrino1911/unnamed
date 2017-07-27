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
@Table(name = "Images")
public class Image implements Comparable<Image> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_id")
    private Product product;

    @Column(name = "url", length = 1023)
    private String url;

    public Image(String url, Product product) {
        this.url = url;
        this.product = product;
        this.name = String.format("%s-%d.jpg", product.getSeoURL(), product.getImages().size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (!name.equals(image.name)) return false;
        return url.equals(image.url);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }

    @Override
    public int compareTo(Image o) {
        return url.compareToIgnoreCase(o.url);
    }
}