package CartAPP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();

        // TODO: 상품 클래스를 생성하여 상품 목록에 넣는다.

        // 파일 경로
        String filePath = "cartAPP/ProductList.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(","); // 콤마로 구분
            int key = Integer.parseInt(data[0]);
            String name = data[1];
            int cost = Integer.parseInt(data[2]);
            productSet.add(new Product(key, name, cost)); // 상품 객체 생성 및 추가
        }
        br.close();

        // 상품 목록 확인
        System.out.println("<마트 상품 목록>");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        // 장바구니 생성
        Cart myCart = new Cart(productSet);

        // TODO: 상품을 장바구니에 추가
        myCart.addProduct("소고기", 3);

        // TODO: 상품을 장바구니에서 제거
        // 장바구니에서 적절히 제거
        myCart.removeProduct("소고기", 1);
        // 없는 상품을 제거하려는 시도
        myCart.removeProduct("스테이크", 1);
        // 수량을 초과하여 제거하려는 시도
        myCart.removeProduct("소고기", 10);

        // TODO: 장바구니에 현재 담긴 상품들을 출력 (상품이름, 각 상품의 개수)
        myCart.showItems();
    }

}
