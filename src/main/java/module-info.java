module com.tugalsan.lib.time {
    requires com.tugalsan.api.time;
    requires com.tugalsan.api.url;
    requires com.tugalsan.api.string;
    requires com.tugalsan.api.cast;
    requires com.tugalsan.api.log;
    requires com.tugalsan.api.optional;
    exports com.tugalsan.lib.time.client;
    exports com.tugalsan.lib.time.server;
}
