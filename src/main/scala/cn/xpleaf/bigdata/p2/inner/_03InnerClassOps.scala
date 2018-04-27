package cn.xpleaf.bigdata.p2.inner

/**
  * 事物的内部还包含着事物，被包含的事物不能使用非常简单的成员变量来描述，只能使用更为复杂的结构去描述，
  * 这个时候就用我们的内部类去定义
  *
  * 当多个变量重名的时候，遵循一个原则：局部优先
    public class InnerClassOps {
        public static void main(String[] args) {
            Outer.Inner i = new Outer().new Inner();
            i.show();
        }
    }
    class Outer {
        private int x = 5;

        class Inner {
            private int x = 6;
            public void show() {
                int x = 7;
                System.out.println("Inner show: " + x);
            }
        }
    }

  this关键字，是本类的引用，当前类的实例的引用
  外部类的引用使用外部类名.this
  scala同样提供了一种较为简洁的写法，就是在我们的最外层大括号里写一个引用名称outer =>
  在内部类中需要调用外部类的成员的时候，直接使用outer.成员代替外部类名.this
  */
object _03InnerClassOps {
  def main(args: Array[String]): Unit = {
    val outer = new Outer
    val inner = new outer.Inner
    inner.show()
  }
}

class Outer { o =>
  private val x = 5

  class Inner { i =>
    private var x = 6
    def show(): Unit = {
      val x = 7
      println("Inner show: " + this.x)  // 6
      println("Inner show: " + i.x)     // 6
      println("Inner show: " + Outer.this.x)  // 5
      println("Inner show: " + o.x)           // 5
    }
  }
}
