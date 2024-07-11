package datastruct;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-06-17
 * @Description:
 */
interface MyList<E>{
    void add(int index,E obj);
    void add(E obj);
    E remove(int index);
    void set(int index,E obj);
    E get(int index);
    int size();
    void clear();
}
public class MyArrayList<T> implements MyList{
    private Object[] elementData;
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    public MyArrayList(){
        this.elementData = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
    }
    public MyArrayList(int initialCapacity){
        if(initialCapacity<0){
            throw new IllegalArgumentException("Illegal Capacity:"+initialCapacity);
        } else if (initialCapacity == 0) {
            this.elementData = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
        }else {
            this.elementData = new Object[initialCapacity];
        }
    }

    private void rangeCheckForAdd(int index){
        if(index<0 || index>size){
            throw new ArrayIndexOutOfBoundsException("数组索引越界");
        }
    }
    private void grow(int minCapacity){

    }
    @Override
    public void add(int index, Object obj) {

    }

    @Override
    public void add(Object obj) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public void set(int index, Object obj) {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }
}
