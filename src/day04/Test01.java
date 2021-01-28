package day04;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 改正下面程序的错误
 *
 * 在解决错误的同时，用注释标注什么原因导致问题的出现
 *
 * 程序功能需求:使用块读写方式复制指定的文件
 *
 * 单词记一记:
 * src  是单词source的缩写形式，表示来源
 *      下面使用src表示源文件，就是复制的数据来源的文件
 *
 * read 读
 * write 写
 * close 关闭
 * @author Xiloer
 *
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        //没有导包RAF
        RandomAccessFile src = new RandomAccessFile("./test.txt","r");
        //RandomAccessFile desc = new RandomAccessFile("./test_cp.txt","r");要写成"rw"！！
        RandomAccessFile desc = new RandomAccessFile("./test_cp.txt","rw");

        int len;
        byte[] data = new byte[1024*10];
        long start =System.currentTimeMillis();
        while((len = src.read(data))!=-1) {
            desc.write(data, 0, len);
        }
        long end =System.currentTimeMillis();
        //System.err.println("复制完毕!"); 应该写成System.out.println();
        System.out.println("复制完毕!耗时"+(end-start)+"ms");
        src.close();
        desc.close();
    }

}
