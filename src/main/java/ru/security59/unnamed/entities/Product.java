package ru.security59.unnamed.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.security59.unnamed.util.Transliterator;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @Column(name = "id")
    private int id;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!category.equals(product.category)) return false;
        if (!vendor.equals(product.vendor)) return false;
        if (!availability.equals(product.availability)) return false;
        if (!currency.equals(product.currency)) return false;
        if (!description.equals(product.description)) return false;
        if (!name.equals(product.name)) return false;
        if (!originId.equals(product.originId)) return false;
        if (!originURL.equals(product.originURL)) return false;
        if (!price.equals(product.price)) return false;
        if (!seoURL.equals(product.seoURL)) return false;
        return unit.equals(product.unit);
    }

    @Override
    public int hashCode() {
        int result = category.hashCode();
        result = 31 * result + vendor.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + originId.hashCode();
        result = 31 * result + originURL.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + seoURL.hashCode();
        result = 31 * result + unit.hashCode();
        return result;
    }
}