abstract class List<E> {
    // the number of elements in the list
    public abstract int size();

    // the element at the specified location
    public abstract E get(int loc);

    // add an element to the specified location
    public abstract void insert(int loc, E elem);

    // remove the element at the specified location
    public abstract E remove(int loc);

    public String toString() {
        String output = "[";

        for (int i = 0; i < this.size(); i++) {
            output += this.get(i);
            if (i < this.size() - 1) {
                output += ", ";
            }
        }

        output += "]";
        return output;
    }
}


class SingleLinkedList<E> extends List<E> {
    class Node {
        E val;
        Node next;

        public Node(E newVal, Node newNext) {
            val = newVal;
            next = newNext;
        }

        void setNext(Node newNext) {
            next = newNext;
        }
    }

    private Node head;
    private int size;

    public SingleLinkedList() {
        size = 0;
        head = null;
    }

    public int size() {
        return this.size;
    }

    private Node getNode(int loc) {
        // NOTE: internal method, will not do bound check
        Node cur = this.head;
        for (int i = 0; i < loc; i++) {
            cur = cur.next;
        }

        return cur;
    }

    public E get(int loc) {
        if (loc >= this.size || loc < 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.getNode(loc).val;
    }

    public void insert(int loc, E elem) {
        if (loc > this.size || loc < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(elem, null);
        if (this.size == 0) {
            this.head = newNode;
        } else if (loc == 0) {
            newNode.setNext(this.getNode(loc));
            this.head = newNode;
        } else {
            newNode.setNext(this.getNode(loc));
            this.getNode(loc-1).setNext(newNode);
        }
        this.size++;
    }

    public E remove(int loc) {
        if (loc < 0 || loc >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        Node toRemove = this.getNode(loc);
        if (loc == 0) {
            this.head = toRemove.next;
        } else {
            this.getNode(loc - 1).next = toRemove.next;
        }
        this.size--;
        return toRemove.val;
    }
}

class HelloWorld {
    public static void main(String[] args) {
        List<Integer> list = new SingleLinkedList<Integer>();

        for (int i = 0; i < 10; i++) {
            list.insert(list.size(), Integer.valueOf(i));
        }
        list.remove(3);

        System.out.println(list);
    }
}
