package ra.run;
import ra.model.Student;
import ra.model.Subject;

import java.util.Scanner;
public class SchoolManagement {
    private static Student[] students = new Student[1000];
    private static Subject[] subjects = new Subject[100];
    private static Scanner scanner = new Scanner(System.in);
    private static int currentIndex = 0;
    private static int subjectsIndex = 0;
    public static void main(String[] args) {
        do{
            System.out.println("========MENU=======");
            System.out.println("1.Quản lý học sinh");
            System.out.println("2.Quản lý môn học");
            System.out.println("3.Quản lí điểm thi");
            System.out.println("4.Thoát");
            int menu = Integer.parseInt(scanner.nextLine());
            switch (menu){
                case 1:
                    boolean exit1=true;
                    do {
                        System.out.println("Quản lý học sinh");
                        System.out.println("1.Thêm mới học sinh");
                        System.out.println("2.Hiển thị danh sách tất cả học sinh đã lưu trữ");
                        System.out.println("3.Thay đổi thông tin học sinh theo mã id");
                        System.out.println("4.Xóa học sinh theo mã id");
                        System.out.println("5.thoát");
                        int menu1 = Integer.parseInt(scanner.nextLine());
                        switch (menu1){
                            case 1:
                                System.out.print("Nhập số sinh viên cần thêm mới: ");
                                int studentAdd = Integer.parseInt(scanner.nextLine());
                                if(studentAdd + currentIndex < 1000){
                                    for (int i = currentIndex; i < studentAdd; i++) {
                                        students[currentIndex] = new Student();
                                        students[currentIndex].inputData(scanner);
                                        currentIndex++;
                                    }
                                }
                                break;
                            case 2:
                                if (currentIndex == 0) {
                                    System.out.println("Thư viện sách đang trống.");
                                    return;
                                }
                                for (int i = 0; i < currentIndex; i++) {
                                    students[i].displayData();
                                }
                                break;
                            case 3:
                                updateStudent(scanner);
                                break;
                            case 4:
                                deleteStudent();
                                currentIndex--;
                                break;
                            case 5:
                                System.exit(0);
                            default:
                                System.out.println("yêu cầu nhập từ 1--- 5");
                        }
                    }while (exit1);
                case 2:
                    boolean exit2=true;
                    do{
                        System.out.println("Quản lý môn học");
                        System.out.println("1.Thêm mới môn học");
                        System.out.println("2.Hiển thị danh sách tất cả môn học đã lưu trữ");
                        System.out.println("3.Thay đổi thông tin học môn học theo mã id");
                        System.out.println("4.Xóa môn học theo mã id");
                        System.out.println("5.thoát");
                        int menu2 = Integer.parseInt(scanner.nextLine());
                        switch (menu2){
                            case 1:
                                System.out.print("Nhập số môn học cần thêm mới: ");
                                int subjectsAdd = Integer.parseInt(scanner.nextLine());
                                if(subjectsAdd + subjectsIndex < 1000){
                                    for (int i = subjectsIndex; i < subjectsAdd; i++) {
                                        subjects[subjectsIndex] = new Subject();
                                        subjects[subjectsIndex].inputData(scanner);
                                        subjectsIndex++;
                                    }
                                }
                                break;
                            case 2:
                                if (subjectsIndex == 0) {
                                    System.out.println("Thư viện sách đang trống.");
                                    return;
                                }
                                for (int i = 0; i < subjectsIndex; i++) {
                                    subjects[i].displayData();
                                }
                                break;
                            case 3:
                                updateSubject(scanner);
                                break;
                            case 4:
                                deleteSubject();
                                subjectsIndex--;
                                break;
                            case 5:
                                System.exit(0);
                            default:
                                System.out.println("yêu cầu nhập từ 1--- 5");
                        }
                    }while (exit2);
                case 3:

                case 4:
                    System.exit(0);
                default:
                    System.out.println("yêu cầu nhập từ 1--- 4");

            }
        }while (true);
    }

    private static void updateStudent(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Thư viện sách đang trống.");
            return;
        }

        System.out.print("Nhập mã sinh viên cần cập nhật: ");
        int studenId = Integer.parseInt(scanner.nextLine());

        for (Student students : students) {
            if (students.getStudentId() == studenId) {
                students.inputData(scanner);
                System.out.println("Thông tin sinh viên đã được cập nhật.");
                return;
            }
        }

        System.out.println("Không tìm thấy sinh viên có mã " + studenId);
    }

    public static int indexSubUpdate(Subject[] subjects, String subjectId) {
        int index = -1;
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null && subjects[i].getSubjectId().equals(subjectId)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public static void updateSubject(Scanner sc){
        System.out.println("Nhập vào mã môn học");
        String subjectId=sc.nextLine();
        int indexUpdate=indexSubUpdate(subjects,subjectId);

        if (indexUpdate >= 0) {
            // môn học tồn tại trong danh sách
            System.out.println("Nhập thông tin mới cho môn học:");
            subjects[indexUpdate].inputData(scanner); // Gọi hàm để nhập thông tin mới
            System.out.println("Thông tin môn học đã được cập nhật.");
        } else {
            System.out.println("Môn học bạn muốn sửa không có trong danh sách");
        }
    }
    public static void deleteStudent(){
        System.out.println("Nhập mã sinh viên cần xoá");
        int deleteId = Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < currentIndex; i++) {
            if(students[i].getStudentId() == deleteId){
                index = i;
                break;
            }
        }
        if(index == -1 ){
            System.out.println("Mã sách không tìm thấy");
        }else {
            for (int i = 0; i < currentIndex; i++) {
                for (int j = deleteId; j < currentIndex - 1; j++) {
                    students[j] = students[j + 1];
                }
            }

        }
    }
    public static void deleteSubject() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã môn học bạn muốn xóa");
        String deleteId = sc.nextLine();
        int indexDelete = indexSubUpdate(subjects, deleteId);

        if (indexDelete == -1) {
            System.out.println("Mã môn học không có trong danh sách");
        } else {
            for (int i = 0; i < currentIndex-1; i++) {
                subjects[i]=subjects[i+1];
            }
            subjects[indexDelete] = null;
        }
    }
}
