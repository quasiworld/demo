package org.ck.url;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Safelist;
import org.jsoup.select.Elements;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetText {

    /**
     * 功能描述:获得所有玄幻小说
     *
     * @param
     * @return java.util.List<java.lang.String>
     * @author ck
     * @date 2022/5/2 16:31
     */
    public List<String> listBook() {
        String regex_bookName = "<li><a href=(.*)</li>";
        Pattern p_bookName = Pattern.compile(regex_bookName);
        Matcher m_bookName;
        List<String> list = new ArrayList();
        try {
            BufferedReader reader = getURLResource("https://www.xbiquge.la/xiaoshuodaquan/");
            String str = null;
            //爬取小说的网址
            String content = "";
            //读取网页全部内容
            while ((str = reader.readLine()) != null) {
                m_bookName = p_bookName.matcher(str);
                Boolean isEx = m_bookName.find();
                if (isEx) {
                    String bookNameHref = m_bookName.group();
                    int startIndex = bookNameHref.indexOf("\"") + 1;
                    int endIndex = bookNameHref.indexOf("\"", startIndex);
                    list.add(bookNameHref.substring(startIndex, endIndex));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 功能描述: 获取章节目录
     *
     * @param bookUrl
     * @return java.util.List<java.lang.String>
     * @author ck
     * @date 2022/5/2 17:27
     */
    public List<String> crawlBookDirectory(String bookUrl) {
        Connection connect = Jsoup.connect(bookUrl);
        Map<String, String> bookDirectoryMap = new HashMap<>();
        try {
            Document document = connect.get();
            System.out.println(document);
            //获取章节名字和链接
            //获取作者相关信息
            //  document.getElementsByTag("meta");
            String author = document.getElementsByAttributeValue("property", "og:novel:author").get(0).attr("content");
            String book_name = document.getElementsByAttributeValue("property", "og:novel:book_name").get(0).attr("content");
             System.out.println("-----------------"+author+book_name);
            Elements elementsByTag = document.getElementById("list").getElementsByTag("a");
            for (Element element : elementsByTag) {
              //  System.out.println(element.text() + "+" + element.attr("href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*String regex_directory_url = "'(.*)'";
        String regex_chapter_name = "";
        Pattern p_directory = Pattern.compile(regex_directory);
        *//*Pattern p_title = Pattern.compile(regex_title);
        Matcher m_content;*//*
        Matcher m_directory;
        try {
            BufferedReader reader = getURLResource(bookUrl);
            String str = null;
            //爬取章节的内容
            String content = "";
            //读取网页全部内容
            while ((str = reader.readLine()) != null) {
                m_directory = m_directory.matcher(str);
                Boolean isEx = m_title.find();
                if (isEx) {
                    String title = m_title.group();
                    title = title.replace("<title>", "").replace("</title>", "");
                    System.out.println(title);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/
        return null;
    }

    /**
     * 功能描述:爬取章节内数据 https://www.xbiquge.la/15/15409/8163818.html
     *
     * @param bookChapterUrl
     * @return java.lang.String
     * @author ck
     * @date 2022/5/2 15:33
     */
    public static String getBookChapterContent(String bookChapterUrl) {
        Connection connect = Jsoup.connect(bookChapterUrl);
        Document document = null;
        try {
            document = connect.get();
            document.select("p").remove();
            document.select("br").last().remove();
            document.select("br").last().remove();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document.getElementById("content").html();
    }

    public static void main(String[] args) {
        GetText getText = new GetText();
        String bookChapterContent = getText.getBookChapterContent("https://www.xbiquge.la/15/15409/8163818.html");
        System.out.println(bookChapterContent);
        // getText.listBook();
        //getText.crawlBookDirectory("https://www.xbiquge.la/46/46543/");
    }

    /**
     * 功能描述: 读取网页数据
     *
     * @param urlStr
     * @return java.io.BufferedReader
     * @author ck
     * @date 2022/5/2 15:49
     */
    private BufferedReader getURLResource(String urlStr) {
        //2、 创建每一个页面的url对象
        URL url = null;
        try {
            url = new URL(urlStr);

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
            return new BufferedReader(new InputStreamReader(url.openStream(), "utf8"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}