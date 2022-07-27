package org.ck.python;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetText {

    /**
     * 1、根据小说存放位置创建file对象
     * <p>
     * 2、根据网页结构编写正则，创建pattern对象
     * <p>
     * 3、编写循环，创建向所有小说章节页面发起网络请求的url对象
     * <p>
     * 4、网络流BufferReader
     * <p>
     * 5、创建输入流
     * <p>
     * 6、循环读取请求得到的内容，使用正则匹配其中的内容
     * <p>
     * 7、将读取到的内容写入本地文件，知道循环结束
     * <p>
     * 8、注意代码中的异常处理
     *
     * @param args
     */

    public static void main(String[] args) {

// 1、根据小说存放位置创建file对象

        File file = new File("D:\\three_guo.txt");

// 2、根据网页结构编写正则，创建pattern对象

        String regex_content = "<br />(.*)";
        System.out.println(regex_content);

        String regex_title = "<title>(.*?)</title>";


        Pattern p_content = Pattern.compile(regex_content);

        Pattern p_title = Pattern.compile(regex_title);


        Matcher m_content;

        Matcher m_title;


// 3、编写循环，创建向所有小说章节页面发起网络请求的url对象

        for (int i = 1; i <= 120; i++) {

            System.out.println("第" + i + "章开始下载。。。");

            try {

// 创建每一个页面的url对象
                String urlStr = "https://www.xbiquge.la/15/15409/8163818.html";
                URL url = new URL(urlStr);
                //解决301的问题
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                //设置超时时间为3秒
                conn.setConnectTimeout(3 * 1000);
                //防止屏蔽程序抓取而返回403错误
                conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                String newUrl = urlStr;
                Map<String, List<String>> map = conn.getHeaderFields();
                //遍历所有的响应头字段
                for (String key : map.keySet()) {
                    System.out.println(key + "--->" + map.get(key).get(0));
                    if ("Location".equals(key)) {
                        //获取新地址
                        newUrl = map.get(key).get(0);
                        System.out.println("newUrl--->" + newUrl);
                        break;
                    }
                }
                //重新实例化url对象
                url = new URL(newUrl);
                //重新打开和URL之间的连接
                // 创建网络读取流

                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "utf8"));
                // 4、读取网络内容网络流BufferReader
                String str = null;
                // 5、创建输入流

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));


                while ((str = reader.readLine()) != null) {
                    System.out.println("爬取的全部数据" + str);

                    m_title = p_title.matcher(str.toString());

                    m_content = p_content.matcher(str.toString());



                // 获取小说标题并写入本地文件

                    Boolean isEx = m_title.find();

                    if (isEx) {

                        String title = m_title.group();

                // 清洗得到的数据

                        title = title.replace("<title>", "").replace("</title>", "");

                        System.out.println(title);

                        writer.write("第" + i + "章：" + title + "\n");

                    }


                    while (m_content.find()) {

                        String content = m_content.group();
                        System.out.println("读取的内容" + content);// 清洗得到的数据

                        //content = content.replace("<p>", "").replace("</p>", "").replace("&nbsp;", "").replace("?", "");
                        // 把小说内容写入文件

                        writer.write(content + "\n");

                    }


                }


                System.out.println("第" + i + "章下载完成.........");


                writer.write("\n\n");

                writer.close();

                reader.close();

            } catch (Exception e) {

                System.out.println("下载失败");

                e.printStackTrace();
            } finally {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}