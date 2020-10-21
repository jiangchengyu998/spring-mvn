package jksj.lru;

public class LRUBaseLinkedList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;  // 链表容量
    private int length;    // 链表长度

    private SNode<T> headNode;

    public LRUBaseLinkedList() {
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
        this.headNode = new SNode<>();
    }

    public LRUBaseLinkedList(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.headNode = new SNode<>();
    }

    // 添加一个元素
    public void add(T data) {
        // 查找这个元素的前一个节点
        SNode<T> pre = findPreNode(data);
        // 删除这个节点，把这个这个节点放到链表头部
        if (pre != null) {
            pre.next = pre.next.next;
            SNode<T> newNode = new SNode<>(data);
            newNode.next = headNode;
            headNode = newNode;
        } else {

        }
    }

    private SNode<T> findPreNode(T data) {
        SNode<T> node = headNode;
        while (node.next != null) {
            if (node.next.element.equals(data)) {
                return node;
            }
            node = node.next;
        }

        return null;
    }


    private static class SNode<T>{
        T element;
        SNode<T> next;

        public SNode() {
            this.next = null;
        }

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode<T> next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode<T> getNext() {
            return next;
        }

        public void setNext(SNode<T> next) {
            this.next = next;
        }
    }
}
