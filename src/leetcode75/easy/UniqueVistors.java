package leetcode75.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueVistors {
    public void isUnique(String[][] vistorLog) {
       if(vistorLog.length==0){
           return;
       }
        Map<String , Set<String>>  vistorMap = new HashMap<String, Set<String>>();
       for (String[] v : vistorLog){
           String user = v[0];
           String pageName = v[1];
           if (!vistorMap.containsKey(pageName)){
               Set<String> set = new HashSet<String>();
               vistorMap.put(pageName, set);
           }
           vistorMap.get(pageName).add(user);

       }
       for(Map.Entry<String, Set<String>> entry : vistorMap.entrySet()){
           String pageName = entry.getKey();
           int uniqueVisitorsCount = entry.getValue().size();
           System.out.println("Page: " + pageName + ", Unique Visitors: " + uniqueVisitorsCount);
       }

    }
    public static void main(String[] args){

        UniqueVistors uv = new UniqueVistors();
        String[][] vistorLog = {
                {"UserA", "Home"},
                {"UserB", "About"},
                {"UserA", "Home"},     // Duplicate visit by UserA to Home
                {"UserC", "Home"},
                {"UserB", "Home"},
                {"UserC", "About"}
        };
        uv.isUnique(vistorLog);
    }
}
