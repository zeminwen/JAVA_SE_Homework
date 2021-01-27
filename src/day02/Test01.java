package day02;

import java.util.Scanner;

/**
 * 正则表达式练习:
 * 1:编写匹配数字的正则表达式,数字至少一位以上.
 *
 * 2:匹配字符串,要求输入3-15位,内容只能是数字,字母下,划线
 *
 *
 * 完成下面编程题:
 * 程序启动后,要求用户输入用户名,用户名出现内容要求上述正则表达式2的要求.不匹配则直接
 * 提示用户名有误.
 * 如果无误,则要求用户继续输入年龄,规则为上述正则表达式1的要求,不匹配则提示年龄有误
 * 以上两个输入获取是都要求以字符串形式接受(Scanner的nextLine方法获取)
 *
 * 最后验证年龄在1-100岁之间(包含1和100)
 * 提示:这里可以不用正则表达式验证范围,是否转换为数字判定更方便?
 * @author Xiloer
 *
 */
public class Test01 {
    public static void main(String[] args) {
        String regex1="[0-9]+";
        String regex2="[a-zA-Z0-9_]{3,15}";
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String name=sc.nextLine();
        //boolean match1=name.matches(regex2);本行多余，可以直接写
        //在if()中
        if (name.matches(regex2)) {
            System.out.println("请输入年龄：");
            String ageStr=sc.nextLine();
            //boolean match2=age.matches(regex1);此处同理，多余！
            if (ageStr.matches(regex1)) {
                int age=Integer.parseInt(ageStr);
                if (age>0&&age<101) {
                    System.out.println(name+","+age);
                }else{
                    System.out.println("年龄输入错误！");
                }
            }else {
            System.out.println("年龄输入错误");
            }
        }else {
            System.out.println("用户名输入错误！");
        }
    }
}
