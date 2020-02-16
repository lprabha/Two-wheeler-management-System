package com.example.two_wheeler_schedule_management_system;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class EmailInvalid {
    EmailValidatorInput emailValidatorInput=new EmailValidatorInput();
    @Test
    public void email_valid() {
        assertTrue(emailValidatorInput.isEmailValid("rupesh@email.com"));
        assertTrue(emailValidatorInput.isEmailValid("rupesh@gmail.com"));

    }
}
