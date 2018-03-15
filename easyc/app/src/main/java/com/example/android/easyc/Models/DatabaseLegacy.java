package com.example.android.easyc.Models;

import android.os.AsyncTask;

import com.example.android.easyc.Interfaces.OnTaskListeners;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by KhALeD SaBrY on 03-Mar-18.
 */

public class DatabaseLegacy {

    private ConnectionDb conn = ConnectionDb.getInstance();

    public void iud(final  String query, final OnTaskListeners.Bool listener) {

        new AsyncTask<Void, Void, Boolean>() {
            public Integer updated = null;

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    Statement stmt;
                    stmt = conn.c.createStatement();
                    updated = stmt.executeUpdate(query);
                    if(updated == 1)
                        return true;
                    else
                        return false;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Boolean data) {
                listener.onSuccess(data);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
        }.execute();
    }

    public  void Select(final  String query,final OnTaskListeners.Result listeners)
    {
        new AsyncTask<Void, Void, ResultSet>() {
            public ResultSet RS = null;

            @Override
            protected ResultSet doInBackground(Void... params) {
                try {
                    Statement stmt;
                    stmt = conn.c.createStatement();
                    RS = stmt.executeQuery(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return RS;
            }

            @Override
            protected void onPostExecute(ResultSet data) {
                listeners.onSuccess(data);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
        }.execute();
    }

}



