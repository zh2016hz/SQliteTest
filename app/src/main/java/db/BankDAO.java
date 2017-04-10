package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

//DAO(Data Access Object) 数据访问对象
public class BankDAO {

	private BankDBOpenHelper helper;

	public BankDAO(Context context) {
		helper = new BankDBOpenHelper(context);
	}

	public void insert(String name, float money) {

		SQLiteDatabase database = helper.getWritableDatabase();

		String table = "account";
		String nullColumnHack = null;
		ContentValues values = new ContentValues();
		// 第一个参数就是列名
		// 第二个参数就是传入的值
		values.put("name", name);
		values.put("money", money);
		database.insert(table, nullColumnHack, values);
		// 释放资源
		database.close();

	}

	public void delete(String name) {

		SQLiteDatabase database = helper.getWritableDatabase();
		String table = "account";
		String whereClause = "name = ?";
		String[] whereArgs = new String[] { name };
		database.delete(table, whereClause, whereArgs);

		// 释放资源
		database.close();

	}

	public void update(String name, float money) {

		SQLiteDatabase database = helper.getWritableDatabase();

		String table = "account";
		ContentValues values = new ContentValues();
		values.put("money", money);
		String whereClause = "name = ?";
		String[] whereArgs = new String[] { name };
		database.update(table, values, whereClause, whereArgs);

		// 释放资源
		database.close();

	}

	public float query(String name) {

		float money = 0;

		SQLiteDatabase database = helper.getWritableDatabase();

		String table = BankDB.TABLE_ACCOUNT.TABLE_NAME; // 表名
		String[] columns = new String[] { "money" };// 要返回那几个列的数据.如果传入null就等价于select
													// *,
		String selection = "name = ?"; // 查询条件
		String[] selectionArgs = new String[] { name };// 条件的值
		String groupBy = null;// 分组
		String having = null;// 另外一个条件
		String orderBy = null;// 排序
		Cursor cursor = database.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);


		if (cursor != null) {
			cursor.moveToFirst();
			money = cursor.getFloat(0);
		} else {
			money = -1;
		}
		// 释放资源
		cursor.close();
		database.close();

		return money;
	}
}
