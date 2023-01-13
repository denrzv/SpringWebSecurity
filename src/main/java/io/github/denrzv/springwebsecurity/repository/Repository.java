package io.github.denrzv.springwebsecurity.repository;

import io.github.denrzv.springwebsecurity.entity.Person;
import io.github.denrzv.springwebsecurity.entity.PersonId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface Repository extends CrudRepository<Person, PersonId> {
    List<Person> findAllByCityOfLivingEqualsIgnoreCase(String city);
    List<Person> findAllByAgeLessThanOrderByAge(int age);
    Optional<List<Person>> findAllByNameEqualsIgnoreCaseAndSurnameEqualsIgnoreCase(String name, String surname);

    @Modifying
    @Query("update Person p set p.phoneNumber = ?4 where p.name = ?1 and p.surname = ?2 and p.age = ?3")
    Person setPersonPhoneNumberByNameAndSurnameAndAge(String name, String surname, Integer age, int phoneNumber);

    void deletePersonByNameAndSurnameAndAge(String name, String surname, int age);
}
