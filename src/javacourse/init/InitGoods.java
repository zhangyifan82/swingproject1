package javacourse.init;

import javacourse.entity.Goods;

import java.util.ArrayList;

public class InitGoods {
    public static ArrayList<Goods> goodsList = new ArrayList<Goods>();
    static Goods goods1 =  new Goods("黑色卫衣","服装","image2/服装1.jpg",34.5,"polo衫定制刺绣翻领短袖工作服");
    static Goods goods2 =  new Goods("敦煌飞天","服装","image2/服装2.jpg",150.0,"珍缕正品原创茉莉公主汉元素改良汉服西域敦煌飞天异域风情服装");
    static Goods goods3 =  new Goods("短袖衬衫","服装","image2/服装3.jpg",14.5,"酒店KTV夜场少爷服装男短袖衬衫dj酒吧夜总会服务员工作制服夏季");
    static Goods goods4 =  new Goods("豪漫西装","服装","image2/服装4.jpg",517,"豪漫/ SPY×FAMILY 间谍过家家黄昏cos 劳埃德·福杰cos服装西装");
    static Goods goods5 =  new Goods("西红柿","水果","image2/水果1.jpg",58,"新疆西红柿沙瓤新鲜水果自然熟普罗旺斯生吃番茄蔬菜草莓铁皮柿子一整箱");
    static Goods goods19 =  new Goods("苹果","水果","image2/水果3.jpg",58,"新疆西红柿沙瓤新鲜水果自然熟普罗旺斯生吃番茄蔬菜草莓铁皮柿子一整箱");
    static Goods goods6 =  new Goods("橘子","水果","image2/水果2.jpg",26.80,"沃柑10斤新鲜水果时令应当季整箱正宗云南一级柑橘桔子");
    static Goods goods7 =  new Goods("樱桃","水果","image2/水果4.jpg",155.5,"美早大樱桃新鲜水果包邮5斤应当季整箱3孕妇4j山东烟台国产车厘子");
    static Goods goods8 =  new Goods("吸尘器","电器","image2/电器1.jpg",1200,"适配Dyson戴森吸尘器非原装电池兼容V6V7V8V10充电器配件锂电池");
    static Goods goods9 =  new Goods("电饭锅","电器","image2/电器2.jpg",150.5,"美的电饭煲家用小2人迷你饭锅煲汤煮饭两用1小型多功能智能电器一");
    static Goods goods10=  new Goods("自动风筒","电器","image2/电器3.jpg",699,"康夫K9电吹风负离子发廊专用高速自动风筒");
    static Goods goods11 =  new Goods("烤箱","电器","image2/电器4.jpg",899,"UKOEO HBD-5002全自动电烤箱大容量52L烘焙8管多功能家用小型烤箱");
    static Goods goods12 =  new Goods("鱼排","零食","image2/零食1.jpg",16.51,"香辣鱼排下饭菜湖南特产瓶装麻辣鱼农家自制即食小吃零食鱼块熏鱼");
    static Goods goods13 =  new Goods("零食大礼包","零食","image2/零食2.jpg",29.5,"零食大礼包麻辣网红小吃休闲食品里奈零食卤味肉类年货整箱鸭脖");
    static Goods goods14 =  new Goods("巧克力豆","零食","image2/零食3.jpg",37.00,"Loncy/萝西纯可可脂100%黑巧克力豆无蔗糖黑巧健身低罐装烘焙零食");
    static Goods goods15 =  new Goods("羊排","食材","image2/食材1.jpg",189.00,"法式羊排新鲜烧烤食材半成品羊肉肋排内蒙战斧羔羊扒");
    static Goods goods16 =  new Goods("牛肉卷","食材","image2/食材2.jpg",89.90,"肥牛卷新鲜牛肉卷雪花牛肉片肥牛砖火锅食材烤肉套餐原切商用批发");
    static Goods goods17 =  new Goods("毛肚","食材","image2/食材3.jpg",139.90,"新鲜整个毛肚5斤包邮商用带底板大叶片爽脆牛百叶千层肚火锅食材");
    static Goods goods18 =  new Goods("鸡块","食材","image2/食材4.jpg",15.80,"黑椒上校鸡块冷冻半成品油炸小吃炸串鸡柳鸡米花空气炸锅食材原味");
    static Goods goods20=  new Goods("虾滑","食材","image2/食材5.jpg",20.80,"黑椒上校鸡块冷冻半成品油炸小吃炸串鸡柳鸡米花空气炸锅食材原味");
    public static void initgood(){
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        goodsList.add(goods4);
        goodsList.add(goods5);
        goodsList.add(goods6);
        goodsList.add(goods7);
        goodsList.add(goods8);
        goodsList.add(goods9);
        goodsList.add(goods10);
        goodsList.add(goods11);
        goodsList.add(goods12);
        goodsList.add(goods13);
        goodsList.add(goods14);
        goodsList.add(goods15);
        goodsList.add(goods16);
        goodsList.add(goods17);
        goodsList.add(goods18);
        goodsList.add(goods19);
        goodsList.add(goods20);
    }

//    public static void main(String[] args) {
//        initgood();
//        System.out.println(goodsList.size());
//        for (Goods goods:goodsList){
//            new GoodsImp().add(goods);
//        }
//    }
}
