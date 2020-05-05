package com.zhang.newdemo;

import java.util.concurrent.*;

/**
 * 线程创建方式3：实现Callable接口
 */
public class Callable1 implements Callable<Boolean> {
    private String url;
    private String name; //保存的文件名
    public Callable1(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownload webDownload = new WebDownload();
        webDownload.downloader(url,name);
        System.out.println("下载了文件+"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable1 thread1 = new Callable1("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588650183737&di=b33bce2b1b303194503d2038af4a070c&imgtype=0&src=http%3A%2F%2Faliyunzixunbucket.oss-cn-beijing.aliyuncs.com%2Fjpg%2F2a5701dc079d126f6c4036f78fe0812e.jpg%3Fx-oss-process%3Dimage%2Fresize%2Cp_100%2Fauto-orient%2C1%2Fquality%2Cq_90%2Fformat%2Cjpg%2Fwatermark%2Cimage_eXVuY2VzaGk%3D%2Ct_100","1.jpg");
        Callable1 thread2 = new Callable1("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588650183737&di=b33bce2b1b303194503d2038af4a070c&imgtype=0&src=http%3A%2F%2Faliyunzixunbucket.oss-cn-beijing.aliyuncs.com%2Fjpg%2F2a5701dc079d126f6c4036f78fe0812e.jpg%3Fx-oss-process%3Dimage%2Fresize%2Cp_100%2Fauto-orient%2C1%2Fquality%2Cq_90%2Fformat%2Cjpg%2Fwatermark%2Cimage_eXVuY2VzaGk%3D%2Ct_100","2.jpg");
        Callable1 thread3 = new Callable1("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588650183737&di=b33bce2b1b303194503d2038af4a070c&imgtype=0&src=http%3A%2F%2Faliyunzixunbucket.oss-cn-beijing.aliyuncs.com%2Fjpg%2F2a5701dc079d126f6c4036f78fe0812e.jpg%3Fx-oss-process%3Dimage%2Fresize%2Cp_100%2Fauto-orient%2C1%2Fquality%2Cq_90%2Fformat%2Cjpg%2Fwatermark%2Cimage_eXVuY2VzaGk%3D%2Ct_100","3.jpg");
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<Boolean> s1 = executorService.submit(thread1);
        Future<Boolean>  s2 = executorService.submit(thread2);
        Future<Boolean>  s3 = executorService.submit(thread3);
        boolean rs1 = s1.get();
        boolean rs2 = s1.get();
        boolean rs3 = s1.get();
        executorService.shutdown();

    }
}

