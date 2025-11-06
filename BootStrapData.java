package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        long numProds = productRepository.count();
        long numParts = partRepository.count();

        if (numProds + numParts == 0) {
            // add 5 products and 5 parts
            InhousePart testPart1 = new InhousePart();
            testPart1.setPartId(1);
            testPart1.setName("Wheels (set of 4)");
            testPart1.setPrice(52.0);
            testPart1.setInv(5);
            testPart1.setProducts(null);
            testPart1.setMaxInv(50);
            testPart1.setMinInv(0);

            InhousePart testPart2 = new InhousePart();
            testPart2.setPartId(2);
            testPart2.setName("Trucks (set of 2)");
            testPart2.setPrice(40.0);
            testPart2.setInv(5);
            testPart2.setProducts(null);
            testPart2.setMaxInv(50);
            testPart2.setMinInv(0);

            InhousePart testPart3 = new InhousePart();
            testPart3.setPartId(3);
            testPart3.setName("Skateboard Deck");
            testPart3.setPrice(65.0);
            testPart3.setInv(5);
            testPart3.setProducts(null);
            testPart3.setMaxInv(50);
            testPart3.setMinInv(0);

            InhousePart testPart4 = new InhousePart();
            testPart4.setPartId(4);
            testPart4.setName("Bearings (set of 8)");
            testPart4.setPrice(17.95);
            testPart4.setInv(5);
            testPart4.setProducts(null);
            testPart4.setMaxInv(50);
            testPart4.setMinInv(0);

            InhousePart testPart5 = new InhousePart();
            testPart5.setPartId(5);
            testPart5.setName("Grip tape");
            testPart5.setPrice(17.95);
            testPart5.setInv(5);
            testPart5.setProducts(null);
            testPart5.setMaxInv(50);
            testPart5.setMinInv(0);

            // 5 products
            Product testProduct1 = new Product("Skateboard", 150.0, 5);
            testProduct1.setParts(null);

            Product testProduct2 = new Product("Long board", 200.0, 5);
            testProduct2.setParts(null);

            Product testProduct3 = new Product("Penny board", 150.0, 5);
            testProduct3.setParts(null);

            Product testProduct4 = new Product("Snow board", 300.0, 5);
            testProduct4.setParts(null);

            Product testProduct5 = new Product("Cruiser board", 172.0, 5);
            testProduct5.setParts(null);

            // store items in a set & save data to db
            Set<Part> testPartsSet = new HashSet<>();
            testPartsSet.add(testPart1);
            partRepository.save(testPart1);
            testPartsSet.add(testPart2);
            partRepository.save(testPart2);
            testPartsSet.add(testPart3);
            partRepository.save(testPart3);
            testPartsSet.add(testPart4);
            partRepository.save(testPart4);
            testPartsSet.add(testPart5);
            partRepository.save(testPart5);

            Set<Product> testProductsSet = new HashSet<>();
            testProductsSet.add(testProduct1);
            productRepository.save(testProduct1);
            testProductsSet.add(testProduct2);
            productRepository.save(testProduct2);
            testProductsSet.add(testProduct3);
            productRepository.save(testProduct3);
            testProductsSet.add(testProduct4);
            productRepository.save(testProduct4);
            testProductsSet.add(testProduct5);
            productRepository.save(testProduct5);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products " + productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts " + partRepository.count());
        System.out.println(partRepository.findAll());
    }
}
