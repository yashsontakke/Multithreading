package COREJAVA.interviewquestions;


class Database {
    static class Connection {
        void connect() {
            System.out.println("Connected to the database");
        }
    }
}


public class StaticInnerClass {
    public static void main(String[] args) {
        Database.Connection conn = new Database.Connection();
        conn.connect();
    }
}
