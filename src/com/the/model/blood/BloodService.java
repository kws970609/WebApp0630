package com.the.model.blood;

public class BloodService {
	public String getBlood(String blood) {
		String msg = null;
		if(blood.equals("A")) {
			msg="소심한편";
		}
		else if(blood.equals("A")) {
			msg="소심한편";
		}
		else if(blood.equals("B")) {
			msg="지랄맞은 편";
		}
		else if(blood.equals("O")) {
			msg="오지랖 심함편";
		}
		else if(blood.equals("AB")) {
			msg="왔다리갔다리 하는편";
		}
		return msg;
	}
}
