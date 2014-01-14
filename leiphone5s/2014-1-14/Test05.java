package com.eoe.oop.se1.day01;

import com.eoe.oop.day03.entity.Computer;
import com.eoe.oop.day03.usb.Keyboard;
import com.eoe.oop.day03.usb.Mouse;
import com.eoe.oop.day03.usb.USB;
import com.eoe.oop.day03.usb.Udisk;

public class Test05 {
	public static void main(String[] args) {
		
	
Computer pc=new Computer();
pc.start();
pc.usbs[0]=new Udisk();
pc.usbs[1]=new Keyboard();
pc.usbs[2]=new Mouse();
pc.usbs[3]=new USB() {
	
	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("扫描仪将扫描到的数据发送给主机");
	}
	
	@Override
	public void read() {
		// TODO Auto-generated method stub
		System.out.println("扫描仪扫描纸质文件");
	}
};
pc.run();
	}
}
