package org.ulco;

public class ID {

    private ID()
    {


    }



    public static int instance(){
                if (instance  !=null) {
                    instance = new ID();
                }
           ID=++ID;


        return ID;
    }

    static public int ID = 0;
    private static ID instance;
}