import java.util.*;
class StudentGradeCal{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
System.out.println("Enter the number of subjects");
int n=sc.nextInt();
int totalMarks=0;
for(int i=1;i<=n;i++){
System.out.println("Enter the marks obtained in subjects");
int marks=sc.nextInt();
totalMarks=totalMarks+marks;
}
double averagePercentage=totalMarks/n;
System.out.println("Total marks:"+totalMarks);
System.out.println("Average percemtage:"+averagePercentage+ "%");
System.out.println("Grade:"+calculateGrade(averagePercentage));
}
public static String calculateGrade(double percentage){
if(percentage>=90){
return "A";
}else if(percentage>=80){
return "B";
}
else if(percentage>=70){
return "C";
}
else if(percentage>=60){
return "D";
}
else if(percentage>=50){
return "E";
}
else {
return "F";
}
}
}
