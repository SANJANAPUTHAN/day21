package day21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DbUtility {
public static void main(String[] args) {
	ExecutorService es=Executors.newFixedThreadPool(2);
	es.execute(()->{
		System.out.println(JDBCDemo10.getConnection());
		System.out.println(JDBCDemo10.getConnection());
	});
	es.execute(()->{
		System.out.println(JDBCDemo10.getConnection());
		System.out.println(JDBCDemo10.getConnection());
	});
	es.shutdown();
}
}
