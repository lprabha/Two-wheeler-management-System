package com.example.two_wheeler_schedule_management_system;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class Email_invalid {
    EmailValidatorInput emailValidatorInput=new EmailValidatorInput();

    @Test
    public void email_invalid() {
        assertFalse(emailValidatorInput.isEmailValid("email.com"));
        assertFalse(emailValidatorInput.isEmailValid("@email.com"));

    }
}
