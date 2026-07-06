package com.revature.exceptions;

public class UnCheckedDemo {
    public static void main(String[] args) {

        int [] myArray = new int[5];
        // try {
        //     myArray[5] = 10;
        //     System.out.println(myArray[5]);
        // } catch (ArithmeticException e) {
        //     e.printStackTrace();
        // } catch (ArrayIndexOutOfBoundsException e) {
        //     e.printStackTrace();
        // }
        //     System.out.println("Program Ends ...............");

        
        try {
            myArray[5] = 10;
            System.out.println(myArray[5]);
        // }catch (ArrayIndexOutOfBoundsException e) {
        //     e.printStackTrace();
        // } catch (ArithmeticException e) {
        //     e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            System.err.println("Finally......");
        }
            System.out.println("Program Ends ...............");



        // # try {
        // #     myArray[5]=10;
        // #     System.out.println(myArray[5]);
        // # } catch(ArithmeticException e) {
        // #     e.printStackTrace();
        // # }catch(ArrayIndexOutOfBoundsException e) {
        // #     System.out.println("Program ends here ... ");
        // # }


        // # try {
        // #     myArray[5]=10;
        // #     System.out.println(myArray[5]);
        // # } catch(ArrayIndexOutOfBoundsException e) {
        // #     e.printStackTrace();
        // # }catch(Exception e) {
        // #     System.out.println("Use original Exception in the last block here only ");
        // # }


        // try {
        //     myArray[5]=10;
        //     System.out.println(myArray[5]);
        // } catch(ArithmeticException e | ArrayIndexOutOfBoundsException e) {
        //     e.printStackTrace();
        //     System.out.println(e.getMessage());
        // }catch(Exception e) {
        //     System.out.println("Use original Exception in the last block here only ");
        // } finally {
        //     System.out.println("Finally");
        // }

        System.out.println("Program gets terminated before this line is printed & executed");


        
    }
}