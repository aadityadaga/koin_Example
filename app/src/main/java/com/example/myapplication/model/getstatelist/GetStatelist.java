package com.example.myapplication.model.getstatelist;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetStatelist implements Parcelable {

    public static final Creator<GetStatelist> CREATOR = new Creator<GetStatelist>() {
        @Override
        public GetStatelist createFromParcel(Parcel source) {
            return new GetStatelist(source);
        }

        @Override
        public GetStatelist[] newArray(int size) {
            return new GetStatelist[size];
        }
    };
    @SerializedName("ResultType")
    @Expose
    private int resultType;
    @SerializedName("ResultCode")
    @Expose
    private int resultCode;
    @SerializedName("ResultDesc")
    @Expose
    private String resultDesc;
    @SerializedName("Result")
    @Expose
    private List<Result> result = null;

    public GetStatelist() {
    }

    private GetStatelist(Parcel in) {
        this.resultType = in.readInt();
        this.resultCode = in.readInt();
        this.resultDesc = in.readString();
        this.result = in.createTypedArrayList(Result.CREATOR);
    }

    public int getResultType() {
        return resultType;
    }

    public void setResultType(int resultType) {
        this.resultType = resultType;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.resultType);
        dest.writeInt(this.resultCode);
        dest.writeString(this.resultDesc);
        dest.writeTypedList(this.result);
    }


    @NonNull
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this);
    }
}
