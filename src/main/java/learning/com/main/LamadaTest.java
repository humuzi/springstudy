package learning.com.main;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Create by HuQiuYue on 2019-11-07
 */
public class LamadaTest {

    public static void main(String[] args) {
//        使用lambda表达式对列表进行迭代
        List features= Arrays.asList("Lamadas","Love","Default Method");
        features.forEach(n-> System.out.println(n));
        features.forEach(System.out::println);

//        使用lambda表达式和函数式接口Predicate
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        filter(languages,(str)->((String)str).startsWith("J"));
        filter(languages,str->((String)str).endsWith("a"));
        filter(languages,str->true);
        filter(languages,str->((String)str).length() > 4);

//        Java 8中使用lambda表达式的Map和Reduce示例
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost)-> cost + (.12 * cost)).forEach(System.out::println);

        double bill = costBeforeTax.stream().map((cost)->cost + .12*cost).reduce((sum,cost) -> sum + cost).get();
        System.out.println(bill);

//        对列表的每个元素应用函数
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String countries = G7.stream().map(x->x.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(countries);

//        复制不同的值，创建一个子列表
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i ->i * i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n",numbers,distinct);


//        IntStream、LongStream 和 DoubleStream 等流的类中，有个非常有用的方法叫做 summaryStatistics() 。可以返回 IntSummaryStatistics、LongSummaryStatistics 或者 DoubleSummaryStatistics，描述流中元素的各种摘要数据。
//        在本例中，我们用这个方法来计算列表的最大值和最小值。它也有 getSum() 和 getAverage() 方法来获得列表的所有元素的总和及平均值。


//        计算集合元素的最大值、最小值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) ->x).summaryStatistics();
        System.out.println(stats.getMax());
    }

    public static void filter(List<String> names, Predicate condition){
        for (String name:names){
            if(condition.test(name)){
                System.out.println(name + " ");
            }
        }
    }
}
