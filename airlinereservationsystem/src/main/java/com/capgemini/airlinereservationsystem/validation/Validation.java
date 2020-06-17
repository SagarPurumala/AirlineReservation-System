package com.capgemini.airlinereservationsystem.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.airlinereservationsystem.exception.ARSException;

public class Validation {
	public boolean validatedId(int id) throws ARSException {
		String idRegEx = "[0-9]{1}[0-9]{3}";
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new ARSException("Invalid Id! Id should contain exactly 4 digits");
		}
		return result;
	}

	public boolean validatedName(String name) throws ARSException {
		String nameRegEx = "^(?=.{4,20}$)(?![_.-])(?!.*[.]{2})[a-zA-Z._-]+(?<![_.-])";
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new ARSException("Invalid Name! Name should have atleast 4 characters");
		}
		return result;
	}

	public boolean validatedMobile(long mobile) throws ARSException {
		String mobileRegEx = "(0/91)?[6-9][0-9]{9}";
		boolean result = false;
		if (Pattern.matches(mobileRegEx, String.valueOf(mobile))) {
			result = true;
		} else {
			throw new ARSException(
					"Enter a mobile number whose length is 10 digits and should start with 6,7,8,9 digits only");
		}
		return result;
	}

	public boolean validatedEmail(String email) throws ARSException {
		String emailRegEx = "^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.(com|org)";
		boolean result = false;
		Pattern pattern = Pattern.compile(emailRegEx);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new ARSException("Enter proper email such that it should consist of numbers and alphabets");
		}
		return result;
	}

	public boolean validatedPassword(String password) throws ARSException {
		String passwordRegEx = "((?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%]).{6,20})";
		boolean result = false;
		if (Pattern.matches(passwordRegEx, String.valueOf(password))) {
			result = true;
		} else {
			throw new ARSException(
					"Password should contain atleast 6 characters ,one uppercase,one lowercase,one number,one special symbol(@#$%) ");
		}
		return result;
	}

}
