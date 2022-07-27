package org.ck.url;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DownJpg {

    public static void main(String[] args) throws IOException {
        String url = "https://www.xbiquge.la/files/article/image/56/56523/56523s.jpg";
        String path = "D:\\";
    }

    public static void downJpg(String url, String path) throws IOException {
        if (url != null) {
            String[] arr1 = url.split("/");
            if (arr1.length > 0) {
                String dictory = path;
                String fileName = arr1[arr1.length - 1];
                fileName = (fileName != null && fileName.indexOf("?") == -1) ? fileName : (fileName.substring(0, fileName.indexOf("?")));
                System.out.println(fileName);
                downJpg(url, dictory + fileName);
            }
        }
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        InputStream inputStream = response.body().byteStream();
        FileOutputStream out = new FileOutputStream(path);
        int j = 0;
        while ((j = inputStream.read()) != -1) {
            out.write(j);
        }
        inputStream.close();
    }
}
