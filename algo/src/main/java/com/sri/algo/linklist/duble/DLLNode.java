package com.sri.algo.linklist.duble;

public class DLLNode<T> {

	T pageData;
	int pageId;
	DLLNode<T> next;
	DLLNode<T> prev;

	DLLNode(T data,int pageId) 
	{
		this.pageData = data;
		this.pageId = pageId;
	}

}
