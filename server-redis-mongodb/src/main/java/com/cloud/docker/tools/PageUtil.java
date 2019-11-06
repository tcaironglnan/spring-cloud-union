package com.cloud.docker.tools;
import com.github.pagehelper.PageInfo;

/**
 * @author FaceFeel
 * @Created 2018-05-04 10:12
 **/
public class PageUtil {

    public static <T> Page<T> page(PageInfo pageInfo) {

        Page<T> page = new Page<>();

        Long pageCount = (pageInfo.getTotal() + pageInfo.getPageSize() - 1) / pageInfo.getPageSize();
        page.setList(pageInfo.getList())
                .setTotalPage(pageCount)
                .setPageCurrent(pageInfo.getPageNum())
                .setPageSize(pageInfo.getPageSize())
                .setTotalRow(pageInfo.getTotal());
        return page;
    }
}
