package by.aex.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JspPathUtil {

    private static final String JSP_TEMPLATE = "/WEB-INF/jsp/%s/%s.jsp";

    public static String get(String jspFolderName, String jspPageName) {
        return String.format(JSP_TEMPLATE, jspFolderName, jspPageName);
    }
}
