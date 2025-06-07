import java.util.ArrayList;
import java.util.Scanner;


public class java_project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        public class Main {
            public static void main(String[] args) {
                ArrayList<Restaurant> stores = new ArrayList<>();
                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.println("\n명령어를 입력하세요 (+ 추가 / e 수정 / q 종료 / 출력 enter):");
                    String input = scanner.nextLine();

                    if (input.equals("+")) {
                        System.out.print("식당 이름: ");
                        String name = scanner.nextLine();
                        System.out.print("자리 수: ");
                        int seats = Integer.parseInt(scanner.nextLine());
                        System.out.print("혼잡도 (0~100): ");
                        int congestion = Integer.parseInt(scanner.nextLine());

                        stores.add(new Restaurant(name, seats, congestion));
                        System.out.println("식당이 추가되었습니다.");
                    } else if (input.equals("e")) {
                        System.out.print("수정할 식당 이름 입력: ");
                        String name = scanner.nextLine();

                        boolean found = false;
                        for (Restaurant r : stores) {
                            if (r.getName().equalsIgnoreCase(name)) {
                                System.out.print("새 혼잡도 입력 (0~100): ");
                                int newCongestion = Integer.parseInt(scanner.nextLine());
                                r.setCongestion(newCongestion);
                                System.out.println("혼잡도가 수정되었습니다.");
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("해당 이름의 식당을 찾을 수 없습니다.");
                        }
                    } else if (input.equals("q")) {
                        break;
                    } else {
                        System.out.println("\n[현재 식당 목록]");
                        for (Restaurant r : stores) {
                            r.printInfo();
                        }
                    }
                }
