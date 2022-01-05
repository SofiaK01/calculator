class Problem {

    Boolean FirstIsArab=false;
    Boolean FirstIsRoman=false;
    Boolean SecondIsArab=false;
    Boolean SecondIsRoman=false;


    Chislo ch = new Chislo();

    void kindOfProblem(String s){
        String[] parts = s.split(" ");

        Character firstChar = parts[0].charAt(0);

        if (parts.length>3)  throw new RuntimeException();

        String candArab = "123456789";
        String candRome = "IVX";
        if (candArab.indexOf(firstChar) >= 0) FirstIsArab = true;
        if (candRome.indexOf(firstChar) >= 0) FirstIsRoman = true;

        firstChar = parts[2].charAt(0);
        if (candArab.indexOf(firstChar) >= 0) SecondIsArab = true;
        if (candRome.indexOf(firstChar) >= 0) SecondIsRoman = true;



        if (!FirstIsArab.equals(SecondIsArab)) throw new RuntimeException();
        if (!FirstIsRoman.equals(SecondIsRoman)) throw new RuntimeException();
        if ((FirstIsArab) && (FirstIsArab == SecondIsArab)) arabProblem(parts[0],parts[1],parts[2]);
        if ((FirstIsRoman) &&  (FirstIsRoman == SecondIsRoman)) romeProblem(parts[0],parts[1],parts[2]);

    }
    int answer (int f, int s, String o) {
        if ((f>10) || (s>10)) throw new RuntimeException();
        if (o.equals("+"))  return (f+s);
        if (o.equals("-"))  return (f-s);
        if (o.equals("*"))  return (f*s);
        if (o.equals("/"))  return (f/s);
        return 0;
    }
    void arabProblem (String f, String o, String s) {

        int first = Integer.valueOf(f) ;
        int second = Integer.valueOf(s) ;

        System.out.println(answer(first, second, o));


    }
    void romeProblem (String f, String o, String s) {

        int first = ch.romanToArab(f) ;
        int second = ch.romanToArab(s) ;
        int answer;
        answer=answer(first, second, o);
        if (answer < 1)   throw new RuntimeException();
        System.out.println(ch.arabToRoman(answer));

    }


}
