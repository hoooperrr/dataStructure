package com.other;

/*define a class*/
class MyDate{
    String  Year;
    String  Month;
    String  Day;
    String  Date;
    public MyDate(){
        Year = "1900";
        Month ="01";
        Day = "01";
        Date = Year + "." + Month + "."+ Day;
    }
    public String toString(){
        return Date;
    }
}

public class ObjRef{
    MyDate mydate1 = new MyDate();
    MyDate mydate2 = mydate1;// = 使 mydate1和 mydate2将指向同一内存空间
    //MyDate mydate2 = new MyDate();//从新new一个对象，则mydate1和mydate2是指向不同的内存空间的：
    //引用空/间和数据空间都不一样
    public void changeObj(MyDate inObj){
        inObj.Date = "2007.09.26";
    }

    public static void main(String[] args) {
        ObjRef oRef = new ObjRef();
        System.out.println("Before call changeObj() method: " + oRef.mydate1);
        oRef.changeObj(oRef.mydate1);
        System.out.println("After call changeObj() method: " + oRef.mydate1);
        System.out.println("After call changeObj() method: " + oRef.mydate2);//验证“= mydate1和 mydate2将指向同一内存空间“这一结论

    }
}
