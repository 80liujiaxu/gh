package com.example.demo.utils;

import java.util.List;

public class Pager<T> {

		private Integer offset; //��ʼҳ��
		
		private Integer pageSize; //ÿҳ��ʾ������
		
		private Long total; //�ܼ�¼��
		
		private List<?> datas;  //���ݼ���

		public Integer getOffset() {
			return offset;
		}

		public void setOffset(Integer offset) {
			this.offset = offset;
		}

		public Integer getPageSize() {
			return pageSize;
		}

		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}

		public Long getTotal() {
			return total;
		}

		public void setTotal(Long total) {
			this.total = total;
		}

		public List<?> getDatas() {
			return datas;
		}

		public void setDatas(List<?> datas) {
			this.datas = datas;
		}
}
