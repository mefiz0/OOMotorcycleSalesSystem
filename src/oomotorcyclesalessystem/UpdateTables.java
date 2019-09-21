/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oomotorcyclesalessystem;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author sath
 */
public class UpdateTables {
    DatabaseConnection connecion = new DatabaseConnection(); //create a new connection object
    
    public UpdateTables(ResultSet rs) throws SQLException{
        ResultSetMetaData metaData = rs.getMetaData();
        
        //get the names of the columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        
    }
}
