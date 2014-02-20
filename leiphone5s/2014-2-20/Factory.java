package com.eoe.se2.day12;

import com.eoe.fengleiit.view.Button;
import com.eoe.fengleiit.view.EditText;
import com.eoe.fengleiit.view.LinearLayout;
import com.eoe.fengleiit.view.TextView;
import com.eoe.fengleiit.view.View;

public class Factory {
	public static <T extends View> T getInstance(String className) {
		T view = null;
		switch (className) {
		case "LinearLayout":
			view = (T) new LinearLayout();
			break;

		case "TextView":
			view = (T) new TextView();
			break;
		case "EditText":
			view = (T) new EditText();
			break;
		case "Button":
			view = (T) new Button();
			break;
		}
		return view;
	}
}
