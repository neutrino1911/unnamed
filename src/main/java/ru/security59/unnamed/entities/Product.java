package ru.security59.unnamed.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.security59.unnamed.util.Transliterator;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Data
@Entity
@EqualsAndHashCode(exclude = {"id", "images"})
@Table(name = "Product")
@ToString(exclude = {"category", "images", "vendor"})
public class Product {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "availability")
    private String availability;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id")
    private Category category;

    @Column(name = "currency")
    private String currency;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "product")
    private Set<Image> images;

    @Column(name = "name")
    private String name;

    @Column(name = "origin_id")
    private String originId;

    @Column(name = "origin_url", length = 1023)
    private String originURL;

    @Column(name = "price")
    private String price;

    @Column(name = "seo_url")
    private String seoURL;

    @Column(name = "unit")
    private String unit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vend_id")
    private Vendor vendor;

    public void addImage(Image image) {
        if (images == null) images = new TreeSet<>();
        if (images.size() < 10) images.add(image);
    }

    public String getImagesAsString() {
        StringBuilder builder = new StringBuilder();
        if (!(images instanceof TreeSet)) {
            images = new TreeSet<>(images);
        }
        for (Image image : images) {
            if (builder.length() > 0) builder.append(", ");
            //builder.append(HTMLParser.export_url);
            builder.append(image.getName());
        }
        return builder.toString();
    }

    public void setPrice(String price) {
        this.price = price
                .replaceAll(",", ".")
                .replaceAll("[^0-9.]", "");
    }

    public void setCurrency(String currency) {
        this.currency = currency.trim();
    }

    public Set<Image> getImages() {
        if (images == null) images = new TreeSet<>();
        return images;
    }

    public void setName(String name) {
        setName(name, true);
    }

    public void setName(String name, boolean addVendor) {
        this.name = name;
        if (addVendor) addVendorToName();
        seoURL = Transliterator.cyr2lat(this.name.toLowerCase());
        seoURL = seoURL
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("-+$", "");
    }

    private void addVendorToName() {
        if (!name.contains(vendor.getName()))
            name = vendor.getName() + " " + name;
    }

}