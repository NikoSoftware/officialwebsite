package top.nikochen.officialwebsite.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ToolUtil {

    /**
     * 对象是否不为空(新增)
     *
     * @author fengshuonan
     * @Date 2018/3/18 21:57
     */
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }



    /**
     * 对象是否为空
     *
     * @author fengshuonan
     * @Date 2018/3/18 21:57
     */
    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            if (o.toString().trim().equals("")) {
                return true;
            }
        } else if (o instanceof List) {
            if (((List) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Map) {
            if (((Map) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Set) {
            if (((Set) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Object[]) {
            if (((Object[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof int[]) {
            if (((int[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof long[]) {
            if (((long[]) o).length == 0) {
                return true;
            }
        }
        return false;
    }

}
