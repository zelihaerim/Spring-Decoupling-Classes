package com.springdemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
// bu class application xml dosyasinin yerini tutmasi icin kullanilacak
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration // Bu dosyanin configurasyon dosyasi oldugunu belirtir.
@ComponentScan("com.springdemo")// Bu paketteki tum classlari arayacak , getBean parametresi database old. icin 
// @Component("database") 'i arayacak.

@PropertySource("classpath:values.properties")// bu filedan valueleri okuruz
// @Value("${variablename}") -> bu gosterimler properysource tanimlanirsa anlamlidir, dosyadan variablelari okumak icin
public class IocConfig { // Application context xml dosyasinin yerini tutacak.
	@Bean // ICustomerDal dan inherit edilen MySql.. ve MsSql.. siniflarina gidip,
	// her seferinde üzerine @Component("database") yazmamak ve bu karmasikliktan kurtulmak icin bean tanimlariz
	// @Component("database") yerine "database" adinda bir fonksiyon implement edelim.
	public ICustomerDal database(){// bu function ms sql de return edebilir my sql de, cunku her ikisi de implements ettiler.
		return new MySqlCustomerDal();
		// new MySqlCustomerDal();
	}
	@Bean
	public ICustomerService service() {
		return new CustomerManager(database());//database() ne donerse o tipte bir manager olusacak ve
		// service function return edecek
	}
}
