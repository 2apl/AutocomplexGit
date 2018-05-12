package by.aex.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "category", schema = "online_shop")
public class Category extends BaseEntity<Long> {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(name = "product_category", schema = "online_shop",
            joinColumns = {@JoinColumn(name = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private Set<Product> productSet = new HashSet<>();
}
