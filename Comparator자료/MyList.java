import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MyList<E extends Comparable<E>> implements Iterable<E>{
    private List<E> list;

    public MyList(){
        this.list = new ArrayList<>();
    }

    public void sort(){
        Collections.sort(this.list);
    }

    
    public void sort(Comparator<E> comparator){
        Collections.sort(this.list, comparator);
    }
 
    public List<E> getList(){
        return this.list;
    }

    

    public void add(E element){
        this.list.add(element);
    }

    public Iterator<E> iterator(){
        return this.list.iterator();
    }
}
