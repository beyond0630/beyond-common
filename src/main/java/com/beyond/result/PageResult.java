package com.beyond.result;


import com.beyond.constants.Code;

import java.util.List;


/**
 * @author Beyond
 */
public class PageResult<T> implements Paged<T>, IResult<List<T>> {


    private final String code;
    private final String message;
    private final List<T> data;
    private final int total;
    private final int page;
    private final int pageSize;
    private final int pageCount;

    private long elapsed;

    protected PageResult(final int total, final int page, final int pageSize, final List<T> data) {
        this(total, page, pageSize, PageUtils.computePageCount(total, pageSize), data);
    }

    protected PageResult(final int total, final int page, final int pageSize, final int pageCount, final List<T> data) {
        this.code = Code.SUCCESS;
        this.message = null;
        this.data = data;
        this.total = total;
        this.page = page;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public List<T> getData() {
        return data;
    }

    @Override
    public int getTotal() {
        return this.total;
    }

    @Override
    public int getPage() {
        return this.page;
    }

    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    @Override
    public int getPageCount() {
        return this.pageCount;
    }

    @Override
    public long getElapsed() {
        return elapsed;
    }

    @Override
    public void setElapsed(final long elapsed) {
        this.elapsed = elapsed;
    }

    public static <T> PageResult<T> make(final int total, final int page, final int pageSize, final List<T> data) {
        return new PageResult<>(total, page, pageSize, data);
    }

    public static <T> PageResult<T> make(final long total, final int page, final int pageSize, final List<T> data) {
        return new PageResult<>((int) total, page, pageSize, data);
    }

    public static <T> PageResult<T> from(final Paged<T> page) {
        return new PageResult<>(page.getTotal(), page.getPage(), page.getPageSize(), page.getPageCount(), page.getData());
    }

}
