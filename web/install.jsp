<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%!
private List<String> resetDatabase(boolean force) throws Exception {
        LinkedList<String> messages = new LinkedList();
        /* How to customize:
         * 1. Update the database name on dbname.
         * 2. Create the list of tables, under tablenames[].
         * 3. Create the list of table definition, under tables[].
         * 4. Create the data into the above table, under data[]. 
         * 
         * If there is any problem, it will exit at the very first error.
         */
        String dbname = "SOBDB";
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        /* this will generate database if not exist */
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbname + ";create=true", "user", "pwd");
        Statement stmt = con.createStatement();

        try {
            stmt.execute("CREATE SCHEMA " + dbname);
            // schema was created; it will appear into: Other schemas -> "dbname"
        } catch (SQLException e) {
            // schema already exists; do nothing.
            if (!force) {
                messages.add("Database exists. Doing nothing. Visit install.jsp on your browser to reset your database content.");
                return messages;
            }
        }

        /* drop tables if they exist */
        String tablenames[] = new String[]{
            "PROFESSOR","PROJECTE","PROFPROJ"};
        for (String tablename : tablenames) {
            try {
                stmt.executeUpdate("DROP TABLE " + dbname + "." + tablename);
                messages.add("<pre> -> DROP TABLE " + dbname + "." + tablename + "<pre>");
            } catch (SQLException e) {
                // table didn't exist; it is the first time
            }
        }

        /* creating tables */
        String tables[] = new String[]{
            "CREATE TABLE " + dbname + ".PROFESSOR ("
            + " IDPROF INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
            + " USUARI VARCHAR(25) NOT NULL,"
            + " PASS VARCHAR (25) NOT NULL,"
            + " NOM VARCHAR (25))",

            "CREATE TABLE " + dbname + ".PROJECTE ("
            + " IDPROJ INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
            + " TITOL VARCHAR (50),"
            + " DESCRIPCIO VARCHAR (100),"
            + " ESTAT VARCHAR(25),"
            + " ESTUDIANTS VARCHAR (50),"
            + " ESTUDIS VARCHAR (25),"
            + " RECURSOS VARCHAR (100),"
            + " DATA_DEFENSA VARCHAR (10),"
            + " QUALIFICACIO VARCHAR(10),"
            + " DATA_CREACIO VARCHAR (10),"
            + " DATA_MODIFICACIO VARCHAR (10))",
            
            "CREATE TABLE " + dbname + ".PROFPROJ ("
            + " IDPROFESSOR INT NOT NULL,"
            + " IDPROJECTE INT NOT NULL)"};
            
        for (String table : tables) {
            try {
                stmt.execute(table);
            } catch (SQLException e) {
                messages.add("<span class='error'>Error creating table: " + table + "</span>");
                return messages;
            }
            messages.add("<pre> -> " + table + "<pre>");
        }

        /* inserting data */
        /* you have to exclude the id autogenerated from the list of columns if you have use it. */
        String data[] = new String[]{

            "INSERT INTO " + dbname + ".PROFESSOR (USUARI, PASS, NOM) VALUES ('sob','sob','marc')",
            "INSERT INTO " + dbname + ".PROJECTE (TITOL, DESCRIPCIO, ESTAT, ESTUDIANTS, ESTUDIS, RECURSOS, DATA_DEFENSA, QUALIFICACIO, DATA_CREACIO, DATA_MODIFICACIO) VALUES ('Ciordia y sus andares felinos','Per un 10','ASSIGNAT','Pep', 'GEI', 'Molts recursos','2-5-2017','10','3-5-2017','4-5-2017')",
            "INSERT INTO " + dbname + ".PROFPROJ (IDPROFESSOR, IDPROJECTE) VALUES (1,1)"};

        for (String datum : data) {
            if (stmt.executeUpdate(datum) <= 0) {
                messages.add("<span class='error'>Error inserting data: " + datum + "</span>");
                return messages;
            }
            messages.add("<pre> -> " + datum + "<pre>");
        }
        return messages;
    }

    public void jspInit() {
        try {
            List<String> messages = resetDatabase(false);
            for (String message : messages) {
                System.out.println("install.jsp: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Force database installation</title>
    </head>
    <style>
        .error {
            color: red;
        }
        pre {
            color: green;
        }
    </style>
    <body>
        <h2>Database initialization in progress</h2>
<%
    List<String> messages = resetDatabase(true);
    for (String message : messages) {
        out.println(message);
    }
%>
        <button onclick="window.location='<%=request.getSession().getServletContext().getContextPath()%>'">Go home</button>
    </body>
</html>
