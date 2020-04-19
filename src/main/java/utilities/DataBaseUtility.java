package utilities;

import io.cucumber.java.it.Ma;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseUtility {



    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;


    private static void createConnection() throws SQLException {
        switch (ConfigurationReader.getProperty("dbType")) {

            case "oracle":
                connection = DriverManager.getConnection(ConfigurationReader.getProperty("oracleURL"),
                        ConfigurationReader.getProperty("oracleUsername"),
                        ConfigurationReader.getProperty("oraclePassword"));
                break;
            case "Mysql":
                //put connection information
            default:
                connection =null;
        }
    }


    public static List<Map<Object,Object>> executeQuery(String query) throws SQLException {
        statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet=statement.executeQuery(query);

        ResultSetMetaData metada = resultSet.getMetaData();
        int numberOfColumns = metada.getColumnCount();

        List<Map<Object, Object>> data = new ArrayList<>();

        while (resultSet.next()){

            Map<Object, Object> map =new HashMap<>();

            for(int i=1; i<=numberOfColumns; i++){
                map.put(metada.getColumnName(i),resultSet.getObject(i));
            }
            data.add(map);
        }
        return data;
    }

    public static void close () throws SQLException {
        if(resultSet !=null && !resultSet.isClosed()){
            resultSet.close();
        }
        if(statement!=null && !statement.isClosed()){
            statement.close();
        }
        if(connection !=null && !connection.isClosed()){
            connection.close();
        }
    }





}




































