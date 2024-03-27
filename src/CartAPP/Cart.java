package CartAPP;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {

    private Map<Product, Integer> productQuantities;
    private Map<String, Product> productCatalog;

    public Cart(Set<Product> productCatalog) {
        this.productQuantities = new HashMap<>();
        this.productCatalog = new HashMap<>();
        for (Product product : productCatalog) {
            this.productCatalog.put(product.getName(), product);
        }
    }

    public void addProduct(String productName, int quantity) {
        Product product = productCatalog.get(productName);
        if (product != null) {
            productQuantities.merge(product, quantity, Integer::sum);
            System.out.println(productName + " 을(를) 장바구니에 추가했습니다. (현재 수량: " + quantity + ")");
        } else {
            System.out.println(productName + " 상품을 찾을 수 없습니다.");
        }
    }

    public void removeProduct(String productName, int quantity) {
        Product product = productCatalog.get(productName);
        if (product == null) {
            System.out.println(productName + " 상품을 찾을 수 없습니다.");
            return;
        }

        Integer currentQuantity = productQuantities.get(product);
        // 장바구니에 없는 상품 제거 시도
        if (currentQuantity == null) {
            System.out.println(productName + " 은(는) 장바구니에 없습니다.");
        } else if (quantity >= currentQuantity) {
            // 제거하려는 수량이 현재 수량보다 많음 -> 완전히 제거
            productQuantities.remove(product);
            System.out.println(productName + " 을(를) 장바구니에서 완전히 제거했습니다.");
        } else {
            // 적절히 입력되면 해당 수량만큼 제거
            productQuantities.put(product, currentQuantity - quantity);
            System.out.println(productName + "의 수량을 " + quantity + "만큼 줄였습니다. (현재 수량: " + (currentQuantity - quantity) + ")");
        }
    }


    public void showItems() {
        if (productQuantities.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
        } else {
            System.out.println("장바구니에 있는 상품 목록:");
            for (Map.Entry<Product, Integer> entry : productQuantities.entrySet()) {
                System.out.println(entry.getKey().getName() + " : " + entry.getValue() + "개");
            }
        }
    }
}
