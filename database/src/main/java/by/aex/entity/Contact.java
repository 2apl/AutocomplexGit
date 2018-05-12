package by.aex.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "contact", schema = "online_shop")
public class Contact extends BaseEntity<Long> {

    @Column(name = "phone_number", nullable = false, unique = true)
    private PhoneNumber phoneNumber;

    @Column
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "phoneNumber", column = @Column(name = "phone_number_reserve")))
    private PhoneNumber phoneNumberReserve;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "building")
    private String building;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
