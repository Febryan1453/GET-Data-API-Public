package com.febryan.kisahnabi.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseKisahNabi{

	@SerializedName("result")
	private List<ResultItem> result;

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}
}