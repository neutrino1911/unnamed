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
@Table(name = "Failures")
public class Failure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "target_id")
    private int targetId;

    @Column(name = "url", length = 1023)
    private String url;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Failure failure = (Failure) o;

        if (targetId != failure.targetId) return false;
        return url.equals(failure.url);
    }

    @Override
    public int hashCode() {
        int result = targetId;
        result = 31 * result + url.hashCode();
        return result;
    }
}