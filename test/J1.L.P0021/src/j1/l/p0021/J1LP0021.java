/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class J1LP0021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choice=0;
        StudentList obj=new StudentList();
        Scanner sc=new Scanner(System.in);
        do 
        {
            System.out.println("---------------------");
            System.out.println("1. Create.");
            System.out.println("2. Find and sort.");
            System.out.println("3. Update and delete.");
            System.out.println("4. Report.");
            System.out.println("5. Exit.");
            boolean tiep = true;
            while(tiep)
            {
                try
                {
                    sc=new Scanner(System.in);
                    System.out.println("Enter your choice: ");
                    choice=sc.nextInt();
                    if(choice>5 || choice<1)
                        throw new Exception("Choose from 1 to 5!");
                    tiep=false;
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
            switch(choice)
            {
                case 1:
                    String choice1 = null ;
                    for(int i=0; i<3; i++)                      
                        obj.addStudent();
                    do
                    {
                        tiep=true;
                        while(tiep)
                        {
                            try
                            {
                                sc=new Scanner(System.in);
                                System.out.println("Do you want to continue (Y/N)?:  ");
                                choice1=sc.nextLine().toUpperCase();
                                if (choice1.isEmpty())
                                    throw new Exception("Choice can't be a null value!");
                                else if (!(choice1.equals("Y") || choice1.equals("N")))
                                    throw new Exception("Choice must be Y or N!");                       
                                tiep = false;
                                if(choice1.equals("Y"))
                                    obj.addStudent();
                            } 
                            catch (Exception e) 
                            {
                                System.out.println(e.getMessage());
                            }
                        }
                    }                                                                     
                    while(choice1.equals("Y"));
                    System.out.println("\n");
                    break;
                    
                case 2:
                    String name1 = null;
                    obj.sortName();
                    tiep=true;
                    while(tiep)
                    {
                        try
                        {
                            sc=new Scanner(System.in);
                            System.out.println("Enter name to find: ");
                            name1=sc.nextLine();
                            if (name1.isEmpty())
                                throw new Exception("Name can't be a null value!");                                                    
                            tiep = false;                              
                        } 
                        catch (Exception e) 
                        {
                            System.out.println(e.getMessage());
                        }
                    }                    
                    System.out.println("Students after found and sorted by name: ");
                    obj.findName(name1);   
                    System.out.println("\n");
                    break;
                    
                case 3:
                    int id1 = 0;
                    String choice2 = null;                   
                    tiep=true;
                    while(tiep)
                    {
                        try
                        {
                            sc=new Scanner(System.in);
                            System.out.println("Enter ID to find: ");
                            id1=sc.nextInt();
                            if (id1<=0)
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
                    if(obj.findId(id1)==-1)
                        System.out.println("Not found!");
                    else
                    {
                        System.out.println("Found!");
                        tiep=true;
                        while(tiep)
                        {
                            try
                            {
                                sc=new Scanner(System.in);
                                System.out.println("Do you want to update (U) or delete (D) student?: ");
                                choice2=sc.nextLine().toUpperCase();
                                if (choice2.isEmpty())
                                    throw new Exception("Choice can't be a null value!");
                                else if (!(choice2.equals("U") || choice2.equals("D")))
                                    throw new Exception("Choice must be U or D!");                       
                                tiep = false;                         
                            } 
                            catch (Exception e) 
                            {
                                System.out.println(e.getMessage());
                            }
                        }                        
                        if(choice2.equals("U"))
                        {
                            obj.updateStudent(id1);
                            System.out.println("Updated!");
                        }
                        else
                        {
                            obj.deleteStudent(id1);
                            System.out.println("Deleted!");
                        } 
                    }
                    System.out.println("\n");
                    break;
                    
                case 4:
                    obj.report();
                    System.out.println("\n");
                    break;
            }
        }
        while(choice!=5);
    }
    
}
