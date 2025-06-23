
import _2_CreatingAndDestroyingObjects.Item2.Pizza;

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

// public class Main {
//     public static void main(String[] args) {
//         // Lấy kết nối với chuỗi cấu hình
//         DatabaseConnection conn1 = DatabaseConnection.getConnection("jdbc:mysql://localhost:3306/db1");
//         DatabaseConnection conn2 = DatabaseConnection.getConnection("jdbc:mysql://localhost:3306/db1");
//         DatabaseConnection conn3 = DatabaseConnection.getConnection("jdbc:mysql://localhost:3306/db2");

//         // Kiểm tra singleton
//         System.out.println("Same instance: " + (conn1 == conn2)); // true
//         System.out.println("Different instance: " + (conn1 != conn3)); // true

//         // Sử dụng kết nối
//         conn1.executeQuery("SELECT * FROM users");
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         // Tạo điểm từ tọa độ Cartesian
//         Point p1 = Point.fromCartesian(3, 4);
//         System.out.println("Cartesian point: " + p1); // Point(3.0, 4.0)

//         // Tạo điểm từ t�ọa độ cực (r = 5, angle = π/4 ≈ 45 độ)
//         Point p2 = Point.fromPolar(5, Math.PI / 4);
//         System.out.println("Polar point: " + p2); // Point(3.535..., 3.535...)

//         // Kiểm tra equals
//         Point p3 = Point.fromCartesian(p2.getX(), p2.getY());
//         System.out.println("p2 equals p3: " + p2.equals(p3)); // true
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         // Test 1: Tạo và kiểm tra các logger với tên khác nhau
//         Logger logger1 = Logger.getInstance("AppLogger");
//         Logger logger2 = Logger.getInstance("DatabaseLogger");
//         Logger logger3 = Logger.getInstance("AppLogger"); // Nên trả về cùng instance với logger1

//         System.out.println("Logger 1 name: " + logger1.getName());
//         System.out.println("Logger 2 name: " + logger2.getName());
//         System.out.println("Logger 3 name: " + logger3.getName());
//         System.out.println("Is logger1 same as logger3? " + (logger1 == logger3)); // Kiểm tra caching

//         // Test 2: Kiểm tra tên có khoảng trắng
//         Logger logger4 = Logger.getInstance("  WebLogger  ");
//         System.out.println("Logger 4 name: " + logger4.getName()); // Tên đã được trim

//         // Test 3: Kiểm tra trường hợp ngoại lệ
//         try {
//             Logger logger5 = Logger.getInstance(null);
//         } catch (NullPointerException e) {
//             System.out.println("Caught expected exception: " + e.getMessage());
//         }

//         try {
//             Logger logger6 = Logger.getInstance("   ");
//         } catch (IllegalArgumentException e) {
//             System.out.println("Caught expected exception: " + e.getMessage());
//         }
//     }
// }

public class Main {
    public static void main(String[] args) {
        Pizza p = Pizza.builder()
                .addTopping("Cheese")
                .addTopping("Pepperoni")
                .setSize("Large")
                .setCrustType("Thin")
                .build();
        System.out.println(p.toString());
        Pizza p2 = Pizza.builder().addTopping("Potato").addTopping("Mushroom").setSize("Medium")
                .setCrustType("Thick        ").build();
        System.out.println(p2.toString());
    }
}