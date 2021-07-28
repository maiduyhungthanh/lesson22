import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Repository repository = new Repository();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menu.mainMenu();
            int choose = scanner.nextInt();
            switch (choose) {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    System.out.println("DANH SÁCH SẢN PHẨM");
                    repository.show();
                    System.out.println("----------------------------------------------------------------------------");
                    break;

                case 2:
                    System.out.println("Các sản phẩm có giá trên 10.000 VNĐ: ");
                    repository.filterProductByPrice();
                    System.out.println("----------------------------------------------------------------------------");
                    break;

                case 3:
                    repository.countProductByAmountSale();
                    System.out.println("----------------------------------------------------------------------------");
                    break;
                case 4:
                   repository.pickCategory();
                    

                    System.out.println("----------------------------------------------------------------------------");
                    break;
                case 5:
                    repository.sortProductBySale();;
                    System.out.println("----------------------------------------------------------------------------");
                    break;
                case 6:
                    repository.bestProductBySale();
                    System.out.println("----------------------------------------------------------------------------");
                    break;
                case 7:
                    repository.sortProductByName();
                    System.out.println("Sản phẩm sau khi sắp xếp: ");
                    System.out.println("----------------------------------------------------------------------------");
                    repository.show();
            }
        }
    }
}