package io.github.denrzv.springwebsecurity.controller;

import io.github.denrzv.springwebsecurity.entity.Person;
import io.github.denrzv.springwebsecurity.service.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Data
@RestController
public class Controller {
    private final Service service;

    @GetMapping("/persons/by-city")
    public List<Person> findAllByCityOfLivingEqualsIgnoreCase(@RequestParam String city) {
        return service.findAllByCityOfLivingEqualsIgnoreCase(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> findAllByAgeLessThanOrderByAge(@RequestParam int age) {
        return service.findAllByAgeLessThanOrderByAge(age);
    }

    @GetMapping("/persons/by-name-and-surname")
    public List<Person> findAllByNameEqualsIgnoreCaseAndSurnameEqualsIgnoreCase(@RequestParam
                                                                                              String name,
                                                                                          @RequestParam
                                                                                          String surname) {
        return service.findAllByNameEqualsIgnoreCaseAndSurnameEqualsIgnoreCase(name, surname);
    }

    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person person) {
        return service.addPerson(person);
    }

    @GetMapping("/persons/update-phone")
    public Person updatePhoneNumber(@RequestParam String name, @RequestParam String surname,
                                    @RequestParam int age, @RequestParam int phoneNumber) {
        return service.updatePhone(name, surname, age, phoneNumber);
    }

    @GetMapping("/persons/delete-person")
    public void deletePerson(@RequestParam String name, @RequestParam String surname,
                                    @RequestParam int age) {
        service.deletePerson(name, surname, age);
    }
}
