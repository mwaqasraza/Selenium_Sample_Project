package com.digital.util;

import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;
import java.util.Map;

public class MySQLUtils {

    static Connection connection;

    public MySQLUtils(String server, String port, String username, String password, String database) throws SQLException {
        String connectionUrl = "jdbc:mysql://"+ server + ":" + port + "/" + database;
        connection = DriverManager.getConnection(connectionUrl, username, password);
    }

    public static String get_Single_Record_By_Matching_Key_And_Value(String tableName, String key, Object value) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE " + key + " = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setObject(1, value);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    JSONObject jsonObject = new JSONObject();
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        jsonObject.put(metaData.getColumnName(i), resultSet.getObject(i));
                    }
                    return jsonObject.toString();
                }
            }
        }
        return null;
    }

    public static String get_Single_Record_By_Matching_Query(String query) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    JSONObject jsonObject = new JSONObject();
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        jsonObject.put(metaData.getColumnName(i), resultSet.getObject(i));
                    }
                    return jsonObject.toString();
                }
            }
        }
        return null;
    }

    public static String get_Multiple_Records_By_Matching_Key_And_Value(String tableName, String key, Object value, Boolean useLikeInsteadOfEquals) throws SQLException {
        String operator;
        if(useLikeInsteadOfEquals) {
            operator = "LIKE";
        }else{
            operator = "=";
        }
        String query = "SELECT * FROM " + tableName + " WHERE " + key + " " + operator + " ?";
        JSONArray jsonArray = new JSONArray();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setObject(1, value);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                while (resultSet.next()) {
                    JSONObject jsonObject = new JSONObject();
                    for (int i = 1; i <= columnCount; i++) {
                        jsonObject.put(metaData.getColumnName(i), resultSet.getObject(i));
                    }
                    jsonArray.put(jsonObject);
                }
            }
        }
        return jsonArray.toString();
    }

    public static String get_Multiple_Records_By_Matching_Query(String query) throws SQLException {
        JSONArray jsonArray = new JSONArray();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                while (resultSet.next()) {
                    JSONObject jsonObject = new JSONObject();
                    for (int i = 1; i <= columnCount; i++) {
                        jsonObject.put(metaData.getColumnName(i), resultSet.getObject(i));
                    }
                    jsonArray.put(jsonObject);
                }
            }
        }
        return jsonArray.toString();
    }


    public static boolean insert_into_db(String tableName, Map<String, Object> fieldValues) {
        if (fieldValues == null || fieldValues.isEmpty()) {
            throw new IllegalArgumentException("Field values map cannot be null or empty");
        }

        StringBuilder columns = new StringBuilder();
        StringBuilder placeholders = new StringBuilder();

        for (String column : fieldValues.keySet()) {
            if (columns.length() > 0) {
                columns.append(", ");
                placeholders.append(", ");
            }
            columns.append(column);
            placeholders.append("?");
        }

        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + placeholders + ")";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            int index = 1;
            for (Object value : fieldValues.values()) {
                preparedStatement.setObject(index++, value);
            }
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void disconnect_DB() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

}