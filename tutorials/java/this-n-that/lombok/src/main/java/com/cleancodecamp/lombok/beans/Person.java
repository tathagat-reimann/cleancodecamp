package com.cleancodecamp.lombok.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Slf4j
public class Person {
    private String firstName;
    private String lastName;
    public static void main(String[] args) {
        Person john = new Person("john", "tranvolta");

        logger.debug(john.toString());

        System.out.println(john);
    }
}
