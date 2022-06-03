package com.vkhalec.coffee.shared;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "coffee_orders")
public class CoffeeOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coffee")
    private Coffee coffee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coffee_machine")
    private CoffeeMachine coffeeMachine;

    @Column(name = "date", nullable = false, updatable = false, insertable = false)
    private String date;

    public CoffeeOrder() {

    }

    public CoffeeOrder(Integer id, Coffee coffee, CoffeeMachine coffeeMachine, String date) {
        this.id = id;
        this.coffee = coffee;
        this.coffeeMachine = coffeeMachine;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public CoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }

    public void setCoffeeMachine(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}