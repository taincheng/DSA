package luogu_project.xs.first_Strings;
import java.util.Scanner;

/*
题目描述
    一般的文本编辑器都有查找单词的功能，该功能可以快速定位特定单词在文章中的位置,
有的还能统计出特定单词在文章中出现的次数。现在，请你编程实现这一功能，
具体要求是：给定一个单词，请你输出它在给定的文章中出现的次数和第一次出现的位置。
    注意：匹配单词时，不区分大小写，但要求完全匹配，即给定单词必须与文章中的某一独立单词
在不区分大小写的情况下完全相同（参见样例1 ），如果给定单词仅是文章中某一单词的一部分则不算匹配（参见样例2 ）。
 */
public class Statistics_words {

    public static void main(String arg[]){
        int num = 0;
        int first = 0;
        Scanner s = new Scanner(System.in);
        String word = s.nextLine();
        String words = s.nextLine();
        String[] sp = words.trim().split(" ");
        for(int i = 0;i<sp.length;i++){
            word = word.toLowerCase();
            if(word.trim().equals(sp[i].toLowerCase())){
                num ++;
                if (num==1) first = i;
            }
        }
        if(num != 0){
            System.out.print(num+" ");
            System.out.print(first);
        }else{
            System.out.println("-1");
        }

    }
}
