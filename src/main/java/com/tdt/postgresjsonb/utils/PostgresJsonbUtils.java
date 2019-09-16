package com.tdt.postgresjsonb.utils;

import org.springframework.util.StringUtils;

import java.util.List;

public class PostgresJsonbUtils {

    public static String toPostgresArrayStr(List<String> skills) {
        if (StringUtils.isEmpty(skills)) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        skills.forEach(s -> sb.append("\"").append(s).append("\"").append(","));
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
