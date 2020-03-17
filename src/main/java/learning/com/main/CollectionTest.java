package learning.com.main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Create by HuQiuYue on 2019-11-08
 */
public class CollectionTest {
    public static void main(String[] args) {
        List<String> staff = new LinkedList<>();
        staff.add("Bob");
        staff.add("Amy");
        staff.add("Carl");
//        ListIterator<String> listIterator = staff.listIterator();
//        while(listIterator.hasNext()){
//            listIterator.next();
//            listIterator.add("Juliet");
//        }
//        System.out.println(staff);

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gliris");

        ListIterator<String> aIter = staff.listIterator();
        Iterator<String> bIter = b.iterator();
         while(bIter.hasNext()){
             if(aIter.hasNext())
                 aIter.next();
         }
        System.out.println(staff);


         bIter = b.iterator();
         while(bIter.hasNext()){
             bIter.next();
             if(bIter.hasNext()){
                 bIter.next();
                 bIter.remove();
             }
         }
        System.out.println(b);
    }
}
