package by.aex.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@DiscriminatorValue("wish")
public class Wish extends SearchHistory {

    @Column(name = "price")
    private Integer price;

    public Wish(String article, String brand, String description, User user, Integer price) {
        super(article, brand, description, user);
        this.price = price;
    }
}
