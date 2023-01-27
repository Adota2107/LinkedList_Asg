public class LinkedList {

    public static void main(String[] args) {
        MyList a = new MyList();
        a.add(5);
        a.add(1);
        a.add(9);
        a.add(15);
        a.add(33);
        a.traverse();
        System.out.println("---------------------------------------------------");
        System.out.println("Count: " + a.count());
        System.out.println("Max value: " + a.max());
        System.out.println("Sum: " + a.sum());
        System.out.println("Average value: " + a.avg());
        System.out.println("Search: " + a.search(15));
        System.out.println("Search: " + a.search(10));
        System.out.println("---------------------------------------------------");
        System.out.print("Before sort: ");
        a.traverse();
        System.out.print("After sort: ");
        a.sort();
        a.traverse();
    }
}
    class Node {
    int info;
    Node next;

    public Node() {
        info = 0;
        next = null;
    }

    public Node(int info, Node next) {
        this.info = info;
        this.next = next;
    }
}

    class MyList{
        Node head, tail;

        public MyList() {
        }

        public MyList(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
        public MyList(int x) {
            head = tail = new Node(0, null);
        }
        
        public boolean isEmpty() {
            return head == null;
        }
        
        public void add(int x) {
            Node n = new Node(x, null);
            if(isEmpty()) {
                head = tail = n;
            }
            else {
                tail.next = n;
                tail = n;
            }
       }

        public void traverse(){
            Node p = head;
            while (p != null) {
                if (p.next == null) {
                    System.out.print(p.info);
                    System.out.println();
                }
                else{
                    System.out.print(p.info + ",");
                }
                p = p.next;
            }
       }

        public void delete(int x){
            Node p = head;
                if (x == p.info) {
                    head = p.next;
                    return;
                }
                else{
                    while (p.next != null) {
                        if (p.next.info == x && p.next.next != null) {
                            p.next = p.next.next;
                            // Tai sao phai return ??????
                            return;
                        }
                        else if (p.next.info == x && p.next.next == null){
                            p.next = null;
                            p = tail;
                            // Tai sao phai return ?????????
                            return;
                        }
                        p = p.next; 
                    }   
                }
                System.out.println("Node have value " + x + " doesn't exit");
        }

        public Node search(int x){
            Node p = head;
            while (p.next != null) {
                if (p.info == x) {
                    return p;
                }
                p = p.next;
            }
            return null;
        }

        public int count(){
            Node p = head;
            int count = 0;
            while (p != null) {
                p = p.next;
                count ++;
            }
            return count;
        }
        public Node get(int i) {
            if(this.isEmpty() || i > this.count()) {
                return null;
            } 
            Node p = this.head;
            while(i != 0) {
                p = p.next;
                i--;
            }
            return p;
        }

        public void sort(){
            for (int i = 0; i < this.count(); i++) {
                for (int j = 0; j < this.count() - i - 1; j++) {
                    if(this.get(j).info > this.get(j + 1).info) {
                        int tmp = this.get(j).info;
                        this.get(j).info = this.get(j + 1).info;
                        this.get(j + 1).info = tmp;
                    }
                }
            }
        }

        public int max(){
            Node p = head;
            int max = p.info;
            while (p.next != null) {
                if (p.next.info > max) {
                    max = p.next.info;
                }
                p = p.next;
            }
            return max;
        }

        public int sum(){
            Node p = head;
            int sum = 0;
            while (p != null) {
                sum += p.info;
                p = p.next;
            } 
            return sum;
        }

        public int avg(){
            Node p = head;
            int count = 0;
            int sum = 0;
            while (p != null) {
                sum += p.info;
                count++;
                p = p.next;
            }
            return sum/count;
        }
    }
