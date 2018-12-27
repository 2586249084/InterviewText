package com.example.mrzhang.interviewtext.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableImplement implements Parcelable{

    private int id;
    private String name;


    protected ParcelableImplement(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
    }

    /**
     * 当前对象的内容描述，一般返回0即可
     */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
    }

    /**
     * public static final一个都不能少，内部对象CREATOR的名称不能改变，必须全部大写
     * 重写接口中的两个方法:
     * createFormParcel(Parcel in) 实现从Parcel容器中读取传递数据值，封装成Parcelable对象
     * newArray(int size) 创建一个类型为T，长度为size的数组，供外部反序列化本类数组使用
     */
    public static final Creator<ParcelableImplement> CREATOR = new Creator<ParcelableImplement>() {
        /**
         * 从序列化的对象中创建原始对象
         */
        @Override
        public ParcelableImplement createFromParcel(Parcel in) {
            return new ParcelableImplement(in);
        }

        /**
         * 创建指定长度的原始对象数组
         */
        @Override
        public ParcelableImplement[] newArray(int size) {
            return new ParcelableImplement[size];
        }
    };
}
