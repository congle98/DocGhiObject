import java.io.*;
import java.util.ArrayList;
import java.util.List;
        // có thể ghi ra 1 phần tử trong mảng bằng get
public class demo {
    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readerFile(String path){
        try{
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            System.out.println(objectInputStream.readObject());
            //khi đọc readObject thì ở bộ nhớ tạm sẽ lấy ra hết mảng object nếu gọi lại readObject tiếp thì sẽ bị lỗi vì nó đã lấy ra hết rồi

            // không làm được đoạn này đâu vì khi ghi object nó sẽ ở dạng mã hoá chứ ko phải dạng nhị phân
//            FileOutputStream fileOutputStream = new FileOutputStream("testbyte.txt");
//            int length = objectInputStream.read(bytes);
//            fileOutputStream.write(bytes,0,10);
//            System.out.println(length);

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static ArrayList<Student> readerDataFile(String path){
        ArrayList<Student> data = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            data = (ArrayList<Student>) objectInputStream.readObject();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return data;
    }
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeToFile("student1.txt", students);
//        readerFile("student1.txt");
        ArrayList<Student> data = readerDataFile("student1.txt");
        System.out.println(data);
    }

}
