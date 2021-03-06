package org.jfree.data.jdbc;

import org.jfree.data.xy.*;
import org.jfree.util.*;
import java.util.*;
import java.sql.*;
import org.jfree.data.*;

public class JDBCXYDataset extends AbstractXYDataset implements RangeInfo, TableXYDataset, XYDataset
{
    private transient Connection connection;
    private String[] columnNames;
    private ArrayList rows;
    private double maxValue;
    private double minValue;
    private boolean isTimeSeries;
    
    private JDBCXYDataset() {
        this.columnNames = new String[0];
        this.maxValue = 0.0;
        this.minValue = 0.0;
        this.isTimeSeries = false;
        this.rows = new ArrayList();
    }
    
    public JDBCXYDataset(final String s, final String s2, final String s3, final String s4) {
        this();
        Class.forName(s2);
        this.connection = DriverManager.getConnection(s, s3, s4);
    }
    
    public JDBCXYDataset(final Connection connection) {
        this();
        this.connection = connection;
    }
    
    public JDBCXYDataset(final Connection connection, final String s) {
        this(connection);
        this.executeQuery(s);
    }
    
    public boolean isTimeSeries() {
        return this.isTimeSeries;
    }
    
    public void setTimeSeries(final boolean isTimeSeries) {
        this.isTimeSeries = isTimeSeries;
    }
    
    public void executeQuery(final String s) {
        this.executeQuery(this.connection, s);
    }
    
    public void executeQuery(final Connection connection, final String s) {
        if (connection == null) {
            throw new SQLException("There is no database to execute the query.");
        }
        ResultSet executeQuery = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            executeQuery = statement.executeQuery(s);
            final ResultSetMetaData metaData = executeQuery.getMetaData();
            final int columnCount = metaData.getColumnCount();
            int n = 0;
            final int[] array = new int[columnCount];
            for (int i = 0; i < columnCount; ++i) {
                try {
                    final int columnType = metaData.getColumnType(i + 1);
                    switch (columnType) {
                        case -7:
                        case -5:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 91:
                        case 92:
                        case 93: {
                            ++n;
                            array[i] = columnType;
                            break;
                        }
                        default: {
                            Log.warn("Unable to load column " + i + " (" + columnType + "," + metaData.getColumnClassName(i + 1) + ")");
                            array[i] = 0;
                            break;
                        }
                    }
                }
                catch (SQLException ex) {
                    array[i] = 0;
                    throw ex;
                }
            }
            if (n <= 1) {
                throw new SQLException("Not enough valid columns where generated by query.");
            }
            this.columnNames = new String[n - 1];
            int n2 = 0;
            for (int j = 1; j < columnCount; ++j) {
                if (array[j] != 0) {
                    this.columnNames[n2] = metaData.getColumnLabel(j + 1);
                    ++n2;
                }
            }
            if (this.rows != null) {
                for (int k = 0; k < this.rows.size(); ++k) {
                    ((ArrayList)this.rows.get(k)).clear();
                }
                this.rows.clear();
            }
            switch (array[0]) {
                case 91:
                case 92:
                case 93: {
                    this.isTimeSeries = true;
                    break;
                }
                default: {
                    this.isTimeSeries = false;
                    break;
                }
            }
            while (executeQuery.next()) {
                final ArrayList<Date> list = new ArrayList<Date>();
                for (int l = 0; l < columnCount; ++l) {
                    final Object object = executeQuery.getObject(l + 1);
                    switch (array[l]) {
                        case -5:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8: {
                            list.add((Date)object);
                            break;
                        }
                        case 91:
                        case 92:
                        case 93: {
                            list.add((Date)new Long(((Date)object).getTime()));
                            break;
                        }
                        case 0: {
                            break;
                        }
                        default: {
                            System.err.println("Unknown data");
                            array[l] = 0;
                            break;
                        }
                    }
                }
                this.rows.add(list);
            }
            if (this.rows.size() == 0) {
                final ArrayList<Integer> list2 = new ArrayList<Integer>();
                for (int n3 = 0; n3 < columnCount; ++n3) {
                    if (array[n3] != 0) {
                        list2.add(new Integer(0));
                    }
                }
                this.rows.add(list2);
            }
            if (this.rows.size() < 1) {
                this.maxValue = 0.0;
                this.minValue = 0.0;
            }
            else {
                final ArrayList list3 = this.rows.get(0);
                this.maxValue = Double.NEGATIVE_INFINITY;
                this.minValue = Double.POSITIVE_INFINITY;
                for (int n4 = 0; n4 < this.rows.size(); ++n4) {
                    final ArrayList<Object> list4 = this.rows.get(n4);
                    for (int n5 = 1; n5 < columnCount; ++n5) {
                        final Number value = list4.get(n5);
                        if (value != null) {
                            final double doubleValue = value.doubleValue();
                            if (doubleValue < this.minValue) {
                                this.minValue = doubleValue;
                            }
                            if (doubleValue > this.maxValue) {
                                this.maxValue = doubleValue;
                            }
                        }
                    }
                }
            }
            this.fireDatasetChanged();
        }
        finally {
            if (executeQuery != null) {
                try {
                    executeQuery.close();
                }
                catch (Exception ex2) {}
            }
            if (statement != null) {
                try {
                    statement.close();
                }
                catch (Exception ex3) {}
            }
        }
    }
    
    public Number getX(final int n, final int n2) {
        return this.rows.get(n2).get(0);
    }
    
    public Number getY(final int n, final int n2) {
        return this.rows.get(n2).get(n + 1);
    }
    
    public int getItemCount(final int n) {
        return this.rows.size();
    }
    
    public int getItemCount() {
        return this.getItemCount(0);
    }
    
    public int getSeriesCount() {
        return this.columnNames.length;
    }
    
    public Comparable getSeriesKey(final int n) {
        if (n < this.columnNames.length && this.columnNames[n] != null) {
            return this.columnNames[n];
        }
        return "";
    }
    
    public int getLegendItemCount() {
        return this.getSeriesCount();
    }
    
    public String[] getLegendItemLabels() {
        return this.columnNames;
    }
    
    public void close() {
        try {
            this.connection.close();
        }
        catch (Exception ex) {
            System.err.println("JdbcXYDataset: swallowing exception.");
        }
    }
    
    public double getRangeLowerBound(final boolean b) {
        return this.minValue;
    }
    
    public double getRangeUpperBound(final boolean b) {
        return this.maxValue;
    }
    
    public Range getRangeBounds(final boolean b) {
        return new Range(this.minValue, this.maxValue);
    }
}
