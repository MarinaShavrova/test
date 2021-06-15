import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTableData {

    public static void main (String[] args) throws SQLException {
        BD worker = new BD();
        Statement statement = worker.getConnection().createStatement();//для работы с SQL

        String query = "select * from song";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
           int id =  resultSet.getInt(1);
          String inutSing =  resultSet.getString(2);
            System.out.println(" "+id+" "+inutSing);
        }
    }

}
