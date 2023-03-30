package xmlconfiguration.main;

public class ExecutionXMLConfigurationHibernateMain {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        //create session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //adding/inserting student info
        //addStudentAndDepartment(sessionFactory);

        //fetching student Info
        fetchStudentInfo(sessionFactory);

        //update Student info
        //updateStudentInfo(sessionFactory);

        //delete student info
        //deleteStudentInfo(sessionFactory);
    }

    public static void addStudentAndDepartment(SessionFactory sessionFactory) {
        //create a session
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
           /* transaction = session.beginTransaction();
            //adding a new student
            Student student = new Student();
            student.setStudName("A");
            student.setRollNumber(12);
            student.setAddress("USA");
            //insert into student values (1, 'A', 12)
            //session.save(student);

            //adding a new department
            Department department = new Department();
            department.setDeptName("Science");
            department.setDeptCode(10);
            department.setStudent(student);
            session.save(department);

            Student student1 = new Student();
            student1.setStudName("B");
            student1.setRollNumber(14);
            student1.setAddress("INDIA");

            Department department1 = new Department();
            department1.setDeptName("Commerce");
            department1.setDeptCode(11);
            department1.setStudent(student1);
            session.save(department1);
*/
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Error Message ::" + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        Session session1 = sessionFactory.openSession();
        Transaction transaction1 = null;
        try {
            transaction1 = session1.beginTransaction();

          /*  Student student2 = new Student();
            student2.setStudName("C");
            student2.setRollNumber(15);
            student2.setAddress("NEPAL");

            Department department3 = new Department();
            department3.setDeptName("Arts");
            department3.setDeptCode(11);
            department3.setStudent(student2);
            session1.save(department3);

            Student student3 = new Student();
            student3.setStudName("D");
            student3.setRollNumber(18);
            student3.setAddress("PARIS");
            session1.save(student3);

            Student student4 = new Student();
            student4.setStudName("E");
            student4.setRollNumber(20);
            student4.setAddress("SWISS");
            session1.save(student4);

            Department department4 = new Department();
            department4.setDeptName("Engineering");
            department4.setDeptCode(30);
            session1.save(department4);*/

            transaction1.commit();
        } catch (Exception e) {
            System.err.println("Error Message adding::" + e.getMessage());
            if (transaction1 != null) {
                transaction1.rollback();
            }
        } finally {
            if (session1 != null) {
                session1.close();
            }
        }
    }

    public static void fetchStudentInfo(SessionFactory sessionFactory) {
        //Initialize the session
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            /*Student student = session.get(Student.class, 1);
            System.out.println("Fetched Student Info ::"+student.getStudName());*/
           /* Department department = session.get(Department.class, 4);
            System.out.println(department.getDeptName());
            Student student = department.getStudent();
            System.out.println(student.getStudName() + " " + student.getAddress());*/
        } catch (Exception e) {
            System.err.println("Error details fetch:" +e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void updateStudentInfo(SessionFactory sessionFactory) {
        //Initialize session
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
           /* Student student = (Student) session.get("xmlconfiguration.entity.Student", 4); // entire row from student_info table corresponding to stud_id 4
            student.setStudName("U");
            session.update(student);

            Department department = (Department) session.get("xmlconfiguration.entity.Department", 4);
            department.setStudent(student);
            session.saveOrUpdate(department);*/

            transaction.commit();
            /*Student student = new Student();
            student.setStudId(2);
            student.setStudName("T");
            student.setRollNumber(23);
            //session.save(student);
            //session.update(student);
            session.saveOrUpdate(student);*/
        } catch (Exception e) {
            System.err.println("Error details update::" +e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void deleteStudentInfo(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
          /*  Department department = session.get(Department.class, 3);
            session.delete(department);*/
            /*
            Student student = session.get(Student.class, 3);
            session.delete(student);*/
            tx.commit();
        } catch (Exception e) {
            System.err.println("Error details delete:" +e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
