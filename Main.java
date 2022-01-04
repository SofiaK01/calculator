package com.company;
import javax.management.StringValueExp;
import java.util.Scanner;


class Chislo {

     String ArabToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }
    Integer RomanToArab(String s) {
         String itog="";
             for (int i = 1; i <= 4000; i++) {
                 if (s.equals(ArabToRoman(i))) {
                     itog+=i;
                 }
             }
         return Integer.valueOf(itog);
        }
    }

class Problem {
    int first;
    String operation;
    int second;

    int fs;
    int ss;

    Boolean FirstIsArab=false;
    Boolean FirstIsRoman=false;
    Boolean SecondIsArab=false;
    Boolean SecondIsRoman=false;

    String temporary;

    Chislo ch = new Chislo();
    void KindOfProblem(String s){
        String[] parts = s.split(" ");
        if (parts.length>3)  throw new RuntimeException();
        for (int i = 1; i <= 10; i += 1)  {

            if ((parts[0].equals(String.valueOf(i))))  {
                FirstIsArab = true;
            }
            if (parts[0].equals(ch.ArabToRoman(i)))  {
                FirstIsRoman = true;
            }
            if ((parts[2].equals(String.valueOf(i))))  {
                SecondIsArab = true;
            }
            if (parts[2].equals(ch.ArabToRoman(i)))  {
                SecondIsRoman = true;
            }
        }

       if (FirstIsArab.equals(SecondIsArab)==false) throw new RuntimeException();
       if (FirstIsRoman.equals(SecondIsRoman)==false) throw new RuntimeException();
       if ((FirstIsArab==true) && (FirstIsArab == SecondIsArab)) ArabProblem(parts[0],parts[1],parts[2]);
       if ((FirstIsRoman==true) &&  (FirstIsRoman == SecondIsRoman)) RomeProblem(parts[0],parts[1],parts[2]);

    }
    void ArabProblem (String f, String o, String s) {

        int first = Integer.valueOf(f) ;
        int second = Integer.valueOf(s) ;
        if ((first>10) || (second>10)) throw new RuntimeException();
        if (o.equals("+"))  System.out.println(first+second);
        if (o.equals("-"))  System.out.println(first-second);
        if (o.equals("*"))  System.out.println(first*second);
        if (o.equals("/"))  System.out.println(first/second);

    }
    void RomeProblem (String f, String o, String s) {

        int first = Integer.valueOf(ch.RomanToArab(f)) ;
        int second = Integer.valueOf(ch.RomanToArab(s)) ;

        if ((first>10) || (second>10)) throw new RuntimeException();
        if (o.equals("+"))  System.out.println(ch.ArabToRoman(first+second));
        if (o.equals("-"))  {
            if  (first-second<1) throw new RuntimeException();
            System.out.println(ch.ArabToRoman(first-second));
        }
        if (o.equals("*"))  System.out.println(ch.ArabToRoman(first*second));
        if (o.equals("/"))  {
            if  (first/second<1) throw new RuntimeException();
            System.out.println(ch.ArabToRoman(first/second));
        }
    }


}
public class Main {

    public static void main(String[] args) {
        Scanner some_name = new Scanner(System.in); // Создаем объект с именем some_name
       String s = some_name.nextLine();
        Chislo ch = new Chislo();

        Problem p = new Problem();

        //  p.KindOfProblem("1 + 2");
        //  p.KindOfProblem("VI / III");
        //  p.KindOfProblem("I - II");
        //  p.KindOfProblem("I + 1");
        //  p.KindOfProblem("1");
        // p.KindOfProblem("1 + 2 + 3");
        // p.KindOfProblem("V - VI" );

        p.KindOfProblem(s);

        //Chislo ch = new Chislo();
        //System.out.println(ch.ArabToRoman(Integer.valueOf(s)));
    }
}
