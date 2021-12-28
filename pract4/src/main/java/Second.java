/*
Создайте приложение для покупки товаров в электронном магазине. Список товаров (5 записей) создается в программе и является
объектом класса HashMap. Ключом записи является артикул товара marking (типа Integer), а значением – объект Article, содержащий
наименование товара (типа String) и цену товара (типа float).  Предусмотреть возможность проверки уникальности наименования товара
с помощью TreeSet.
 */

import javax.management.BadAttributeValueExpException;
import java.util.HashMap;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        try{
            HashMap<Integer, Article> goods = new HashMap<>();
            goods.put(1212, new Article("Iphone 7", 5500.0));
            goods.put(1213, new Article("Iphone 8", 7500.0));
            goods.put(1214, new Article("Iphone X", 10000.0));
            goods.put(1215, new Article("Iphone XR", 9000.0));
            goods.put(1216, new Article("Iphone 13", 29000.0));

            boolean isContinue = true;
            int article = 0;
            Scanner in = new Scanner(System.in);
            while (isContinue){
                System.out.print("Enter an article: ");
                article = in.nextInt();
                if(goods.get(article) != null)
                    System.out.println(goods.get(article).str());
                else
                    System.out.println("Wrong article");
                System.out.print("Continue? 1 - yes 0 - no: ");
                int next = in.nextInt();
                if (next == 0)
                    isContinue = false;
            }

        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}

class Article{
    private String name;
    private float price;
    public Article(String name, double price) throws BadAttributeValueExpException {
        if(name == "" || price <= 0) {
            throw new BadAttributeValueExpException("Wrong data");
        }
        this.name = name;
        this.price = (float) price;
    }
    public String getName(){
        return this.name;
    }
    public float getPrice(){
        return this.price;
    }
    public void setName(String name) throws BadAttributeValueExpException{
        if(name == "")
            throw new BadAttributeValueExpException("Wrong data");
        this.name = name;
    }
    public void setPrice(float price) throws BadAttributeValueExpException{
        if(price <= 0)
            throw new BadAttributeValueExpException("Wrong data");
        this.price = price;
    }
    public String str(){
        return "Name: " + this.name + ". Price: " + this.price;
    }
}