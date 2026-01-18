package com.umbra.rest_api;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.umbra.rest_api.connection.DatabaseConnection;

@SpringBootApplication
public class RestApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);

		List<User> users = new ArrayList<>();

		try {
			Connection connection = DatabaseConnection.getInstance().connection();
			PreparedStatement pstm = connection.prepareStatement("SELECT * FROM people");
			ResultSet resultSet = pstm.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Date birthDate = resultSet.getDate("birth_date");
				double income = resultSet.getDouble("income");
				String ocupation = resultSet.getString("ocupation");

				User newUser = new User(id, name, birthDate, income, ocupation);
				users.add(newUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("--- Users ---");
		for (User user : users) {
			System.out.println(
					"ID: " + user.getId() + "\n" +
							"Name: " + user.getName() + "\n" +
							"Occupation: " + user.getOcupation() + "\n" +
							"Income: " + user.getIncome() + "\n" +
							"Birth Date: " + user.getBirthDate() + "\n");
		}
	}

}