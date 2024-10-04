class Counter {
    int prev;
    int cur;

    public Counter() {
        prev = 0;
        cur = 0;
    }

    public String toString() {
        return "<Counter prev=" + prev + " cur=" + cur + ">";
    }

    public int peek() {
        return cur;
    }

    public int next() {
        if (prev == 0 && cur == 0) {
            cur = 1;
            return 0;
        }
        int next = prev + cur;
        int ret = cur;
        prev = cur;
        cur = next;
        return ret;
    }
}

class Fibonacci {
    public static void main(String[] args) {
        Counter ctr = new Counter();

        for (int i = 0; i < 10; i++) {
            int num = ctr.next();
            System.out.println(num);
        }
    }
}
