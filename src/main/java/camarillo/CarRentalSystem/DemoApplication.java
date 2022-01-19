package camarillo.CarRentalSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		String sql = "INSERT INTO customer (customerID, name, mobile, email) VALUES (?,?,?,?)";
//		int i = jdbcTemplate.update(sql,4,"Abraham Camarillo","5555555555","abe.camarillo@pm.me");
//		if (i>0){
//			System.out.println("New customer added");
//		}
//	}



}
