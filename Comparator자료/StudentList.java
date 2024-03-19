import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentList<T> implements Iterable<T>{
    List<T> list = new ArrayList<T>();

    public void add(T item){
        list.add(item);
    }

    public Iterator<T> iterator(){
        return list.iterator();
    }
    
}
