//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;

public class Projectsem4 {
    public Projectsem4() {
    }

    public static void main(String[] var0) {
        Scanner var1 = new Scanner(System.in);
        Calendar var2 = Calendar.getInstance();
        String[] var3 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        System.out.println("Hello Welcome to Employee management System");
        PrintStream var10000 = System.out;
        int var10001 = var2.get(5);
        var10000.print("DATE : " + var10001 + "/" + var3[var2.get(2)] + "/" + var2.get(1));
        var10000 = System.out;
        var10001 = var2.get(10);
        var10000.print("\t\t\t\t\t\t\t\t\tTIME :" + var10001 + "-" + var2.get(12));

        for(int var4 = 1; var4 == 1; var4 = var1.nextInt()) {
            System.out.println("\n 1.Employee Management\t\t 2.Personal Details");
            int var5 = var1.nextInt();
            int var6;
            int var7;
            label42:
            switch(var5) {
            case 1:
                System.out.println("Employee Management");
                var6 = 1;

                while(true) {
                    if (var6 != 1) {
                        break label42;
                    }

                    System.out.println("1. ADD NEW ENTRY \t\t\t 2.EXISTING EMPLOYEE\t\t\t 3.Delete Record");
                    var7 = var1.nextInt();
                    switch(var7) {
                    case 1:
                        insert(1);
                        break;
                    case 2:
                        System.out.println("EMP ID\t EMP_DESIGNATION\t BASIC SALARY\t DA\t TA\t HRA\t PF\t GRATUITY\t GROSS SALARY");
                        oraclecon(1);
                        break;
                    case 3:
                        Delete(1);
                    }

                    System.out.println("If YOU WANT TO GO BACK TO EMPLOYEE SECTION PRESS 1 \n IF YOU WANT TO GO BACK TO MAIN MENU PRESS ANY NUMBER");
                    var6 = var1.nextInt();
                }
            case 2:
                System.out.println("Personal Details");

                for(var6 = 1; var6 == 1; var6 = var1.nextInt()) {
                    System.out.println("1. ADD NEW ENTRY PERSONAL DETAILS \t\t\t 2.EXISTING EMPLOYEE PERSONAL DETAILS \t\t\t 3.Delete Record");
                    var7 = var1.nextInt();
                    switch(var7) {
                    case 1:
                        insert(2);
                        break;
                    case 2:
                        System.out.println("EMP_ID\t EMP_NAME\t EMP_DESIGNATION\t EMAIL\t PHONE NO\t DOB\t BLOOD GROUP\t ADDRESS\t EMERGENCY CONTACT");
                        oraclecon(2);
                        break;
                    case 3:
                        Delete(2);
                    }

                    System.out.println("If YOU WANT TO GO BACK TO PERSONAL DETAILS PRESS 1 \n IF YOU WANT TO GO BACK TO MAIN MENU PRESS ANY NUMBER");
                }
            }

            System.out.println("If you want to go back to the main menu press 1: \nIf you want to EXIT press any other key: ");
        }

    }

    public static void oraclecon(int var0) {
        try {
            Connection var1;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            var1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            Statement var2 = var1.createStatement();
            PrintStream var10000;
            int var10001;
            ResultSet var3;
            label27:
            switch(var0) {
            case 1:
                System.out.println("\n");
                var3 = var2.executeQuery("select * from emp_Management");

                while(true) {
                    if (!var3.next()) {
                        break label27;
                    }

                    var10000 = System.out;
                    var10001 = var3.getInt(1);
                    var10000.println(var10001 + "\t " + var3.getString(2) + "\t " + var3.getString(3) + "\t " + var3.getInt(4) + "\t " + var3.getInt(5) + "\t " + var3.getInt(6) + "\t " + var3.getInt(7) + "\t " + var3.getInt(8) + "\t " + var3.getInt(9) + "\t " + var3.getInt(10));
                }
            case 2:
                System.out.println("\n");
                var3 = var2.executeQuery("select * from emp_PersonalDetails");

                while(var3.next()) {
                    var10000 = System.out;
                    var10001 = var3.getInt(1);
                    var10000.println(var10001 + "\t " + var3.getString(2) + "\t " + var3.getString(3) + "\t " + var3.getString(4) + "\t " + var3.getString(5) + "\t " + var3.getString(6) + "\t " + var3.getString(7) + "\t " + var3.getString(8) + "\t " + var3.getString(9));
                }
            }

            var1.close();
        } catch (Exception var4) {
            System.out.println(var4.getMessage());
        }

    }

    public static void insert(int var0) {
        String var1 = "jdbc:oracle:thin:@localhost:1521:xe";
        String var2 = "system";
        String var3 = "system";
        Scanner var4 = new Scanner(System.in);
        String var5;
        int var6;
        String var7;
        String var8;
        switch(var0) {
        case 1:
            System.out.println("enter Employee ID");
            var6 = var4.nextInt();
            System.out.println("Enter Employee Name");
            var7 = var4.next();
            System.out.println("enter Employee Designation");
            var8 = var4.next();
            System.out.println("enter Basic Salary");
            int var20 = var4.nextInt();
            System.out.println("enter DA");
            int var21 = var4.nextInt();
            System.out.println("enter TA");
            int var22 = var4.nextInt();
            System.out.println("enter HRA");
            int var23 = var4.nextInt();
            System.out.println("enter PF");
            int var24 = var4.nextInt();
            System.out.println("enter Gratuity");
            int var25 = var4.nextInt();
            System.out.println("enter Gross_Salary");
            int var15 = var4.nextInt();
            var5 = "insert into emp_Management values(" + var6 + ",'" + var7 + "','" + var8 + "'," + var20 + "," + var21 + "," + var22 + "," + var23 + "," + var24 + "," + var25 + "," + var15 + ")";
            break;
        case 2:
            System.out.println("enter Employee ID");
            var6 = var4.nextInt();
            System.out.println("Enter Employee Name");
            var7 = var4.next();
            System.out.println("enter Employee Designation");
            var8 = var4.next();
            System.out.println("Enter Email of the employee");
            String var9 = var4.next();
            System.out.println("enter Employee Phone no");
            String var10 = var4.next();
            System.out.println("Enter DOB of the employee");
            String var11 = var4.next();
            System.out.println("Enter Blood group of the employee");
            String var12 = var4.next();
            System.out.println("Enter Address of the employee");
            String var13 = var4.next();
            System.out.println("enter Emergency Employee Phone no");
            String var14 = var4.next();
            var5 = "insert into emp_PersonalDetails values(" + var6 + ",'" + var7 + "','" + var8 + "','" + var9 + "','" + var10 + "','" + var11 + "','" + var12 + "','" + var13 + "','" + var14 + "')";
            break;
        default:
            throw new IllegalStateException("Unexpected Value: " + var0);
        }

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection var17 = DriverManager.getConnection(var1, var2, var3);
            Statement var18 = var17.createStatement();
            int var19 = var18.executeUpdate(var5);
            if (var19 == 1) {
                System.out.println("Inserted successfully" + var5);
            } else {
                System.out.println("Insertion failed" + var5);
            }

            var17.close();
        } catch (Exception var16) {
            System.out.println(var16.getMessage());
        }

    }

    public static void Delete(int var0) {
        String var1 = "jdbc:oracle:thin:@localhost:1521:xe";
        String var2 = "system";
        String var3 = "system";
        Scanner var5 = new Scanner(System.in);
        String var4;
        int var6;
        switch(var0) {
        case 1:
            System.out.println("enter Employee ID that need to be Deleted");
            var6 = var5.nextInt();
            var4 = "delete from emp_Management where EMP_ID=" + var6;
            break;
        case 2:
            System.out.println("enter Employee ID that need to be Deleted");
            var6 = var5.nextInt();
            var4 = "delete from emp_PersonalDetails where EMP_ID=" + var6;
            break;
        default:
            throw new IllegalStateException("Unexpected Value: " + var0);
        }

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection var10 = DriverManager.getConnection(var1, var2, var3);
            Statement var7 = var10.createStatement();
            int var8 = var7.executeUpdate(var4);
            if (var8 == 1) {
                System.out.println("Deletion Successfully :" + var4);
            } else {
                System.out.println("Deletion failed" + var4);
            }

            var10.close();
        } catch (Exception var9) {
            System.out.println(var9.getMessage());
        }

    }
}
