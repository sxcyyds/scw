package com.atguigu.crowd.utils;

public class ResultEntity<T> {
	public static final String SUCCESS="SUCCESS";
	public static final String FAILED="FAILED";
	//用来封装当前请求处理的结果是成功还是失败
	private String result;
	
	//请求处理失败时返回错误消息
	private String message;
	
	//要返回的数据
	private T data;
	
	/**
	 *请求成功
	 * @param <E>
	 * @return
	 */
	public static <E> ResultEntity<E> successWithoutData() {
		return new ResultEntity<E>(SUCCESS,null,null);
	}
	public static <E> ResultEntity<E> successWithData(E data) {
		return new ResultEntity<E>(SUCCESS,null,data);
	}

	/**
	 * 
	 * @param <E>
	 * @param message
	 * @return
	 */
	public static <E> ResultEntity<E> failed(String message) {
		return new ResultEntity<E>(FAILED,message,null);
	}
	public ResultEntity(String result, String message, T data) {
		super();
		this.result = result;
		this.message = message;
		this.data = data;
	}

	public ResultEntity() {
		super();
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getdata() {
		return data;
	}

	public void setdata(T data) {
		this.data = data;
	}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return "ResultEntity[result="+result+",message="+message+",data="+data+"]";
}

	
	
	
	
	

}
