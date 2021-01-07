package concurrent;

public class ConcurrentSingleton {
    private volatile static ConcurrentSingleton concurrentSingleton;
    private ConcurrentSingleton(){}
    public static ConcurrentSingleton getInstance(){
        if(concurrentSingleton==null){
            synchronized (ConcurrentSingleton.class){
                if(concurrentSingleton==null){
                    concurrentSingleton = new ConcurrentSingleton();
                }
            }
        }
        return concurrentSingleton;
    }
}
