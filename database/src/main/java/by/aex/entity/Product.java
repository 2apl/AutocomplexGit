package by.aex.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "product", schema = "online_shop")
public class Product extends BaseEntity<Long> {

    @Column(name = "article", nullable = false)
    private String article;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price_buy")
    private Double priceBuy;

    @Column(name = "price_sell", nullable = false)
    private Double priceSell;

    @ManyToMany(mappedBy = "productSet")
    private Set<Order> orderSet = new HashSet<>();
}
