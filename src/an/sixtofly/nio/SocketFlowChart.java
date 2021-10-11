package an.sixtofly.nio;

/**
 * TCP/IP 模型路程图
 * 用代码来表示接口间的调用
 * @author xie yuan bing
 * @date 2021-09-30 17:10
 */
public class SocketFlowChart {


    public static void main(String[] args) {
        SocketFlowChart socket = new SocketFlowChart();
        socket.send();
        System.out.println("------------- 经过中间设备传输 -------------");
        socket.receiveMac("帧");
    }

    /**
     * 应用层
     * 构造数据，调用下层提供的服务
     */
    public void send() {
        System.out.println("--------------  应用层 -----------------");
        System.out.println("调用下层TCP提供的服务");
        String ip = "127.0.0.1";
        String port = "8080";
        String data = "data";
        sendTcp(ip, port, data);
    }

    /**
     * TCP层
     *
     */
    public void sendTcp(String ip, String port, String data) {
        System.out.println("--------------  TCP -----------------");
        System.out.println("数据到达TCP层，添加头部，封装成 数据段 (Segment)");
        System.out.println(String.format("port: %s", port));
        System.out.println("调用下层IP提供的服务");
        sendIp(ip, "报文");
    }

    /**
     * IP层
     */
    public void sendIp(String ip, String tcp) {
        System.out.println("--------------  I P -----------------");
        System.out.println("数据到达IP层，添加头部，封装成 数据包 (Packet)");
        System.out.println(String.format("ip: %s", ip));
        System.out.println("调用下层物理层提供的服务");
        sendMac("ip数据包");
    }

    /**
     * 物理层
     */
    public void sendMac(String ip) {
        System.out.println("--------------  MAC -----------------");
        System.out.println("数据到达物理层，添加头部，封装成 帧 (Frame)");
        System.out.println("通过网卡发送");
    }



    public void receive(String data) {
        System.out.println("--------------  应用层 -----------------");
        System.out.println("数据到达应用层");
        System.out.println("应用层处理数据");
    }


    public void receiveTcp(String tcp) {
        System.out.println("--------------  TCP -----------------");
        System.out.println("数据到达传输层，解析头部，为上层提供数据");
        receive("应用层数据");
    }


    public void receiveIp(String ip) {
        System.out.println("--------------  I P -----------------");
        System.out.println("数据到达网络层，解析头部，为上层提供数据");
        receiveTcp("报文");
    }


    public void receiveMac(String mac) {
        System.out.println("--------------  MAC -----------------");
        System.out.println("接收到网卡发送过来的数据");
        System.out.println("数据到达物理层，解析头部，为上层提供数据");
        receiveIp("ip数据包");
    }


}
