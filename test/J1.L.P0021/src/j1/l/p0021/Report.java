/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

/**
 *
 * @author PC
 */
public class Report implements Comparable<Report>{
    private String name;
    private String course;
    private int count;

    public Report(String name, String course, int count) {
        this.name = name;
        this.course = course;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    @Override
    public int compareTo(Report o) {
        if(this.name.compareTo(o.name)==0)
            return this.course.compareTo(o.course);
        else
            return this.name.compareTo(o.name);
    }
    
    
}
