package com.estudotiago.desafio;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.estudotiago.desafio.entities.Order;
import com.estudotiago.desafio.service.OrderService;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;


	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.println("-----Dados do pedido----");
		
		System.out.println("Códido:");
		int code = sc.nextInt();
		
		System.out.println("Valor básico: ");
		double valueBasic = sc.nextDouble();
		
		System.out.println("Desconto: ");
		double discount = sc.nextDouble();
		
		Order order = new Order(code, valueBasic, discount);
		
		System.out.println(" ");

		System.out.println("Pedido código " + order.getCode());

		System.out.printf("Valor total: R$ %.2f", orderService.total(order));

		
		
		sc.close();
		

		
	}

}
