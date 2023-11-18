package vn.edu.iuh.fit.www_week07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.www_week07.backend.enums.ProductStatus;
import vn.edu.iuh.fit.www_week07.backend.models.Product;
import vn.edu.iuh.fit.www_week07.backend.repositories.ProductRepository;
import net.datafaker.Faker;
import net.datafaker.providers.base.Device;
import java.util.Random;

@SpringBootApplication
public class WwwWeek07Application {

    public static void main(String[] args) {
        SpringApplication.run(WwwWeek07Application.class, args);
    }
    @Autowired
    private ProductRepository productRepository;
    @Bean
    CommandLineRunner createSampleProduct()
    {
        return args -> {
            Faker faker=new Faker();
            Random rnd=new Random();
            Device devices=faker.device();
            for(int i=0;i<200;i++)
            {
                Product product=new Product(
                        devices.modelName(),
                        faker.lorem().paragraph(30),
                        "piece",
                        devices.manufacturer(),
                        ProductStatus.ACTIVE
                );
                productRepository.save(product);
            }
        };
    }

}
