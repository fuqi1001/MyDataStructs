import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by qifu on 17/3/26.
 */

//可以看出HashMap就是一个Entry数组，Entry对象中包含了键和值两个属性。
public class Entry<K, V> implements Map.Entry<K, V>{
    final K key;
    V value;

    //  指向下一个节点
    Entry<K, V> next;
    final int hash;

    //构造函数
    //输入参数包括 哈希值h 键k 值v 下一个节点n

    Entry(int h, K k, V v, Entry<K, V> n) {
        value = v;
        next = next;
        key = k;
        hash = h;
    }

    public final K getKey() {
        return key;
    }
    public final V getValue() {
        return value;
    }

    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }
    // 判断两个Entry是否相等
    // 若两个Entry的“key”和“value”都相等，则返回true。
    // 否则，返回false
    public final boolean equals(Object o) {
        if(!(o instanceof Map.Entry))
            return false;
        Map.Entry e= (Map.Entry)o;
        Object k1 = getKey();
        Object k2 = e.getKey();
        if(k1 == k2 || (k1 != null && k1.equals(k2))) {
            Object v1 = getValue();
            Object v2 = e.getValue();
            if(v1 == v2 || (v1 != null && v1.equals(v2)))
                return true;
        }
        return false;
    }

    //实现hashCode();
    public final int hasCode() {
        return (key == null ? 0 : key.hashCode()) ^
                (value == null ? 0 : value.hashCode());
    }
    public final String toString() {
        return getKey() + "=" + getValue();
    }

    void recordAccess(HashMap<K, V> m) {

    }

    void recordRemoval(HashMap<K, V> m) {

    }


}
