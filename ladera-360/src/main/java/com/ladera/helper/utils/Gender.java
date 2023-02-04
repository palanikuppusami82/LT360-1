package com.ladera.helper.utils;

public enum Gender {
	MALE, FEMALE;

	public static Gender getGenderFromCode(String value) {

		for (Gender dep : Gender.values()) {

			if (dep.name().equals(value)) {

				return dep;
			}
		}

		return null;
	}

}
