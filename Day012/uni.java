
package Day012;

import java.util.*;

class course {
    String cName;
    int credits;

    course(String cName, int credits) {
        this.cName = cName;
        this.credits = credits;

    }

}

class prof {
    List courses;
    String name;

    prof(String name) {
        this.name = name;
        courses = new ArrayList();

    }

    void addCourse(course c) {
        courses.add(c);
    }

}

class department {
    String dname;
    List profs;

    department(String dname) {
        this.dname = dname;
        profs = new ArrayList();

    }

    void addProf(prof p) {
        profs.add(p);
    }

}

class university {
    List department;
    String uname;

    university(String uname) {
        department = new ArrayList();
        this.uname = uname;
    }

    void adddept(department d) {
        department.add(d);
    }

    void showUniversityDetails() {
        System.out.println("University: " + uname);
        for (Object deptObj : department) {
            department d = (department) deptObj;
            System.out.println(" Department: " + d.dname);
            for (Object profObj : d.profs) {
                prof p = (prof) profObj;
                System.out.println("  Professor: " + p.name);
                for (Object courseObj : p.courses) {
                    course c = (course) courseObj;
                    System.out.println("   Course: " + c.cName + " (" + c.credits + " credits)");
                }
            }
        }
    }
}

public class uni {
    public static void main(String[] args) {
        // create courses
        course java = new course("java Programming", 4);
        course dbms = new course("Database Sytem", 3);
        course ai = new course("Artificial  Intelligence", 5);
        course ml = new course("Machine Learning", 4);
        course ds = new course("Data Science", 3);
        course phy = new course("Physics", 2);
        course chem = new course("Chemistry", 2);

        // create proffesor and assign course
        prof prof_1 = new prof("dr. Sharma");
        prof_1.addCourse(java);
        prof_1.addCourse(dbms);
        prof prof_2 = new prof("dr. Patil");
        prof_2.addCourse(ai);
        prof_2.addCourse(ml);
        prof prof_3 = new prof("dr. gaikwad");
        prof_3.addCourse(ds);
        prof_3.addCourse(phy);
        prof_3.addCourse(chem);

        // Create the departments and assign professors.
        department cse = new department("COMP ENGG");
        cse.addProf(prof_1);
        cse.addProf(prof_2);
        department aids = new department("AI & DATA SCIENCE");
        aids.addProf(prof_2);
        aids.addProf(prof_3);
        department entc = new department("Electronics & Telecommunication");
        entc.addProf(prof_1);
        entc.addProf(prof_3);
        entc.addProf(new prof("dr. kulkarni"));

        // Create universities and assign departments.
        university pune = new university("Pune University");
        pune.adddept(cse);
        pune.adddept(entc);
        pune.adddept(aids);
        university sola = new university("Solapur University");
        sola.adddept(aids);
        sola.adddept(entc);

        pune.showUniversityDetails();
        sola.showUniversityDetails();
    }
}
