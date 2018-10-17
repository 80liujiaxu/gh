package com.example.demo.utils;
/**
 * ���ڽ��з�ҳ�����Ĵ��ݣ�ThreadLocal������������⣺�̰߳�ȫ���ࣩ
 * @author 80946
 *
 */
public class SystemContext {

	private static ThreadLocal<Integer> offset = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
	
	public static int getOffset() {
		return offset.get();
	}
	public static void setOffset(int _offset) {
		SystemContext.offset.set(_offset);;
	}
	public static int getPageSize() {
		return pageSize.get();
	}
	public static void setPageSize(int _pageSize) {
		SystemContext.pageSize.set(_pageSize);;
	}
	
	public static void removeOffset()
	{
		offset.remove();
	}
	public static void removePageSize()
	{
		pageSize.remove();
	}
}
