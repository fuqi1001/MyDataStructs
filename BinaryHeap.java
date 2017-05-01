/**
 * Created by qifu on 17/5/1.
 */
public class BinaryHeap<AnyType extends  Comparable<? super AnyType>> {

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }
    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = new Comparable[ capacity + 1];
    }

    public void insert(AnyType x) {
        if(currentSize == array.length - 1)
            enlargeArray(array.length * 2 + 1);

        int hole = ++currentSize++;
        for(; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = x;
    }

    public Comparable findMin() {
        if(isEmpty()) return null;
        return array[1];
    }
    public Comparable deleteMin() {
        if(isEmpty()) return null;
        Comparable minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }
    private void buildHeap() {
        for(int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }
    public boolean isEmpty() {
        return currentSize == 0;
    }
    public boolean isFull() {
        return currentSize == array.length - 1;
    }

    public void makeEmpty() {
        currentSize = 0;
    }
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private Comparable [] array;

    private void percolateDown(int hole) {
        int child;
        Comparable tmp = array[hole];
        for(; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if(child != currentSize && array[child + 1].compareTo(array[child]) < 0)
                child++;
            if(array[child].compareTo(tmp) < 0)
                array[hole] = array[child];
            else
                break;
        }
        array[hole] = tmp;
    }
    public static void main( String [ ] args )
    {
        int numItems = 10000;
        BinaryHeap h = new BinaryHeap( numItems );
        int i = 37;

        try
        {
            for( i = 37; i != 0; i = ( i + 37 ) % numItems )
                h.insert( new MyInteger( i ) );
            for( i = 1; i < numItems; i++ )
                if( ((MyInteger)( h.deleteMin( ) )).intValue( ) != i )
                    System.out.println( "Oops! " + i );

            for( i = 37; i != 0; i = ( i + 37 ) % numItems )
                h.insert( new MyInteger( i ) );
            h.insert( new MyInteger( 0 ) );
            i = 9999999;
            h.insert( new MyInteger( i ) );
            for( i = 1; i <= numItems; i++ )
                if( ((MyInteger)( h.deleteMin( ) )).intValue( ) != i )
                    System.out.println( "Oops! " + i + " " );
        }
        catch( Overflow e )
        { System.out.println( "Overflow (expected)! " + i  ); }
    }
}
