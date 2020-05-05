package com.zhang.newdemo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Thread2 extends Thread{
    private String url;
    private String name; //保存的文件名
    public Thread2(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownload = new WebDownloader();
        webDownload.downloader(url,name);
        System.out.println("下载了文件+"+name);
    }

    public static void main(String[] args) {
        Thread2 thread1 = new Thread2("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588650183737&di=b33bce2b1b303194503d2038af4a070c&imgtype=0&src=http%3A%2F%2Faliyunzixunbucket.oss-cn-beijing.aliyuncs.com%2Fjpg%2F2a5701dc079d126f6c4036f78fe0812e.jpg%3Fx-oss-process%3Dimage%2Fresize%2Cp_100%2Fauto-orient%2C1%2Fquality%2Cq_90%2Fformat%2Cjpg%2Fwatermark%2Cimage_eXVuY2VzaGk%3D%2Ct_100","1.jpg");
        Thread2 thread2 = new Thread2("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588650183737&di=b33bce2b1b303194503d2038af4a070c&imgtype=0&src=http%3A%2F%2Faliyunzixunbucket.oss-cn-beijing.aliyuncs.com%2Fjpg%2F2a5701dc079d126f6c4036f78fe0812e.jpg%3Fx-oss-process%3Dimage%2Fresize%2Cp_100%2Fauto-orient%2C1%2Fquality%2Cq_90%2Fformat%2Cjpg%2Fwatermark%2Cimage_eXVuY2VzaGk%3D%2Ct_100","2.jpg");
        Thread2 thread3 = new Thread2("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588650183737&di=b33bce2b1b303194503d2038af4a070c&imgtype=0&src=http%3A%2F%2Faliyunzixunbucket.oss-cn-beijing.aliyuncs.com%2Fjpg%2F2a5701dc079d126f6c4036f78fe0812e.jpg%3Fx-oss-process%3Dimage%2Fresize%2Cp_100%2Fauto-orient%2C1%2Fquality%2Cq_90%2Fformat%2Cjpg%2Fwatermark%2Cimage_eXVuY2VzaGk%3D%2Ct_100","3.jpg");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

/**
 * 下载器
 */
class WebDownloader{
    public void downloader(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
