package by.aex.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "account", schema = "online_shop")
public class Account extends BaseEntity<Long> {

    @Column(name = "balance", nullable = false)
    private Double balance;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
