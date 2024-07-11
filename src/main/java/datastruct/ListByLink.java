package datastruct;

import java.util.*;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-06-17
 * @Description: 基于链表的列表实现
 */
public class ListByLink<T> implements List<T>{
    // 首节点，为空
    private Node<T> first;
    //尾节点
    private Node<T> last;
    //当前列表元素个数
    private int size;
    public ListByLink() {
        first = new Node<>(null);
        last = first;
    }

    @Override
    public String toString() {
        if(size == 0){
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        Node<T> n = first.next;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(n.value);
            if(i!=size-1){
                stringBuilder.append(", ");
            }
            n = n.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> n = first.next;
        boolean c = false;
        while (n!=null){
            if(n.value.equals(o)){
                c = true;
                break;
            }
        }
        return c;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Node<T> n = first.next;
        Object[] objects = new Object[size];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = n.value;
            n = n.next;
        }
        return objects;
    }

    @Override
    public <E> E[] toArray(E[] a) {
        Node<T> n = first.next;
        if(a.length < size){
            E[] ae = (E[]) new Object[size];
            for (int i = 0; i < ae.length; i++) {
                ae[i] = (E) n.value;
                n = n.next;
            }
            return ae;
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = (E) n.value;
            n = n.next;
        }
        if(a.length>size){
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        Node<T> newNode = new Node<>(t);
        newNode.prev = last;
        last.next = newNode;
        last = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(o==null){
            return false;
        }
        Node<T> f = first.next;
        while (true){
            if(f==null){
                throw new NoSuchElementException();
            }
            if(f.value.equals(o)){
                if(f == last){
                    last = f.prev;
                }
                Node<T> prev = f.prev;
                prev.next = f.next;
                f.next.prev = prev;
                size--;
                break;
            }else{
                f = f.next;
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        first = new Node<>(null);
        last = first;
        size = 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> n = first;
        for (int i = 0; i <= index; i++) {
            n = n.next;
        }
        return n.value;
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        Node<T> n = first;
        for (int i = 0; i <= index; i++) {
            n = n.next;
        }
        T old = n.value;
        n.value = element;
        return old;
    }

    /**
     * 判断索引是否符合列表索引范围
     * @param index 索引值
     */
    private void checkIndex(int index) {
        if(index >size-1|| index <0){
            throw new IndexOutOfBoundsException("Index: "+ index +", Size: "+size);
        }
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index);
        Node<T> f = first;
        for (int i = 0; i <= index; i++) {
            f = f.next;
        }
        Node<T> newNode = new Node<>(element);
        f.prev.next = newNode;
        newNode.prev = f.prev;
        newNode.next = f;
        f.prev = newNode;
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        Node<T> f = first;
        for (int i = 0; i <= index; i++) {
            f = f.next;
        }
        T old = f.value;
        f.prev.next = f.next;
        if(f == last){
            last = f.prev;
        }else {
            f.next.prev = f.prev;
        }
        size--;
        return old;
    }

    @Override
    public int indexOf(Object o) {
        Node<T> n = first.next;
        int index = 0;
        while (true){
            if (n == null) {
                index = -1;
                break;
            }
            if(n.value.equals(o)){
                break;
            }
            n = n.next;
            index++;
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }


    private class Node<E extends T>{
        private E value;
        private Node<E> next;
        private Node<E> prev;

        public Node() {
        }
        public Node(E value) {
            this.value = value;
        }
        public Node(E value, Node<E> next,Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
        @Override
        public String toString() {
            return "Node{" + value +"}";
        }
    }


}
