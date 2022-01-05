class Main {

    public static void main(String[] args) {
        Scanner someName = new Scanner(System.in); // Создаем объект с именем some_name
        String s = someName.nextLine();

        Problem p = new Problem();
        p.kindOfProblem(s);

    }
}
