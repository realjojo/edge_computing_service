package com.ecs.utils;

import com.ecs.constant.NetworksAccessible;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.InetAddress;


/**
 * Created by Zhaoone on 2019/4/3
 **/
public class TestNetworkUtil {
    public static boolean getNetworkCondition(String ip_adress) throws IOException {
        InetAddress address = InetAddress.getByName(ip_adress);
        if(address.isReachable(Integer.valueOf(NetworksAccessible.MAX_DELAY)))
            return true;
        else
            return false;
    }
}
