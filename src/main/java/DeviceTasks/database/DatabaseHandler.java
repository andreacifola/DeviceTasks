package DeviceTasks.database;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler {

    private final String url = "jdbc:postgresql://localhost:5432/middlewaretask";
    private final String user = "postgres";
    private final String password = "admin";

    public Connection connect() throws ClassNotFoundException {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }


    public void writeTaskIntoDB(String type, ArrayList<Double> list, Connection conn) throws SQLException {
        for (int i = 0; i < list.size(); i++) {
            PreparedStatement st = conn.prepareStatement("INSERT INTO "+type+" (time) VALUES (?)");
            st.setDouble(1,list.get(i));
            st.executeUpdate();
            st.close();
        }
    }

    public void writeTimeToDB(String type,Double time,Connection conn) throws SQLException {
        PreparedStatement st = conn.prepareStatement("INSERT INTO "+type+" (time) VALUES (?)");
        st.setDouble(1,time);
        st.executeUpdate();
        st.close();
    }

    public ArrayList<Double> getTasksFromDB(String type, Connection conn) throws SQLException {
        ArrayList<Double> exec_times = new ArrayList<>();
        PreparedStatement st = conn.prepareStatement("SELECT time FROM "+type);
        ResultSet res = st.executeQuery();
        while (res.next()){
            exec_times.add(res.getDouble("time"));
        }
        return exec_times;
    }

}
