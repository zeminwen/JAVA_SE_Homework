package day04;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 完成修改昵称工作
 *
 * 程序启动后，要求用户输入用户名和新的昵称
 * 然后修改user.dat文件中该用户的昵称
 * 如果输入的用户不存在，则输出"查无此人"
 *
 * 思路:
 * 可以分几步实现:
 * 1:首先获取用户输入的用户名和新的昵称
 * 2:尝试循环读取user.dat文件中的每个用户名并打桩输出到控制台
 * 3:在读取用户名没有问题后，加上一个判断，判断该用户名是否为当前
 *   用户输入的用户名，匹配上则打桩输出
 * 4:如果匹配测试没问题，在分支中将指针移动到这条记录的昵称位置，
 *   需要思考昵称位置的计算。
 *   然后将昵称转换为字节后扩容到32字节写入覆盖即可。
 * @author Xiloer
 *
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf=new RandomAccessFile("user.dat","rw");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名");
        String username=scanner.nextLine();
        System.out.println("请输入新昵称");
        String nickname=scanner.nextLine();
        boolean update=false;
        for(int i=0;i<raf.length()/100;i++){
            byte[] data=new byte[32];
            raf.seek(100*i);//指针定位到每个用户名开头的位置
            raf.read(data);
            String orusername=new String(data,"utf-8").trim();
            if (username.equals(orusername)) {
                raf.seek(i * 100 + 64);//指针定位到每个昵称开头的位置
                data = nickname.getBytes("UTF-8");
                data = Arrays.copyOf(data, 32);
                raf.write(data);
                update=true;
                break;
            }
        }
        if (update) {
            System.out.println("昵称已修改成：" + nickname);
        }else {
            System.out.println("查无此人");
        }
        raf.close();
    }
}

