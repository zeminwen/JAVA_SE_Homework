package day03;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 程序启动后，要求用户输入一个文件名，如果文件存在则提示
 * 并要求用户更换，直到该文件还不存在为止，然后将这个文件
 * 在当前目录中创建出来。
 *
 * 单词记一记:
 * exsits 存在
 * create 创建
 * new    新的
 *
 * @author Xiloer
 *
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        while (true){//while死循环的条件！！
        System.out.println("请输入文件名：");
        String filename=sc.nextLine();
        File file=new File(filename);
        if(file.exists()) {
            System.out.println("该文件已存在，请重新输入：");
        }else {
               file.createNewFile();
               System.out.println("文件已创建！");
               break;//创建完文件用break及时跳出死循环！！
        }
        }
    }
}









