package ma.bdcc.customerservice;

import ma.bdcc.customerservice.config.GlobalConfig;
import ma.bdcc.customerservice.entities.Customer;
import ma.bdcc.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			List<Customer> customerList	= List.of(
					Customer.builder()
							.firstName("Zineb")
							.lastName("Merzak")
							.email("zineb@hotmail.com")
							.build(),
					Customer.builder()
							.firstName("Younes")
							.lastName("Merzak")
							.email("younes@hotmail.com")
							.build()
			);
			customerRepository.saveAll(customerList);
		};
	}

}
