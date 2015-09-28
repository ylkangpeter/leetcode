package peter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ylkang on 9/28/15.
 */
public class _284_Peeking_Iterator implements Iterator<Integer> {

    Iterator<Integer> iter;

    Integer tmp;

    public _284_Peeking_Iterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iter = iterator;
        if (iterator.hasNext()) {
            tmp = iter.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (tmp != null) {
            return tmp;
        }
        return null;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
// Override them if needed.
    @Override
    public Integer next() {
        if (tmp != null) {
            int result = tmp;
            if (iter.hasNext()) {
                Integer next = iter.next();
                tmp = next;
            } else {
                tmp = null;
            }
            return result;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return tmp != null;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> iter = list.iterator();
        _284_Peeking_Iterator i = new _284_Peeking_Iterator(iter);
        System.out.println(i.peek());
        System.out.println(i.next());
        System.out.println(i.peek());
        System.out.println(i.next());
        System.out.println(i.next());

        System.out.println(i.peek());
        System.out.println(i.next());
        System.out.println(i.next());

        System.out.println(i.peek());

    }
}