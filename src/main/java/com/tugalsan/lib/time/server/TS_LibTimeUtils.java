package com.tugalsan.lib.time.server;

import com.tugalsan.api.cast.client.TGS_CastUtils;
import com.tugalsan.api.log.server.TS_Log;
import com.tugalsan.api.optional.client.TGS_Optional;
import com.tugalsan.api.string.client.TGS_StringUtils;
import com.tugalsan.api.time.client.TGS_Time;
import com.tugalsan.api.url.server.TS_UrlDownloadUtils;
import com.tugalsan.lib.time.client.TGS_LibTime;
import java.time.Duration;
import java.util.StringTokenizer;

public class TS_LibTimeUtils {

    final private static TS_Log d = TS_Log.of(false, TS_LibTimeUtils.class);

    public static TGS_Optional<TGS_Time> fetch(CharSequence ip, int sslPort) {
        var url = TGS_LibTime.url(ip, sslPort);
        var urlData = TS_UrlDownloadUtils.toText(url, Duration.ofSeconds(10));
        if (TGS_StringUtils.isNullOrEmpty(urlData)) {
            return TGS_Optional.ofEmpty("ERROR@", d.className, "fetch",
                    "REASON: TGS_StringUtils.isNullOrEmpty(urlData)"
            );
        }
        var pattern = TGS_LibTime.PATTERN();
        if (pattern.length() != urlData.length()) {
            return TGS_Optional.ofEmpty("ERROR@", d.className, "fetch",
                    "REASON: pattern.length() != urlData.length() where",
                    "pattern", pattern
            );
        }
        var st = new StringTokenizer(" ");
        if (st.countTokens() != 2) {
            return TGS_Optional.ofEmpty("ERROR@", d.className, "fetch",
                    "REASON: st.countTokens() != 2 where",
                    "pattern", pattern,
                    "urlData", urlData
            );
        }
        var dateStr = st.nextToken();
        var dateLng = TGS_CastUtils.toLong(dateStr);
        if (dateLng == null) {
            return TGS_Optional.ofEmpty("ERROR@", d.className, "fetch",
                    "REASON: dateLng == null where",
                    "pattern", pattern,
                    "urlData", urlData,
                    "dateStr", dateStr
            );
        }
        var timeStr = st.nextToken();
        var timeLng = TGS_CastUtils.toLong(timeStr);
        if (timeLng == null) {
            return TGS_Optional.ofEmpty("ERROR@", d.className, "fetch",
                    "REASON: dateLng == null where",
                    "pattern", pattern,
                    "urlData", urlData,
                    "dateStr", dateStr,
                    "timeStr", timeStr
            );
        }
        return TGS_Optional.of(TGS_Time.ofDateAndTime(dateLng, timeLng));
    }
}
