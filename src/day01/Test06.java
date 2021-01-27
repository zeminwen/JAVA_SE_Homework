package day01;

import com.sun.javaws.jnl.IconDesc;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Random;
import java.util.Scanner;

/**
 * 生成一个4位验证码(数字和字母的组合)
 * 然后输出到控制台并提示用户输入该验证码，只要用户输入正确(无论大小写都算)，
 * 就输出:验证码正确，否则输出:验证码错误
 *
 *
 * 验证码如何生成?
 * 思路导向填空:
 * 1:要先确定生成的内容范围(列出所有可以出现的字符):
 *
 * 2:先思考如何生成其中的一个字符呢？
 *   2.1:确定怎么保存这些可以出现的字符:
 *
 *   2.2:怎么能随机抽选一个
 *
 * 3:既然可以生成一个，如何做到生成4个或更多个?
 *
 * 4:怎么在生成这些字符的过程中将他们组成一个字符串?
 *
 * 5:获取到用户输入的字符串后怎么与之比较,要利用到哪些字符串操作?
 *
 *
 * @author Xiloer
 *
 */
public class Test06 {
    public static void main(String[] args) {
        String s="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";
        Random rand=new Random();
        String code="";
        for (int i=0;i<4;i++){
            int index=rand.nextInt(s.length());
            char c=s.charAt(index);
            code+=c;
        }
        System.out.println("验证码："+code);
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入验证码：");
        String input=sc.nextLine();
        if (code.equalsIgnoreCase(input)) {
            System.out.println("输入正确");
        }else{
            System.out.println("输入错误");
        }

    }
}