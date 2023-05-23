package com.aurum.struts.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aurum.struts.model.Register;

public class RegisterRepository {
	
	public void register(String name) {
      try {
          // PostgreSQL JDBCドライバのクラスをロード
          Class.forName("org.postgresql.Driver");

          try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "tatu0930")) {
              String insertQuery = "INSERT INTO users1 (name) VALUES (?)";
              try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                  statement.setString(1, name);
                  statement.executeUpdate();
              }
          }
      } catch (ClassNotFoundException | SQLException e) {
          e.printStackTrace();
          // 例外処理の方法によって適切な例外やエラーコードを返すことができます
      }
  }
	
	
	
	public List<Register> findAll() {
	    List<Register> registerList = new ArrayList<>();

	    try {
	        Class.forName("org.postgresql.Driver");

	        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "tatu0930")) {
	            String selectQuery = "SELECT * FROM users1";
	            try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    while (resultSet.next()) {
	                        // ユーザ情報を取得してリストに追加
	                        Register name = new Register();
	                   
	                        name.setName(resultSet.getString("name"));
	                        // 他のカラムも必要に応じて取得
	                        registerList.add(name);
	                    }
	                }
	            }
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	        // 例外処理の方法によって適切な例外やエラーコードを返すことができます
	    }

	    return registerList;
	}
	
	

}
