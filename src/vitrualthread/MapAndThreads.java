package vitrualthread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapAndThreads {

    public void platFormThreads(){
        Map<String,Integer> map = new HashMap<>();
        map.put("counter",0);
        Map<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("counter",0);
        Runnable task = new Runnable() {
            public void run() {
                //map.compute("counter", (k, value) -> value + 1); // weired results
                map.merge("counter", 1, Integer::sum);// not thread safe
               // concurrentHashMap.merge("counter", 1, Integer::sum);
            }
        };
        for(int i=0;i<100;i++){
            Thread thread1 = new Thread(task);
            Thread thread2 = new Thread(task);
            thread1.start();
            thread2.start();
            try {
                thread1.join();
                thread2.join();
                System.out.println(map);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main (String[] args) {
        MapAndThreads  mapAndThreads = new MapAndThreads();
        mapAndThreads.platFormThreads();
    }
}
