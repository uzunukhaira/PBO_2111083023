/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzu010423;

/**
 *
 * @author LABP1KOMP
 */
public class AbstractClass {
    public static void main(String[] args) {
        
        Shape circle = new Circle(14);
        System.out.println("Area of " + circle.getName() + " with radius " + ((Circle) circle).getRadius()  + " is " + circle.getArea());

        System.out.println();
        
        Shape square = new Square(12);
        System.out.println("Area of " + square.getName() + " with side " + ((Square) square).getSide()  +  " is " + square.getArea());
    }
}
