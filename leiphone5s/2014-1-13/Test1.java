package com.eoe.oop.day03.car.entity;

import com.eoe.oop.day03.car.Car;
import com.eoe.oop.day03.car.Motion;
import com.eoe.oop.day03.entity.Action;

public class Test1 {
public static void main(String[] args) {
	Car car=new Car("凯迪拉克",1000000);
	car.run();
	car.stop();	
	System.out.println(car.getCarName()+"价格:"+car.getPrice()+"元");
	Motion motion=new Car("林肯",400000);
	System.out.println();
	motion.run();
	motion.stop();
	if(motion instanceof Car){
		System.out.println(((Car) motion).getCarName()+"价格:"+((Car)motion).getPrice());
	}
	System.out.println();
	Action action=new Car("红旗",500000);
	action.run();
	if(action instanceof Car){
	((Car)action).stop();
	System.out.println(((Car) action).getCarName()+"价格:"+((Car) action).getPrice()+"元");
	}
}
}
