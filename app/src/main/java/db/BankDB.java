package db;

public interface BankDB {

	String DB_NAME = "bank.db";
	int DB_VERSION = 1;

	interface TABLE_ACCOUNT {
		String TABLE_NAME = "account";
		String COLUM_ID = "id";
		String COLUM_NAME = "name";
		String COLUM_MONEY = "money";

		String SQL_CREATE = "create table " + TABLE_NAME // 表名
				+ " (" + COLUM_ID + " integer primary key autoincrement,"// ID列
				+ COLUM_NAME + " varchar(20)," // Name列
				+ COLUM_MONEY + " varchar(20))";// money列
	}
}
