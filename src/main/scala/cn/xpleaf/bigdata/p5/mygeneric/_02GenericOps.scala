package cn.xpleaf.bigdata.p5.mygeneric

/**
  * scala类型参数的协变和逆变
  *     scala默认不支持协变和逆变
  *         要想让scala的泛型支持协变，在泛型前面再加一个"+"
  *         要想让scala的泛型支持逆变，在泛型前面再加一个"-"
  *     但是一个类不能同时支持协变和逆变
  */
object _02GenericOps {
    def main(args: Array[String]): Unit = {
        /*
        val list:List[Person] = List[Person]()  // 正常的定义

        val list1:List[Person] = List[Student]()    // scala中的协变，java不支持
        // val list2:List[Teacher] = List[Person]()    // 逆变，java不支持，但是scala需要在定义泛型类的时候指定
        */

        val myList1:MyList[Person] = new MyList[Person]()
        val myList2:MyList[Person] = new MyList[Student]()

        val yourList1:YourList[Person] = new YourList[Person]()
        val yourList2:YourList[Student] = new YourList[Person]()
    }

    class Person{}
    class Student extends Person{}
    class Teacher extends Person{}

    /**
      * 支持协变的泛型类
      */
    class MyList[+T] {

    }

    /**
      * 支持逆变的泛型类
      */
    class YourList[-T] {

    }

}
