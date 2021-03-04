import java.io.*;
import java.sql.*;

public class ImgageTransformerDAO {

    public static java.sql.Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/everything_for_the_mountains?user=root&password=&serverTimezone=UTC");
    }


    public void insertImage(String filePath, String name) throws SQLException, IOException, ClassNotFoundException {

        File image = new File(filePath);
        try (FileInputStream inputStream = new FileInputStream(image);

             Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("insert into inventory(name, photo) " +  "values(?,?)")) {


            statement.setString(1, name);
             statement.setBinaryStream(2, (InputStream) inputStream);

             statement.executeUpdate();


    }

}

    public static InputStream writetoFile(String name) throws Exception {

        String sqlString =
                "SElECT photo  FROM inventory WHERE name=? ";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlString);) {

            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getBinaryStream(1);

                } else {
                    return null;
                }
            }

        }
    }
}
