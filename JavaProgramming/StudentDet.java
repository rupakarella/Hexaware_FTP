import S.Student;
class StudentDet
{
	public static void main(String []ar)
	{
 
        	int sid = Integer.parseInt(ar[0]);
        	String sname = ar[1];
		int m1 = Integer.parseInt(ar[2]);
		int m2 = Integer.parseInt(ar[3]);
		int m3 = Integer.parseInt(ar[4]);
 		Student s = new Student(sid, sname, m1, m2, m3);
       

        	// Display results
        	System.out.println("\nStudent Details:");
        	System.out.println("Student ID: " + s.getSid());
        	System.out.println("Student Name: " + s.getSname());
        	System.out.println("Total Marks: " + s.total());
        	System.out.println("Average Marks: " + s.average());
        	System.out.println("Grade: " + s.Grade());
	}
}