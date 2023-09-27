package ra.model;

import java.util.Date;
import java.util.Scanner;

public class Student {
    public static int nextId = 1;
    private int studentId;
    private String studentName;
    private String birthDay ;
    private String address;
    private boolean gender;
    private String phone;

    public Student() {
        this.studentId=nextId++;
    }
    public Student(int studentId, String studentName, String birthDay, String address, boolean gender, String phone ){
        this.studentId=studentId;
        this.studentName=studentName;
        this.birthDay=birthDay;
        this.address=address;
        this.gender=gender;
        this.phone=phone;
    }

    public int getStudentId(){
        return studentId;
    }
    public void setStudentId(int studentId){
        this.studentId=studentId;
    }

    public String getStudentName(){
        return studentName;
    }
    public void setStudentName(String studentName){
        this.studentName=studentName;
    }
    public String getBirthDay(){
        return birthDay;
    }
    public void setBirthDay(String birthDay){
        this.birthDay=birthDay;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public boolean isGender(){
        return gender;
    }
    public void setGender(boolean gender){
        this.gender=gender;
    }
    public void inputData(Scanner scanner){
        boolean isExit = true;
        System.out.println("Nhập tên sinh viên");
        do{
            this.studentName=scanner.nextLine();
            if(this.studentName.length()>0){
                break;
            }else{
                System.out.println("Tên không được bỏ trống");
            }
        }while (isExit);

        System.out.println("Nhập ngày sinh");
        do{
            this.birthDay=scanner.nextLine();
            if(this.birthDay.matches("(0[1-9]|1[0-9]|2[0-9]|3[0-1]|[1-9])/(0[1-9]|1[0-2]|[1-9])/([0-9]{4})")){
                break;
            }else {
                System.out.println("ngày sinh không được bỏ trống");
            }
        }while (isExit);

        System.out.println("Nhập địa chỉ");
        do{
            this.address=scanner.nextLine();
            if(this.address.length()>0){
                break;
            }else{
                System.out.println("địa chỉ không được bỏ trống");
            }
        }while (isExit);

        System.out.println("Nhập số điện thoại");
        do{
            this.phone=scanner.nextLine();
            if(this.phone.matches("^0[0-9]{9,10}$")){
                break;
            }else {
                System.out.println("phone không được bỏ trống");
            }
        }while (isExit);

        System.out.println("Nhập vào giới tính");
        boolean check =true;
        while (check){
            String sex = scanner.nextLine();
            if (sex.equals("Nam")){
                this.gender=true;
                check=false;
            }else if (sex.equals("Nữ")) {
                this.gender=false;
                check=false;


            }else {
                System.out.println("Nhập lại giới tính");
            }

        }
    }
    public void displayData(){
        System.out.printf("Mã sinh viên: %d - Tên sinh viên: %s - Ngày sinh: %s - Địa chỉ: %s - Phone: %s - Giới tính: %s\n", this.studentId, this.studentName, this.birthDay, this.address, this.phone, this.gender ? "Nam" : "nữ");
    }
}
