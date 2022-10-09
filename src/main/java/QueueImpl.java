public class QueueImpl<E> implements Queue <E>{
    private E[] data;
    private int p;

    public QueueImpl(int i) {
        data = (E[]) new Object[i];
    }

    @Override
    public void push(E e) throws FullQueueException {
        if(isFull()) throw new FullQueueException();
        this.data[this.p++]=e;
    }

    private boolean isFull() {
        return (this.p >= data.length);
    }

    @Override
    public E pop() throws EmptyQueueException {
        if(isEmpty()) throw new EmptyQueueException();
        E primer = data[0];
        //Ho hem de desplaçar tot a cap a l'esquerra
        for (int i=0;i<p;i++){
            data[i]=data[i+1];
        }
        this.p--;
        return primer;
    }

    private boolean isEmpty() {
        return (this.p == 0);
    }

    @Override
    public int size() {
        return this.p;
    }
}
