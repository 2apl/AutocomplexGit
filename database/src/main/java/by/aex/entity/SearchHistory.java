package by.aex.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "search_history", schema = "online_shop")
@Inheritance(strategy = InheritanceType.JOINED)
public class SearchHistory extends BaseEntity<Long> {

    @Column(name = "article", nullable = false)
    private String article;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
