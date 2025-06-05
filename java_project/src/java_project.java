import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class java_project {
    public static void main(String[] args) {

        List<String> storelist = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Store name");
        String input = sc.nextLine();

        storelist.add(input);
        System.out.println(storelist);
    }
}
