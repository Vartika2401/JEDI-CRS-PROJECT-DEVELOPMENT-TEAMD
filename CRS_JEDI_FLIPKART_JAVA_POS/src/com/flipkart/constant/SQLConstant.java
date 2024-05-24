package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.constant;
public class SQLConstant {
    public static final String GET_COURSE_APPROVAL = "select courseid,enrolledstud from courses where approvalstatus= 0";
    public static final String UPDATE_APPROVAL_STATUS = "UPDATE courses SET approvalstatus = 1 WHERE courseid = ?";
    public static final String GET_COURSE_DETAILS = "select * from courses where courseid = ?";
    public static final String ADD_COURSE = "INSERT INTO courses(courseid, coursename, prereq, coursedept) VALUES(?,?,?,?)";
    public static final String DELETE_COURSE = "DELETE FROM courses WHERE courseid = ?";
    public static final String GET_ENROLLED_STUDENTS = "select courseid,enrolledstud from courses where approvalstatus= 0";
    public static final String GET_STUDENT_GRADES = "SELECT * from grades WHERE studentid=? and courseid=?";
    public static final String GET_FEES = "SELECT * from fees_requirement WHERE semno=?";
    public static final String INSERT_PAYMENT_ONLINE = "INSERT INTO payments(studentid,semno,paymentamount,paymentmode) VALUES(?,?,?,'online')";
    public static final String INSERT_PAYMENT_OFFLINE = "INSERT INTO payments(studentid,semno,paymentamount,paymentmode) VALUES(?,?,?,'offline')";
    public static final String GET_PROF = "SELECT * FROM prof LEFT JOIN user ON prof.profid = user.id WHERE prof.profid = ?";
    public static final String SHOW_FREE_COURSES = "SELECT courseid,coursename,prereq,coursedept FROM courses WHERE courses.c_profid IS NULL";
    public static final String SELECT_COURSE = "SELECT selectedcourses FROM prof WHERE profid = ?";
    public static final String UPDATE_PROF_COURSE = "UPDATE prof SET selectedcourses = ? WHERE profid = ?";
    public static final String UPDATE_CPROF = "UPDATE courses SET c_profid = ? WHERE courseid = ?";
    public static final String GET_COURSE_ID_FROM_PROF = "SELECT courseid FROM courses WHERE courses.c_profid = ?";
    public static final String ENROLLED_STUDENTS_IN_A_COURSE = "SELECT enrolledstud FROM courses WHERE courses.courseid = ?";
    public static final String GET_ID_NAME = "SELECT id,name,department FROM user LEFT JOIN student ON user.id=student.studentid WHERE user.id = ?";
    public static final String GET_COURSE_COUNT = "SELECT COUNT(*) FROM courses WHERE courses.courseid=? and courses.c_profid = ?";
    public static final String ENROLLED_STUDENTS_BY_PROF = "SELECT enrolledstud FROM courses WHERE courses.courseid= ? and courses.c_profid = ?";
    public static final String GET_STUDENT = "SELECT * FROM student LEFT JOIN user ON student.studentid = user.id WHERE student.studentid = ?";
    public static final String SHOW_COURSES = "SELECT profid,courseid,coursename,prereq,coursedept FROM prof LEFT JOIN courses ON courses.c_profid = prof.profid WHERE courses.c_profid IS NOT NULL";
    public static final String SHOW_ENROLLED_COURSES = "SELECT enrolledcourses FROM student WHERE studentid = ?";
    public static final String UPDATE_ENROLLED_COURSES = "UPDATE student SET enrolledcourses = ? WHERE studentid = ?";
    public static final String UPDATE_COURSE_SET = "UPDATE courses SET enrolledstud = ? WHERE courseid = ?";
    public static final String USER_COUNT = "SELECT COUNT(*) FROM user";
    public static final String ADD_STUDENT_IN_STUDENT = "INSERT INTO student(studentid,department) VALUES(?,?)";
    public static final String ADD_STUDENT_IN_USER = "INSERT INTO user(id,name,contact,email,password) VALUES(?,?,?,?,?)";
    public static final String ADD_STUDENT_IN_USER_ROLES = "INSERT INTO user_roles(userid,role) VALUES(?,?)";
    public static final String CHECK_PASSWORD = "SELECT * FROM user WHERE id = ? AND password = ?";
    public static final String UPDATE_PASSWORD = "UPDATE user SET password = ? WHERE id = ?";
    public static final String GET_USER_ROLE_NAME = "SELECT role,name FROM user_roles LEFT JOIN user ON user_roles.userid=user.id WHERE userid = ?";
}