module com.tugalsan.lib.time {
    requires gwt.user;
    requires com.tugalsan.api.cast;
    requires com.tugalsan.api.tomcat;
    requires com.tugalsan.api.runnable;
    requires com.tugalsan.api.list;
    requires com.tugalsan.api.log;
    requires com.tugalsan.api.string;
    requires com.tugalsan.api.time;
    requires com.tugalsan.api.url;
    requires com.tugalsan.api.validator;
    requires com.tugalsan.api.servlet.url;
    requires com.tugalsan.api.sql.conn;
    requires com.tugalsan.api.sql.basic;
    exports com.tugalsan.lib.time.client;
    exports com.tugalsan.lib.time.server;
}
