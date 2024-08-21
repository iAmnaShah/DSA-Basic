import java.util.*;

class Product {
    String name;
    double price;
    int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

class Category {
    String name;
    List<Product> products;
    List<Category> subCategories;

    public Category(String name) {
        this.name = name;
        this.products = new ArrayList<>();
        this.subCategories = new ArrayList<>();
    }
}

class Inventory {
    List<Category> mainCategories;

    public Inventory() {
        this.mainCategories = new ArrayList<>();
    }

    public void addMainCategory(String name) {
        mainCategories.add(new Category(name));
    }

    public void addProductToCategory(String categoryName, String productName, double price, int stock) {
        Category category = findCategory(categoryName, mainCategories);
        if (category != null) {
            category.products.add(new Product(productName, price, stock));
        } else {
            System.out.println("Category not found!");
        }
    }

    public void displayCategories() {
        for (Category category : mainCategories) {
            displayCategory(category, 0);
        }
    }

    private void displayCategory(Category category, int level) {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < level; i++) {
            prefix.append("\t");
        }
        System.out.println(prefix + category.name);
        for (Product product : category.products) {
            System.out.println(prefix + "\t- " + product.name + " | Price: $" + product.price + " | Stock: " + product.stock);
        }
        for (Category subCategory : category.subCategories) {
            displayCategory(subCategory, level + 1);
        }
    }

    public void addSubCategory(String parentCategoryName, String subCategoryName) {
        Category parentCategory = findCategory(parentCategoryName, mainCategories);
        if (parentCategory != null) {
            parentCategory.subCategories.add(new Category(subCategoryName));
        } else {
            System.out.println("Parent category not found!");
        }
    }

    public void updateStock(String categoryName, String productName, int newStock) {
        Category category = findCategory(categoryName, mainCategories);
        if (category != null) {
            Product product = findProduct(productName, category);
            if (product != null) {
                product.stock = newStock;
            } else {
                System.out.println("Product not found in the category!");
            }
        } else {
            System.out.println("Category not found!");
        }
    }

    public Product searchProduct(String productName) {
        for (Category category : mainCategories) {
            Product product = findProduct(productName, category);
            if (product != null) {
                return product;
            }
        }
        return null;
    }

    private Category findCategory(String categoryName, List<Category> categories) {
        for (Category category : categories) {
            if (category.name.equals(categoryName)) {
                return category;
            }
        }
        for (Category category : categories) {
            Category foundCategory = findCategory(categoryName, category.subCategories);
            if (foundCategory != null) {
                return foundCategory;
            }
        }
        return null;
    }

    private Product findProduct(String productName, Category category) {
        for (Product product : category.products) {
            if (product.name.equals(productName)) {
                return product;
            }
        }
        for (Category subCategory : category.subCategories) {
            Product foundProduct = findProduct(productName, subCategory);
            if (foundProduct != null) {
                return foundProduct;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding Main Categories
        inventory.addMainCategory("Electronics");
        inventory.addMainCategory("Clothing");

        // Adding Products to Categories
        inventory.addProductToCategory("Electronics", "Smartphone", 699.99, 50);
        inventory.addProductToCategory("Clothing", "T-Shirt", 19.99, 100);

        // Adding Subcategory
        inventory.addSubCategory("Electronics", "Accessories");
        inventory.addProductToCategory("Electronics/Accessories", "Headphones", 129.99, 30);

        // Displaying Categories and Products
        inventory.displayCategories();

        // Updating Stock
        inventory.updateStock("Clothing", "T-Shirt", 80);

        // Searching for a Product
        Product foundProduct = inventory.searchProduct("Smartphone");
        if (foundProduct != null) {
            System.out.println("Product Found: " + foundProduct.name + " | Price: $" + foundProduct.price + " | Stock: " + foundProduct.stock);
        } else {
            System.out.println("Product not found!");
        }
    }
}
