package Controllers;

import android.content.Context;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Data;
import Models.DatabaseAdapter;


public class Controller {

    //static so the data don't delete every time the controller made by object
    private static DatabaseAdapter databaseAdapter = null;
    private static Data dataModel = null;

    public Controller() {
        if (databaseAdapter == null)
            databaseAdapter = new DatabaseAdapter();
        if (dataModel == null)
            dataModel = new Data();
    }

    protected DatabaseAdapter databaseAdapter() {
        return databaseAdapter;
    }

    protected Data dataModel() {
        return dataModel;
    }

    //get the data from database in array
    protected ArrayList<Object> resultToArray(ResultSet data, String Column_Name) {
        ArrayList<Object> list = new ArrayList<Object>();
        try {
            if (data == null)
                list = null;
            while (data.next()) {
                //Retrieve by column name

                list.add((Object) data.getObject(Column_Name));

            }
            data.beforeFirst();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        return list;
    }

    //get the data from database in array
    protected ArrayList<Object> resultToArray(ResultSet data, int Column_Number) {
        ArrayList<Object> list = new ArrayList<Object>();
        try {
            if (data == null)
                list = null;
            while (data.next()) {
                //Retrieve by column number
                list.add((Object) data.getObject(Column_Number));
            }
            data.beforeFirst();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        return list;
    }

    //get the data from database in array
    protected ArrayList<Object> resultToArray(ResultSet data) {
        ArrayList<Object> list = new ArrayList<Object>();
        try {
            if (data == null)
                list = null;
            while (data.next()) {
                //Retrieve by column number
                list.add((Object) data.getObject(1));
            }
            data.beforeFirst();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        return list;
    }


    //get one value from the data
    protected Object resultToValue(ResultSet data, int Column_Number) {
        Object value = null;
        try {
            if (data == null)
                value = null;
            data.next();
            value = data.getObject(Column_Number);
            data.beforeFirst();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        return value;
    }


    //get one value from the data
    protected Object resultToValue(ResultSet data, String Column_Name) {
        Object value = null;
        try {
            if (data == null)
                value = null;
            data.next();
            value = data.getObject(Column_Name);
            data.beforeFirst();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        return value;
    }


    //get one value from the data
    protected Object resultToValue(ResultSet data) {
        Object value = null;
        try {
            if (data == null)
                value = null;
            data.next();
            value = data.getObject(1);
            data.beforeFirst();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        return value;
    }

    //check if the value found in database or not
    protected Boolean checkIfFound(ResultSet data) {
        String sv = (String) resultToValue(data);
        if(sv ==null)
            return  false;
        return  true;
    }


   public void toast(String msg, Context w) {
       Toast.makeText(w.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

    }

}