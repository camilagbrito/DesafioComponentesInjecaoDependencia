package com.desafio.comp_injecao_dependencia;

import com.desafio.comp_injecao_dependencia.entities.Order;
import com.desafio.comp_injecao_dependencia.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.desafio"})
public class CompInjecaoDependenciaApplication implements CommandLineRunner {
	@Autowired
	private OrderService orderService;
	public static void main(String[] args)  {
		SpringApplication.run(CompInjecaoDependenciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int code = sc.nextInt();
		double basic = sc.nextDouble();
		double discount = sc.nextDouble();
		Order order = new Order(code, basic, discount);

		System.out.println("Pedido código: " + order.getCode());
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order));

		sc.close();
	}
}
