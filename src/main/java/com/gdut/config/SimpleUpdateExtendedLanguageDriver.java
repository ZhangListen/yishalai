package com.gdut.config;

/**
 * Created by huang on 2017/1/7.
 */

import com.gdut.utils.Invisible;
import com.google.common.base.CaseFormat;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * update注解重写
 * Created by huang on 1/7/17.
 */
public class SimpleUpdateExtendedLanguageDriver extends XMLLanguageDriver
        implements LanguageDriver {
    private final Pattern inPattern = Pattern.compile("\\(#\\{(\\w+)\\}\\)");


    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        Matcher matcher = inPattern.matcher(script);

        if (matcher.find()) {
            StringBuffer ss = new StringBuffer();
            ss.append("<set>");

            for (Field field : parameterType.getDeclaredFields()) {
                if (!field.isAnnotationPresent(Invisible.class)) {
                    String temp = "<if test=\"__field != null\">__column=#{__field},</if>";
                    ss.append(temp.replaceAll("__field", field.getName())
                            .replaceAll("__column", field.getName()));
                    //CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field.getName())
                }
            }

            ss.deleteCharAt(ss.lastIndexOf(","));
            ss.append("</set>");

            script = matcher.replaceAll(ss.toString());

            script = "<script>" + script + "</script>";
        }
        return super.createSqlSource(configuration, script, parameterType);
    }
}