package leetcode75.medium;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BigDecimals {

    public static void main(String[] args){
        Map<String, BigDecimal> balances = new HashMap<>();
        balances.put("ACC100", new BigDecimal("1000.00"));
        balances.put("ACC200", new BigDecimal("2500.00"));
        balances.merge("ACC100", new BigDecimal("1500.00"), (a, b) -> a.add(b));

        System.out.println(balances);
    }
}
