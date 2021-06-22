package com.febryan.kisahnabi.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ResultItem implements Parcelable {

	@SerializedName("usia")
	private String usia;

	@SerializedName("icon_url")
	private String iconUrl;

	@SerializedName("tmp")
	private String tmp;

	@SerializedName("image_url")
	private String imageUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("thn_kelahiran")
	private String thnKelahiran;

	@SerializedName("description")
	private String description;

	protected ResultItem(Parcel in) {
		usia = in.readString();
		iconUrl = in.readString();
		tmp = in.readString();
		imageUrl = in.readString();
		name = in.readString();
		thnKelahiran = in.readString();
		description = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(usia);
		dest.writeString(iconUrl);
		dest.writeString(tmp);
		dest.writeString(imageUrl);
		dest.writeString(name);
		dest.writeString(thnKelahiran);
		dest.writeString(description);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<ResultItem> CREATOR = new Creator<ResultItem>() {
		@Override
		public ResultItem createFromParcel(Parcel in) {
			return new ResultItem(in);
		}

		@Override
		public ResultItem[] newArray(int size) {
			return new ResultItem[size];
		}
	};

	public void setUsia(String usia){
		this.usia = usia;
	}

	public String getUsia(){
		return usia;
	}

	public void setIconUrl(String iconUrl){
		this.iconUrl = iconUrl;
	}

	public String getIconUrl(){
		return iconUrl;
	}

	public void setTmp(String tmp){
		this.tmp = tmp;
	}

	public String getTmp(){
		return tmp;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setThnKelahiran(String thnKelahiran){
		this.thnKelahiran = thnKelahiran;
	}

	public String getThnKelahiran(){
		return thnKelahiran;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}
}