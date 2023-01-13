package io.github.denrzv.springwebsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
public class Person {
    @EmbeddedId
    private PersonId personId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private int phoneNumber;

    @Column(nullable = false)
    private String cityOfLiving;
}
