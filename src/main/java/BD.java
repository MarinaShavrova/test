import java.sql.*;

public class BD {
        private Connection connection;
        public void bd() {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                System.out.println("Can't get class. No driver found");
                e.printStackTrace();

            }
            try {
                connection = DriverManager.getConnection("jdbc:sqlite://C://Users//Marinka//IdeaProjects//Broadcast//users.db");
                Statement statement = connection.createStatement();
                String query = "select * from song";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    int id =  resultSet.getInt(1);
                    String inutSing =  resultSet.getString(2);
                    System.out.println(" "+id+" "+inutSing);
                }
            } catch (SQLException e) {
                System.out.println("Can't get connection. Incorrect URL");
                e.printStackTrace();

            }
        }

    public Connection getConnection() {
            return connection;
    }
    public static void main (String[] args) throws SQLException {
            new BD();
        }

}


            /*
            String url = "jdbc:mysql://127.0.0.1:3306/MySQL?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
            String username = "root";
            String password = "927854mar";
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){//соединение с БД
                System.out.println("OK");
                Statement statement = conn.createStatement();//для работы с SQL
                System.out.println("i= "+i+" inputSong= "+inputSong+" inputAdvertising= "+inputAdvertising);
                statement.executeUpdate("insert into store.broadcast (id, song, advertising) value ('"+i+"','"+inputSong+"','"+inputAdvertising+"')");


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                System.out.println("Can't get class. No driver found");
                e.printStackTrace();
                return;
            }
            Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:sqlite://C://Users//Marinka//IdeaProjects//Broadcast//users.db");
                Statement statement = connection.createStatement();//для работы с SQL

                System.out.println("ЗАПОЛНЕНИЕ ТАБЛИЦИ    inputSongTime= "+inputSongTime+" inputSong= "+inputSong+" inputSongArtist= "+inputSongArtist);

                statement.execute("insert into song( inputSong, inputSongArtist, inputSongTime) VALUES ('"+inputSong+"','"+inputSongArtist+"','"+inputSongTime+"')");


            } catch (SQLException e) {
                System.out.println("Can't get connection. Incorrect URL");
                e.printStackTrace();
                return;
            }
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Can't close connection");
                e.printStackTrace();
                return;
            }*/



