package javacourse.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VIP {
    public static List<String> vip = new ArrayList<>();
    public static Map<Integer,Double> map= new HashMap<>();
    static {

        vip.add(0,"src/image/Vip/vip 未开通.png");
        vip.add(1,"src/image/Vip/vip1.png");
        vip.add(2,"src/image/Vip/vip2.png");
        vip.add(3,"src/image/Vip/vip3.png");
        vip.add(4,"src/image/Vip/vip4.png");
        vip.add(5,"src/image/Vip/vip5.png");
        vip.add(6,"src/image/Vip/vip6.png");
        vip.add(7,"src/image/Vip/vip7.png");
        map.put(0,1.00);
        map.put(1,0.95);
        map.put(2,0.90);
        map.put(3,0.80);
        map.put(4,0.75);
        map.put(5,0.70);
        map.put(6,0.65);
        map.put(7,0.60);

    }
}
