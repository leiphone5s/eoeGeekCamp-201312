package com.eoe.se2.day12;

import java.util.Scanner;

import com.eoe.fengleiit.view.Button;
import com.eoe.fengleiit.view.EditText;
import com.eoe.fengleiit.view.TextView;

public class MainActivity extends Activity {
	public static void main(String[] args) {
		AAA: while (true) {
			System.out.println("1-创建TextView对象");
			System.out.println("2-创建EditText对象");
			System.out.println("3-创建Button对象");
			int select = new Scanner(System.in).nextInt();
			switch (select) {
			case 1:
				TextView tvName = findViewById(R.id.tvName);
				System.out.println(tvName);
				System.out.println();
				continue AAA;

			case 2:
				EditText etName = findViewById(R.id.etName);
				System.out.println(etName);
				System.out.println();
				continue AAA;
			case 3:
				Button btnLogin = findViewById(R.id.btnLogin);
				System.out.println(btnLogin);
				System.out.println();
				continue AAA;
			}
		}
	}
}
