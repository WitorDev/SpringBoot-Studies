package com.umbra.rest_api.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DatabaseConnection {
  private static DatabaseConnection instance;
  private final Connection connection;

  private DatabaseConnection() {
    try {
      connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/mydb", "witor", "cogumelo57");
    } catch (SQLException err) {
      throw new RuntimeException("Ocorreu um erro ao se conectar com o banco de dados: " + err.getMessage());
    }
  }

  public static DatabaseConnection getInstance() {
    if (Objects.isNull(instance)) {
      instance = new DatabaseConnection();
    }
    return instance;
  }

  public Connection connection() {
    return connection;
  }
}
