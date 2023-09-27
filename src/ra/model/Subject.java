package ra.model;
import java.util.Scanner;
public class Subject {
    private String subjectId;
    private String subjectName;
    public Subject() {
    }
    public Subject(String subjectId, String subjectName){
        this.subjectId=subjectId;
        this.subjectName=subjectName;
    }

    public String getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }
    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void inputData(Scanner scanner){
        boolean isExit = true;
        System.out.println("Nhập Mã Môn học");
        do{
            this.subjectId=scanner.nextLine();
            if(this.subjectId.matches("^MH[a-z]{5}[0-9]{3}$")){
                break;
            }else {
                System.out.println("mã môn học thiếu");
            }
        }while (isExit);

        System.out.println("Nhập Tên môn học");
        do{
            this.subjectName=scanner.nextLine();
            if(this.subjectName.length()>0){
                break;
            }else{
                System.out.println("Tên không được bỏ trống");
            }
        }while (isExit);
    }

    public void displayData(){
        System.out.printf("Mã Môn học: %s - Tên Môn học: %s \n", this.subjectId , this.subjectName );
    }
}
