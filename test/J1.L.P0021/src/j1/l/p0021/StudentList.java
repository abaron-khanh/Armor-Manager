/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class StudentList {
    ArrayList <Student> list;
    
    public StudentList()
    {
        list=new ArrayList();
    }
    
    public void addStudent()
    {
        String name = null;
        int id = 0;
        int semester = 0;
        String course = null;
        boolean tiep=true;
        Scanner sc=new Scanner(System.in);
        while(tiep)
        {
            try
            {
                System.out.println("Enter name: ");
                name=sc.nextLine();
                if (name.isEmpty())
                    throw new Exception("Name can't be a null value!");                                                    
                tiep = false;                              
            } 
            catch (Exception e) 
            {
                System.out.println(e.getMessage());
            }
        }                    
        tiep=true;
        while(tiep)
        {
            try
            {
                sc = new Scanner(System.in);
                System.out.println("Enter ID: ");
                id=sc.nextInt();
                if (id<=0)
                    throw new Exception("ID must be greater than 0!");                                                    
                tiep = false;                              
            } 
            catch(InputMismatchException e)
            {
                System.out.println("Number only!");
            }
            catch(Exception ee)
            {
                System.out.println(ee.getMessage());
            }
        }
        tiep=true;
        while(tiep)
        {
            try
            {
                sc = new Scanner(System.in);
                System.out.println("Enter semester: ");
                semester=sc.nextInt();
                if (semester<=0)
                    throw new Exception("Semester must be greater than 0!");                                                    
                tiep = false;                              
            } 
            catch(InputMismatchException e)
            {
                System.out.println("Number only!");
            }
            catch(Exception ee)
            {
                System.out.println(ee.getMessage());
            }
        }
        tiep=true;
        while(tiep)
        {
            try
            {
                sc = new Scanner(System.in);
                System.out.println("Enter course('Java' or '.NET' or 'C/C++'): ");
                course=sc.nextLine();
                if (course.isEmpty())
                    throw new Exception("Course can't be a null value!");
                else if(!(course.equals("Java") || course.equals(".NET") || course.equals("C/C++")))
                    throw new Exception("Course doesn't match!");
                tiep = false;                              
            } 
            catch (Exception e) 
            {
                System.out.println(e.getMessage());
            }
        }            
        Student b=new Student(id, name, semester, course);
        list.add(b);
        System.out.println("Added! \n");                            
    }
    
    public void displayAll()
    {
        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i).toString());
    }
    
    public void findName(String name)
    {
        for(int i=0; i<list.size(); i++)
        {
            if(list.get(i).getName().contains(name))
                System.out.println(list.get(i).toString());
        }    
    }
    
    public void sortName()
    {
        Collections.sort(list, Student.Name);
    }
    
    public int findId(int id)
    {
        for(int i=0; i<list.size(); i++)
        {
            if(list.get(i).getId()==id)
                return i;
        }
        return -1;
    }
    
    public void updateStudent(int id)
    {
        int pos=findId(id);
        String newname;
        int newsemester;
        String newcourse;
        boolean tiep=true;
        Scanner sc=new Scanner(System.in);
        if(pos>=0)
        {   
            while(tiep)
            {
                try
                {
                    System.out.println("Enter student's name: ");
                    newname=sc.nextLine();
                    if (newname.isEmpty())
                        throw new Exception("Name can't be a null value!");  
                    list.get(pos).setName(newname);
                    tiep = false;                              
                } 
                catch (Exception e) 
                {
                    System.out.println(e.getMessage());
                }
            }                    
            tiep=true;
            while(tiep)
            {
                try
                {
                    sc = new Scanner(System.in);
                    System.out.println("Enter semester: ");
                    newsemester=sc.nextInt();
                    if (newsemester<=0)
                        throw new Exception("Semester must be greater than 0!");
                    list.get(pos).setSemester(newsemester);
                    tiep = false;                              
                } 
                catch(InputMismatchException e)
                {
                    System.out.println("Number only!");
                }
                catch(Exception ee)
                {
                    System.out.println(ee.getMessage());
                }
            }
            tiep=true;
            while(tiep)
            {
                try
                {
                    sc = new Scanner(System.in);
                    System.out.println("Enter course('Java' or '.NET' or 'C/C++'): ");
                    newcourse=sc.nextLine();
                    if (newcourse.isEmpty())
                        throw new Exception("Course can't be a null value!"); 
                    else if(!(newcourse.equals("Java") || newcourse.equals(".NET") || newcourse.equals("C/C++")))
                    throw new Exception("Course doesn't match!");
                    list.get(pos).setCourse(newcourse);
                    tiep = false;                              
                } 
                catch (Exception e) 
                {
                    System.out.println(e.getMessage());
                }
            }               
        }
    }
    
    public void deleteStudent(int id)
    {
        int pos=findId(id);
        list.remove(pos);         
    }
     
    public void report()
    {
        int count;
        ArrayList<Report> course = new ArrayList<>();
        ArrayList<Student> java = new ArrayList<>();
        ArrayList<Student> net = new ArrayList<>();
        ArrayList<Student> c = new ArrayList<>();
        for (Student student : list) 
        {
            if(student.getCourse().equals("Java"))
                java.add(student);
            else if(student.getCourse().equals(".NET"))
                net.add(student);
            else
                c.add(student);
        }
        for(int i=0; i<java.size(); i++)
        {
            count=1;
            for(int j=i; j<java.size(); j++)
            {
                if(i!=j && java.get(i).getName().equals(java.get(j).getName()) && java.get(i).getId() == java.get(j).getId())
                {
                    count++;
                    java.remove(j);
                    j=j-1;
                }
                else
                    continue;
            }
            course.add(new Report(java.get(i).getName(), "Java", count));
        }
        for(int i=0; i<net.size(); i++)
        {
            count=1;
            for(int j=i; j<net.size(); j++)
            {
                if(i!=j && net.get(i).getName().equals(net.get(j).getName()) && net.get(i).getId() == net.get(j).getId())
                {
                    count++;
                    net.remove(j);
                    j=j-1;
                }
                else
                    continue;
            }
            course.add(new Report(net.get(i).getName(), ".NET", count));
        }
        for(int i=0; i<c.size(); i++)
        {
            count=1;
            for(int j=i; j<c.size(); j++)
            {
                if(i!=j && c.get(i).getName().equals(c.get(j).getName()) && c.get(i).getId() == c.get(j).getId())
                {
                    count++;
                    c.remove(j);
                    j=j-1;
                }
                else
                    continue;
            }
            course.add(new Report(c.get(i).getName(), "C/C++", count));
        }
        Collections.sort(course);
        for(int i=0; i<course.size(); i++)
        {
            System.out.println(course.get(i).getName() + " | " + course.get(i).getCourse() + " | " + course.get(i).getCount());
        }
    }
}
