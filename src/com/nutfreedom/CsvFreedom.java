package com.nutfreedom;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

public class CsvFreedom {
    private String table;
    private ServletOutputStream servletOutputStream;
    private HttpServletResponse response = null;
    private JspWriter out = null;
    private String filename = "csv";

    public CsvFreedom() {

    }

    public CsvFreedom(String table, ServletOutputStream servletOutputStream) {
        this.table = table;
        this.servletOutputStream = servletOutputStream;
    }

    public CsvFreedom(String table, ServletOutputStream servletOutputStream, HttpServletResponse response, JspWriter out, String filename) {
        this.table = table;
        this.servletOutputStream = servletOutputStream;
        this.response = response;
        this.out = out;
        this.filename = filename;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public ServletOutputStream getServletOutputStream() {
        return servletOutputStream;
    }

    public void setServletOutputStream(ServletOutputStream servletOutputStream) {
        this.servletOutputStream = servletOutputStream;
    }

    public void write() {
        String data = processData();
        try {
            this.servletOutputStream.write(data.getBytes());
            if (response != null) {
                response.setHeader("Content-Encoding", "UTF-8");
                response.setContentType("text/csv; charset=UTF-8");
                response.setHeader("Content-Disposition","inline; filename=" + filename + ".csv");
                out.clear();
            }
            this.servletOutputStream.flush();
            this.servletOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processData() {
        String str = "";
        SplitFreedom split = new SplitFreedom();
        SubstringFreedom sub = new SubstringFreedom();
        String[] spTable = split.split(this.table, "<table>");
        for (String table : spTable) {
            if (!table.equals("")) {
                String[] spTr = split.split(table, "<tr>");
                for (String tr : spTr) {
                    if (!tr.equals("")) {
                        String[] spTd = split.split(tr, "<td>");
                        for (String td : spTd) {
                            if (!td.equals("")) {
                                String value = sub.substring(td, 0, td.indexOf("</td>"));
                                str += value + ",";
                            }
                        }
                    }

                    if (!str.equals("")) {
                        str = sub.substring(str, 0, str.length() - 1);
                        str += "\n";
                    }
                }
                if (!str.equals("")) {
                    str = str.trim();
                }
            }
        }
        return str;
    }

}