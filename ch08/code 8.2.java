// 코드 8.2  주문: 피자 주문과 관련된 모든 상세 정보의 전달

package com.springinaction.pizza.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private Customer customer;
    private List<Pizza> pizzas;
    private Payment payment;

    public Order() {
	pizzas = new ArrayList<Pizza>();
	customer = new Customer();
    }
    public Customer getCustomer() {
	return customer;
    }
    public void setCustomer(Customer customer) {
	this.customer = customer;
    }
    public List<Pizza> getPizzas() {
	return pizzas;
    }
    public void setPizzas(List<Pizza> pizzas) {
	this.pizzas = pizzas;
    }
    public void addPizza(Pizza pizza) {
	pizzas.add(pizza);
    }
    public float getTotal() {
	return 0.0f;
    }
    public Payment getPayment() {
	return payment;
    }
    public void setPayment(Payment payment) {
	this.payment = payment;
    }

}
