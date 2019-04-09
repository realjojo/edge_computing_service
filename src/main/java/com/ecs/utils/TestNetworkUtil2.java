package com.ecs.utils;

import com.ecs.constant.NetworksAccessible;
import com.ecs.model.NetworkConditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zhaoone on 2019/4/7
 **/
public class TestNetworkUtil2 {
    public static NetworkConditions getNetworkCondition(String ip_adress) throws IOException {
        NetworkConditions networkConditions = new NetworkConditions();
        networkConditions.setDelay(getNetworkDelay(ip_adress));
        networkConditions.setPacket_loss(getNetworkPacketLoss(ip_adress));
        return networkConditions;
    }

    public static String getNetworkDelay(String ip_adress) throws IOException {
        int maxTime = 0;
        String maxtimeString = "";
        try {
            Process p = Runtime.getRuntime().exec("ping " + ip_adress + " -n 1");
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            p.getInputStream().close();
            String[] message = sb.toString().split(" +");
            String timeString;

            for (int i = 0; i < message.length; i++) {
                if (message[i].startsWith("TTL=")) {
                    timeString = message[i - 1].replaceAll(message[i - 1].split("(?:(\\d+ms))")[0], "");
                    Pattern pat = Pattern.compile("\\D+");
                    Matcher m = pat.matcher(timeString);
                    int time = Integer.valueOf(m.replaceAll("").trim());
                    if (time > maxTime) {
                        maxTime = time;
                        maxtimeString = timeString;
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (maxTime == 0) {
            return String.valueOf(Integer.valueOf(NetworksAccessible.MAX_DELAY)+1);
        }else {
            return maxtimeString.split("ms")[0];
        }
    }


    public static String getNetworkPacketLoss(String ip_adress) throws IOException {
        InetAddress address = InetAddress.getByName(ip_adress);
        int packet_loss = 10;
        for(int i = 0;i < 10; i++)
            if(address.isReachable(Integer.valueOf(NetworksAccessible.MAX_DELAY)))
                packet_loss--;
        packet_loss = packet_loss/10*100;
        return String.valueOf(packet_loss+"%");          //丢包率有%
    }
}
