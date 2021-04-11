/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

import java.util.Comparator;

/**
 *
 * @author PC
 */
public class Student {
    int id;
    String name;
    int semester;
    String course;

    public Student(int id, String name, int semester, String course) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "{" + "ID: " + id + " - Name: " + name + " - Semester: " + semester + " - Course: " + course + '}';
    }
    
    public static Comparator<Student> Name=new Comparator<Student>()
    {
        @Override
        public int compare(Student o1, Student o2)
        {
            if(o1.getName().compareTo(o2.getName())>0)
                return 1;
            else if(o1.getName().compareTo(o2.getName())<0)
                return -1;
            return 0;
        }
    };
    
}
