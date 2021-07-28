package hu.ulyssys.java.course.database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DDLMain {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/demo";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASSWORD = "kzkcski1kr2kl3";


    public static void main(String[] args) {
        try {
            //Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo?user=postgres&password=kzkcski1kr2kl3");

            Properties properties = new Properties();
            properties.setProperty("user", DATABASE_USER);
            properties.setProperty("password", DATABASE_PASSWORD);
            Connection connection = DriverManager.getConnection(DATABASE_URL, properties);

            //truncateDemo(connection);
            //dropTableDemo(connection);
            //createTableDemo(connection);
            //alterTableAddDemo(connection);
            //createTable(connection, "apple", "apple_name");
            //createTable(connection, "pear", "pear_name");
            //createTable(connection, "cherry", "cherry_name");

            System.out.println("Sikeresen végrehajtódott a program");

        } catch (SQLException e) {
            System.out.println("SQL exception ág");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.printf("Sima exception ág");
            e.printStackTrace();
        } finally {
            System.out.println("Vége a programunknak");
        }
    }

    private static void createTable(Connection connection, String tableName, String columnName) throws SQLException {
        //prepared statement megoldás
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE " + tableName + " (id SERIAL NOT NULL," + columnName +
                " character varying (255), CONSTRAINT " + tableName + "_sequence PRIMARY KEY (id))");
    }

    private static void truncateDemo(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        //truncate SQL parancs, kitöröljük az address tábla minden elemét
        statement.execute("truncate address");
    }

    private static void dropTableDemo(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        //drop table SQL parancs, kitöröljük az address táblát
        statement.execute("drop table address");
    }

    private static void createTableDemo(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        //create table SQL parancs, létrehozzuk az address táblát
        statement.execute("CREATE TABLE public.address\n" +
                "(\n" +
                "    id SERIAL NOT NULL,\n" +
                "    employee_id integer NOT NULL,\n" +
                "    value character varying(255) COLLATE pg_catalog.\"default\",\n" +
                "    CONSTRAINT address_pkey PRIMARY KEY (id),\n" +
                "    CONSTRAINT employee_foreign_key FOREIGN KEY (employee_id)\n" +
                "        REFERENCES public.employee (id) MATCH SIMPLE\n" +
                "        ON UPDATE NO ACTION\n" +
                "        ON DELETE NO ACTION\n" +
                ")");
    }

    private static void alterTableAddDemo(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        //drop table SQL parancs, kitöröljük az address táblát
        statement.execute("ALTER TABLE address ADD test BOOLEAN");
    }
}
