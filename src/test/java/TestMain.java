public class TestMain {
    public static void main(String[] args) {
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            System.out.print(" ".repeat(rows - i));
            System.out.println("#".repeat(2 * i - 1));
        }
    }
}


class Person{
    private String name;


    public Person(String name){
        this.name = name;
    }

    public String getname(){
        return name;
    }

    public void setname(String name){
        this.name = name;
    }
}