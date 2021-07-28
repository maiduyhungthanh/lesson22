import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Repository {

    List<Product> listProducts = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public Repository() {
        listProducts.add(new Product("01", "Bánh Doraemon 3 vị", Category.FOOD, 100, 3500, 57));
        listProducts.add(new Product("02", "Xúc xích sườn non" , Category.FOOD, 150, 3500, 12));
        listProducts.add(new Product("03", "Thanh cua", Category.FOOD, 100, 5000, 85));
        listProducts.add(new Product("04", "Bánh khoai môn", Category.FOOD, 200, 42000, 78));
        listProducts.add(new Product("05", "Thìa ăn cơm inox mạ vàng", Category.HOUSEWARE, 50, 8000, 4));
        listProducts.add(new Product("06", "Bát đựng gia vị", Category.HOUSEWARE, 65, 4000, 44));
        listProducts.add(new Product("07", "Nước Hoa Hồng Soothing Facial Toner Simple", Category.COSMETICS, 140, 92000, 88));
        listProducts.add(new Product("08", "Combo gội xả HAIRBURST", Category.COSMETICS, 100, 639000, 7));
        listProducts.add(new Product("09", "Tinh chất dưỡng ẩm sâu Klairs Rich Moist Soothing Serum", Category.COSMETICS, 50, 249000, 24));
        listProducts.add(new Product("10", "Kem dưỡng thể Paula’s Choice RESIST WEIGHTLESS BODY TREATMENT", Category.COSMETICS, 80, 715000, 63));
        listProducts.add(new Product("11", "Ao thun TSUN", Category.FASHION, 250, 320000, 146));
    }
        //CASE 1:
    public void show(){
        //Sử dụng foreach
        // for (Product product : listProducts) {
        //     System.out.println(product);
        // }

        //Sử dụng lambda
        listProducts.forEach(product -> System.out.println(product));
    }
      
        // CASE 2:
        public void filterProductByPrice() {
            // for (Product product : listProducts) {
            //     if(product.getPrice() > 10000){
            //         System.out.println(product);
            //     }
            // }
            //Sử dụng lambda và stream
            listProducts.stream().filter(product -> product.getPrice() > 10000)
                    .forEach(product -> System.out.println(product));

        }
    
       

        //CASE 3 :
        public void countProductByAmountSale() {
            long count = listProducts.stream().filter(product -> product.getAmountSale() >= 50).count();

            System.out.println("Số lượng sản phẩm bán được từ 50 trở lên là: " + count);
        }

    
        //CASE 4:
        public void pickCategory() {

            Menu.chooseCategory();
            int pick = sc.nextInt();
            switch (pick) {
                case 1:
                    listProducts.stream().filter(product -> product.getCategory() == Category.FOOD)
                            .forEach(product -> System.out.println(product));
                case 2:
                    listProducts.stream().filter(product -> product.getCategory() == Category.HOUSEWARE)
                            .forEach(product -> System.out.println(product));
                case 3:
                    listProducts.stream().filter(product -> product.getCategory() == Category.COSMETICS)
                            .forEach(product -> System.out.println(product));
                case 4:
                    listProducts.stream().filter(product -> product.getCategory() == Category.FASHION)
                            .forEach(product -> System.out.println(product));
            }
        }
         
        //CASE 5
         public void sortProductBySale(){
      
             Collections.sort(listProducts, new Comparator<Product>() {
                 @Override
                 public int compare(Product o1, Product o2) {
                    
                    // TODO Auto-generated method stub
                     
                     return (int) (o2.getAmountSale() - o1.getAmountSale());
                 }
               
             });
             System.out.println("Danh sách SP sắp xếp theo SL bán được : ");
             listProducts.forEach(product -> System.out.println(product.toString()));
    }
    //CASE 6
    public void bestProductBySale() {
       
        
   
       Product maxProduct =  listProducts.stream().max(new Comparator<Product>(){

            @Override
            public int compare(Product o1, Product o2) {
                int temp = o1.getAmountSale() > o2.getAmountSale() ? 1: -1;
                return temp;
            } 
        }).get();
        System.out.println(maxProduct);
    }

        
      //CASE 7
    public void sortProductByName(){
        //Sử dụng comparator
        // listProducts.sort(new Comparator<Product>(){

        //     @Override
        //     public int compare(Product o1, Product o2) {
        //         return o1.getName().compareTo(o2.getName());
        //     }
            
        // });

        //sử dụng lambda
        listProducts.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
    }
    
}
