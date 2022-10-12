package com.moon.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AutoCoder {
    // 数据源配置
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/woniu_food";
    private static final String NAME = "root";
    private static final String PASS = "";
    // 输出配置
    private static final boolean f_jpa = false;
    private static final boolean f_mvn = true;
    private static String entity_pack = "com.moon.entity";

    // 全局
    private String authorName = "Mystery";
    private String tablename = "";
    private String[] colnames;
    private String[] colTypes;
    private int[] colSizes;

    // 代码生成器
    public AutoCoder() {
        List<String> list = getTableName();
        for (int p = 0; p < list.size(); p++) {
            tablename = list.get(p);
            // 创建连接
            Connection con;
            // 查询表
            String sql = "select * from " + tablename;
            PreparedStatement pStemt = null;
            try {
                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL, NAME, PASS);
                pStemt = con.prepareStatement(sql);
                ResultSetMetaData rsmd = pStemt.getMetaData();
                int size = rsmd.getColumnCount();
                colnames = new String[size];
                colTypes = new String[size];
                colSizes = new int[size];
                for (int i = 0; i < size; i++) {
                    colnames[i] = rsmd.getColumnName(i + 1);
                    colTypes[i] = rsmd.getColumnTypeName(i + 1);
                    colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
                }
                String content = parse(colnames, colTypes, colSizes);
                File directory = new File("");
                String partx = f_mvn ? "main/java/" : "";
                String outputDir = directory.getAbsolutePath() + "/src/" + partx + entity_pack.replace(".", "/") + "/";
                String outputPath = directory.getAbsolutePath() + "/src/" + partx + entity_pack.replace(".", "/") + "/"
                        + toEntityName(tablename) + ".java";
                File f = new File(outputDir);
                f.mkdirs();
                FileWriter fw = new FileWriter(outputPath);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(content);
                pw.flush();
                pw.close();
                fw.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 获取表名
    private List<String> getTableName() {
        List<String> list = new ArrayList<String>();
        try {
            DatabaseMetaData meta = DriverManager.getConnection(URL, NAME, PASS).getMetaData();
            ResultSet rs = meta.getTables(null, null, null, new String[]{"TABLE"});
            while (rs.next()) {
                list.add(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 生成实体类
    private String parse(String[] colnames, String[] colTypes, int[] colSizes) {
        StringBuffer sb = new StringBuffer();
        sb.append("package " + entity_pack + ";\r\n");
        sb.append("\r\n");
        sb.append("import java.io.Serializable;\r\n");
        sb.append("import java.util.Date;\r\n");
        // 是否jpa
        if (f_jpa) {
            sb.append("import javax.persistence.Entity;\r\n");
            sb.append("import javax.persistence.Table;\r\n");
            sb.append("import javax.persistence.GeneratedValue;\r\n");
            sb.append("import javax.persistence.GenerationType;\r\n");
            sb.append("import javax.persistence.Id;\r\n\r\n");
        }
        // 注释部分
        sb.append("/**\r\n");
        sb.append(" * " + tablename + " 实体类\r\n");
        sb.append(" * " + new Date() + "\r\n");
        sb.append(" * @" + authorName + "\r\n");
        sb.append(" */ \r\n");
        if (f_jpa) {
            sb.append("@Entity\r\n");
            sb.append("@Table(name=" + "\"" + tablename + "\"" + ")\r\n");
        }
        // 实体部分
        sb.append("public class " + toEntityName(tablename) + " implements Serializable {\r\n");
        sb.append("\tprivate static final long serialVersionUID = 1L;\r\n");
        processAllAttrs(sb);
        processAllMethod(sb);
        sb.append("}\r\n");
        return sb.toString();
    }

    // 生成属性
    private void processAllAttrs(StringBuffer sb) {
        for (int i = 0; i < colnames.length; i++) {
            sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " " + colnames[i] + ";\r\n");
        }
        sb.append("\r\n");
    }

    // 生成get/set
    private void processAllMethod(StringBuffer sb) {
        for (int i = 0; i < colnames.length; i++) {
            if (f_jpa) {
                if (i == 0) {
                    sb.append("\t@Id\r\n");
                    sb.append("\t@GeneratedValue(strategy = GenerationType.AUTO)\r\n");
                    sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get" + initcap(colnames[i]) + "() {\r\n");
                } else {
                    sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get" + initcap(colnames[i]) + "() {\r\n");
                }
            } else {
                sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get" + initcap(colnames[i]) + "() {\r\n");
            }
            sb.append("\t\treturn " + colnames[i] + ";\r\n");
            sb.append("\t}\r\n\r\n");
            sb.append("\tpublic void set" + initcap(colnames[i]) + "(" + sqlType2JavaType(colTypes[i]) + " "
                    + colnames[i] + ") {\r\n");
            sb.append("\t\tthis." + colnames[i] + "=" + colnames[i] + ";\r\n");
            sb.append("\t}\r\n\r\n");
        }
    }

    // 首字母大写
    private String initcap(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }

    // 表名转类名
    private String toEntityName(String tbName) {
        if (!tbName.contains("_"))
            return initcap(tbName);
        String[] partArr = tbName.split("_");
        String entityName = "";
        for (String part : partArr)
            entityName += initcap(part);
        return entityName;
    }

    // 获取字段类型
    private String sqlType2JavaType(String sqlType) {
        if (sqlType.equalsIgnoreCase("bit")) {
            return "Boolean";
        } else if (sqlType.equalsIgnoreCase("tinyint")) {
            return "Byte";
        } else if (sqlType.equalsIgnoreCase("smallint")) {
            return "Short";
        } else if (sqlType.equalsIgnoreCase("int") || sqlType.equalsIgnoreCase("integer")
                || sqlType.equalsIgnoreCase("INT UNSIGNED")) {
            return "Integer";
        } else if (sqlType.equalsIgnoreCase("bigint")) {
            return "Long";
        } else if (sqlType.equalsIgnoreCase("float")) {
            return "Float";
        } else if (sqlType.equalsIgnoreCase("double") || sqlType.equalsIgnoreCase("decimal")
                || sqlType.equalsIgnoreCase("numeric") || sqlType.equalsIgnoreCase("real")
                || sqlType.equalsIgnoreCase("money") || sqlType.equalsIgnoreCase("smallmoney")) {
            return "Double";
        } else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")) {
            return "String";
        } else if (sqlType.equalsIgnoreCase("date") || sqlType.equalsIgnoreCase("datetime")) {
            return "Date";
        } else if (sqlType.equalsIgnoreCase("image")) {
            return "Blob";
        }
        return null;
    }

    // 入口
    public static void main(String[] args) {
        // 生成实体
        new AutoCoder();
        // 输出成功
        System.out.println("生成代码成功");
    }
}