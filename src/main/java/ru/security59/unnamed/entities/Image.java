package ru.security59.unnamed.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(exclude = {"id", "product"})
@Table(name = "Image")
@ToString(exclude = {"product"})
public class Image implements Comparable<Image> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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
    public int compareTo(Image o) {
        return url.compareToIgnoreCase(o.url);
    }
}