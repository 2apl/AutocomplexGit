package by.aex.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@ToString
@MappedSuperclass
public class BaseEntity<PK extends Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private PK id;
}
