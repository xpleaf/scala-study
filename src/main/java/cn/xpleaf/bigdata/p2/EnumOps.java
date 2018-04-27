package cn.xpleaf.bigdata.p2;

public class EnumOps {
    public static void main(String[] args) {
        /*TrafficLight green = TrafficLight.GREEN;
        TrafficLight red = TrafficLight.RED;
        TrafficLight yellow = TrafficLight.YELLOW;
        System.out.println(green);  // GREEN
        */
        Week mon1 = Week.MON;
        System.out.println(mon1);   // MON
        System.out.println(mon1.next());
        WeekDay mon2 = WeekDay.MON;
        System.out.println(mon2);   // MON
        System.out.println(mon2.next());
    }
}

/**
 * 创建java中的一个枚举
 * java中的枚举就是枚举类的一个在本类中定义的本类实例对象
 */
enum  TrafficLight {
    RED("RED"),
    YELLOW("YELLOW"),
    GREEN("GREEN");
    // private TrafficLight() {}
    String color;
    TrafficLight(String color) {
        this.color = color;
    }
}

/**
 * 枚举实现的一周
 */
enum Week {
    MON("MON") {
        @Override
        public Week next() {
            return Week.TUE;
        }
        @Override
        public Week previous() {
            return Week.SUN;
        }
    },
    TUE("TUE") {
        @Override
        public Week next() {
            return Week.WED;
        }

        @Override
        public Week previous() {
            return Week.MON;
        }
    },
    WED("WED") {
        @Override
        public Week next() {
            return Week.THR;
        }

        @Override
        public Week previous() {
            return Week.TUE;
        }
    },
    THR("THR") {
        @Override
        public Week next() {
            return Week.WED;
        }

        @Override
        public Week previous() {
            return Week.FRI;
        }
    },
    FRI("FRI") {
        @Override
        public Week next() {
            return Week.THR;
        }

        @Override
        public Week previous() {
            return Week.SAT;
        }
    },
    SAT("SAT") {
        @Override
        public Week next() {
            return Week.SUN;
        }

        @Override
        public Week previous() {
            return Week.FRI;
        }
    },
    SUN("SUN") {
        @Override
        public Week next() {
            return Week.MON;
        }

        @Override
        public Week previous() {
            return Week.SAT;
        }
    };
    String weekDay;
    Week(String weekDay) {
        this.weekDay = weekDay;
    }

    // 要想实现下面两个方法的效果，则上面的所有元素都需要重写
    public Week next() {
        return null;
    }

    public Week previous() {
        return null;
    }

}

/**
 * 用抽象类来模拟枚举
 */
abstract class WeekDay {
    public static WeekDay MON = new WeekDay("MON") {
        @Override
        public String toString() {
            return this.weekDay;
        }

        WeekDay next() {
            return TUE;
        }

        WeekDay previous() {
            return SUN;
        }
    };

    public static WeekDay TUE = new WeekDay("TUE") {
        @Override
        public String toString() {
            return this.weekDay;
        }

        WeekDay next() {
            return WED;
        }

        WeekDay previous() {
            return TUE;
        }
    };

    public static WeekDay WED = new WeekDay("WEB") {
        @Override
        public String toString() {
            return this.weekDay;
        }

        WeekDay next() {
            return THU;
        }

        WeekDay previous() {
            return TUE;
        }
    };

    public static WeekDay THU = new WeekDay("THU") {
        @Override
        public String toString() {
            return this.weekDay;
        }

        WeekDay next() {
            return FRI;
        }

        WeekDay previous() {
            return WED;
        }
    };

    public static WeekDay FRI = new WeekDay("FRI") {
        @Override
        public String toString() {
            return this.weekDay;
        }

        WeekDay next() {
            return SAT;
        }

        WeekDay previous() {
            return THU;
        }
    };

    public static WeekDay SAT = new WeekDay("SAT") {
        @Override
        public String toString() {
            return this.weekDay;
        }

        WeekDay next() {
            return SUN;
        }

        WeekDay previous() {
            return FRI;
        }
    };

    public static WeekDay SUN = new WeekDay("SUN") {
        @Override
        public String toString() {
            return this.weekDay;
        }

        WeekDay next() {
            return MON;
        }

        WeekDay previous() {
            return SAT;
        }
    };

    String weekDay;
    private WeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public String toString() {
        return weekDay;
    }

    abstract WeekDay next();
    abstract WeekDay previous();

}
