import org.java.ws.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Dome {

//    public static void main(String[] args) {
//
//        //通过WebService服务的名称，创建WebService对象
//        MobileCodeWS service = new MobileCodeWS();
//
//        //通过服务对象，产生一个服务接口（调用此接口的方法，实际上就是在调用远程服务器上的方法）
//        MobileCodeWSSoap port = service.getMobileCodeWSSoap();
//
//        //通过接口，调用服务器上的方法
//        String msg = port.getMobileCodeInfo("18707221769", "");
//
//        System.out.println(msg);
//
//    }

    public static void main(String[] args) {

        //创建服务
        InfService service  = new InfService();

        //产生接口
        InfServicePort port = service.getInfServicePortPort();

        //通过接口，调用方法，得到服务端返回的数据
        List<MapEntityArray> arrs = port.findAll();

        //将List<MapEntityArray>转换成List<Map>
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

        for(MapEntityArray arr:arrs){

            //一个arr，即代表一条数据，需要转换成一个Map
            Map<String,Object> m = new HashMap<String, Object>();

            //得到这一条数据中所有的的键值对   id=1  name=jack score=98
            List<MapEntity> items = arr.getItem();

            for(MapEntity en:items){
                m.put(en.getKey().toString(),en.getValue());
            }

            list.add(m);
        }

        System.out.println("-------------转换以后的类型是-----------------------");

        for(Map<String,Object> k:list){
            System.out.println(k);
        }




        //循环
//		for(MapEntityArray ar:arrs){
//			//ar:即为取得的每一条数据 （MapEntityArray）
//			//得到MapEntityArray对象中的 每一个值
//			List<MapEntity> items = ar.getItem();                     //id=1  name=jack  score=98
//			//MapEntity代表当前这一条数据中的每一个值： id,name,score
//
////			String a = items.get(0).getValue().toString();
////			String b = items.get(1).getValue().toString();
////			String c = items.get(2).getValue().toString();
//
//
//			String a = items.get(0).getKey().toString();
//			String b = items.get(1).getKey().toString();
//			String c = items.get(2).getKey().toString();
//
//			System.out.println(a+" "+b+"  "+c);
//
//		}



    }


}
