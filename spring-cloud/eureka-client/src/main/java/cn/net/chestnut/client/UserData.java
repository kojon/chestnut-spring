package cn.net.chestnut.client;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟数据库 前方预警： 线程安全有风险，请勿模仿
 * @Description
 * @Author tarzan
 * @Date 2019/3/26 10:11 AM
 **/
public class UserData {
    private static Map<Integer,User> userMap=new HashMap<>();

    public static synchronized User getUserById(Integer id) {
        return userMap.get(id);
    }

    public static synchronized void setUser(User user) {
        userMap.put(user.getId(),user);
    }

    public static Map<Integer, User> getUserMap() {
        return userMap;
    }


}
