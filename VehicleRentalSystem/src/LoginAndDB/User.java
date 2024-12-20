package LoginAndDB;

import java.util.List;
import java.util.ArrayList;
public class User {
	String name;
	String password;
	long number;
	public User(String name,String password,long number) {
		this.name=name;
		this.password=password;
		this.number=number;
	}
	void display() {
		System.out.println(name+" "+password+" "+number);
	}
	public static void main(String ar[]) {
		List<User> ls=new ArrayList<>();
		for(int i=0;i<4;i++) {
			ls.add(new User("User"+i,i+"0",234));
		}
		for(int i=0;i<4;i++) {
			ls.get(i).display();
		}
	}
}
