import java.util.ArrayList;
import java.util.Scanner;

// 식당 정보를 담는 클래스
class Restaurant {
    private String name;        // 식당 이름
    private int seats;          // 자리 수 (사용되지 않지만 정보 저장됨)
    private int congestion;     // 혼잡도 (0~100)

    // 생성자
    public Restaurant(String name, int seats, int congestion) {
        this.name = name;
        this.seats = seats;
        this.congestion = congestion;
    }

    // 식당 이름 반환
    public String getName() {
        return name;
    }

    // 혼잡도 설정
    public void setCongestion(int congestion) {
        this.congestion = congestion;
    }

    // 혼잡도를 시각화하여 반환 (●: 혼잡, ○: 여유)
    public String getCongestionVisual() {
        int dots = congestion / 20 + (congestion % 20 > 0 ? 1 : 0); // 0~100 -> 최대 5단계로 표시
        if (dots > 5) dots = 5;
        StringBuilder visual = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (i < dots) visual.append("●");
            else visual.append("○");
        }
        return visual.toString();
    }

    // 식당 정보 출력
    public void printInfo() {
        System.out.println(name + " " + getCongestionVisual());
    }
}

// 메인 클래스
public class java_project {
    public static void main(String[] args) {
        ArrayList<Restaurant> stores = new ArrayList<>(); // 식당 리스트
        Scanner scanner = new Scanner(System.in);         // 사용자 입력 스캐너

        while (true) {
            // 명령어 입력 안내
            System.out.println("\n명령어를 입력하세요 (+ 추가 / e 수정 / q 종료 / 출력 enter):");
            String input = scanner.nextLine();

            // 식당 추가
            if (input.equals("+")) {
                System.out.print("식당 이름: ");
                String name = scanner.nextLine();
                System.out.print("자리 수: ");
                int seats = Integer.parseInt(scanner.nextLine());
                System.out.print("혼잡도 (0~100): ");
                int congestion = Integer.parseInt(scanner.nextLine());

                stores.add(new Restaurant(name, seats, congestion));
                System.out.println("식당이 추가되었습니다.");

                // 식당 혼잡도 수정
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

                // 프로그램 종료
            } else if (input.equals("q")) {
                break;

                // 현재 식당 목록 출력
            } else {
                System.out.println("\n[현재 식당 목록]");
                for (Restaurant r : stores) {
                    r.printInfo();
                }
            }
        }

        scanner.close(); // 스캐너 닫기
    }
}
