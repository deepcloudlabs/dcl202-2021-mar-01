package com.example.banking.application;

import com.example.banking.domain.AccountStatus;

public class StudyEnums {

	public static void main(String[] args) {
		for (var status : AccountStatus.values()) {
			System.out.println(status.name() + "\t: " + status.getCode());
		}

	}

}
