public class Queue {
    private Node front;
    private Node rear;

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (front == null) {
            front = rear = newNode;
        } else {
            Node tmp = front;
            Node prev = null;

            while (tmp != null) {
                if (tmp.getValue() > value) {
                    newNode.setNext(tmp);

                    if (prev == null) {
                        front = newNode;
                    } else {
                        prev.setNext(newNode);
                    }
                    return;
                }
                prev = tmp;
                tmp = tmp.getNext();
            }
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public int dequeue() {
        Node tmp = front;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.getNext();
        }
        return tmp.getValue();
    }

    public boolean contains(int value) {
        Node tmp = front;
        while (tmp != null) {
            if (tmp.getValue() == value) {
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    public void print() {
        Node tmp = front;
        while (tmp != null) {
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }
}