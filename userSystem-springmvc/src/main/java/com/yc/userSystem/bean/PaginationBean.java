package com.yc.userSystem.bean;

import java.util.List;

public class PaginationBean <T> {
	//请求参数
	private int pageSize = 10 ;
	private int page = 1;
	//响应参数
	private int allPage;
	private int total;
	private List<T> rows;
	
	@Override
	public String toString() {
		return "PaginationBean [pageSize=" + pageSize + ", page=" + page + ", allPage=" + allPage + ", total="
				+ total + ", rows=" + rows + "]";
	}
	public PaginationBean() {
		
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public PaginationBean(int page, int allPage, List<T> rows , int total) {
		this.page = page;
		this.allPage = allPage;
		this.rows = rows;
		this.total = total;
	}
	
	public PaginationBean(int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getAllPage() {
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	public  List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
