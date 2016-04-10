package com.example.kaspar.calc;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by KasparTilk on 11.04.2016.
 */
public class UOW {
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;

    public OperandRepo operandRepo;
    public OperationRepo operationRepo;
    public StatisticsRepo statisticsRepo;

    public UOW(Context context){
        dbHelper = new SQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
        operandRepo = new OperandRepo(database, dbHelper.TABLE_OPERANDS, dbHelper.OPERANDS_ALLCOLUMNS);
        operationRepo = new OperationRepo(database, dbHelper.TABLE_OPERATIONS, dbHelper.OPERATIONS_ALLCOLUMNS);
        statisticsRepo = new StatisticsRepo(database, dbHelper.TABLE_STATISTICS, dbHelper.STATISTICS_ALLCOLUMNS);
    }

    public void close() {
        dbHelper.close();
    }
}
