package com.hunter.commonUtil;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import java.io.*;
import java.util.List;

/**
 * Created by homelink on 2016/6/12.
 */
public final class FileUtil {
    /**
     * 按行读取文件
     * @param fileName
     * @return
     * @throws Exception
     */
    public static List<String> readFileByLines(String fileName)throws Exception {
        if(Strings.isNullOrEmpty(fileName)){
            throw new Exception("fileName is null or empty");
        }
        List<String> data = Lists.newArrayList();
        FileInputStream  file = new FileInputStream (fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(file,"GBK"));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                data.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            throw new Exception("read file by Lines is error");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return data;
    }

    /**
     * 按行写入文件
     * @param content
     * @param fileName
     * @throws IOException
     */
    public static void writeFileByLines(List<String> content, String fileName) throws IOException {
        File file = new File(fileName);// 指定要写入的文件
        if (!file.exists()) {// 如果文件不存在则创建
            file.createNewFile();
        }
        // 获取该文件的缓冲输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        // 写入信息
        for (String c : content) {
            bufferedWriter.append(c);
            bufferedWriter.newLine();// 表示换行
        }
        bufferedWriter.flush();// 清空缓冲区
        bufferedWriter.close();// 关闭输出流
    }

    /**
     * 测试方法
     * @param arg
     */
    public static void main(String arg[]){
        try {
            List<String> datelist=FileUtil.readFileByLines("D:\\用户账户\\Desktop\\纪录.txt");
            FileUtil.writeFileByLines(datelist,"D:\\用户账户\\Desktop\\纪录1.txt");
            for(int i=0;i<datelist.size();i++){
                System.out.println(datelist.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
