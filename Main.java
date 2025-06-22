
import _2_CreatingAndDestroyingObjects.Item1.*;

// import _2_CreatingAndDestroyingObjects.Item1.*;

// public class Main {
//     public static void main(String[] args) {
//         // Create a Book with title only
//         Book book1 = Book.ofTitle("Java Programming");
//         System.out.println(book1); // Output: book{title='Java Programming', author='unknown'}

//         // Create a book with title and author
//         Book book2 = Book.ofTitleAndAuthor("Effective Java", "Joshua Bloch");
//         System.out.println(book2); // Output: book{title='Effective Java', author='Joshua Bloch'}

//         // This will throw an IllegalArgumentException
//         try {
//             Book.ofTitle("");
//         } catch (IllegalArgumentException e) {
//             System.out.println(e.getMessage()); // Output: Title cannot be null or empty
//         }
//     }
// }

public class Main {
    public static void main(String[] args) {
        // Lấy kết nối với chuỗi cấu hình
        DatabaseConnection conn1 = DatabaseConnection.getConnection("jdbc:mysql://localhost:3306/db1");
        DatabaseConnection conn2 = DatabaseConnection.getConnection("jdbc:mysql://localhost:3306/db1");
        DatabaseConnection conn3 = DatabaseConnection.getConnection("jdbc:mysql://localhost:3306/db2");

        // Kiểm tra singleton
        System.out.println("Same instance: " + (conn1 == conn2)); // true
        System.out.println("Different instance: " + (conn1 != conn3)); // true

        // Sử dụng kết nối
        conn1.executeQuery("SELECT * FROM users");
    }
}