package cn.xpleaf.bigdata.p2;

import java.util.Arrays;
import java.util.List;

public class JavaFunctionOps {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("zhangsan", "lisi");
        list.forEach(str -> System.out.println(str));
    }
}
