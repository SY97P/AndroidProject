package com.example.vaccinationcenter.recycler.model.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\u0015\u001a\u00020\r2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/vaccinationcenter/recycler/model/adapter/CenterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/vaccinationcenter/recycler/model/adapter/CenterAdapter$ViewHolder;", "()V", "cList", "Ljava/util/ArrayList;", "Lcom/example/vaccinationcenter/recycler/model/model/CenterModel;", "Lkotlin/collections/ArrayList;", "itemClickListener", "Lcom/example/vaccinationcenter/recycler/model/adapter/CenterAdapter$ItemClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemClickListener", "setList", "list", "ItemClickListener", "ViewHolder", "app_debug"})
public final class CenterAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.vaccinationcenter.recycler.model.adapter.CenterAdapter.ViewHolder> {
    private java.util.ArrayList<com.example.vaccinationcenter.recycler.model.model.CenterModel> cList;
    private com.example.vaccinationcenter.recycler.model.adapter.CenterAdapter.ItemClickListener itemClickListener;
    
    public CenterAdapter() {
        super();
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.vaccinationcenter.recycler.model.model.CenterModel> list) {
    }
    
    public final void setItemClickListener(@org.jetbrains.annotations.NotNull()
    com.example.vaccinationcenter.recycler.model.adapter.CenterAdapter.ItemClickListener itemClickListener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.vaccinationcenter.recycler.model.adapter.CenterAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.vaccinationcenter.recycler.model.adapter.CenterAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/vaccinationcenter/recycler/model/adapter/CenterAdapter$ItemClickListener;", "", "onClick", "", "view", "Landroid/view/View;", "position", "", "app_debug"})
    public static abstract interface ItemClickListener {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        android.view.View view, int position);
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/vaccinationcenter/recycler/model/adapter/CenterAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Landroid/view/View;)V", "itemAddress", "Landroid/widget/TextView;", "getItemAddress", "()Landroid/widget/TextView;", "setItemAddress", "(Landroid/widget/TextView;)V", "itemCenterName", "getItemCenterName", "setItemCenterName", "itemFacilityName", "getItemFacilityName", "setItemFacilityName", "itemPhoneNumber", "getItemPhoneNumber", "setItemPhoneNumber", "view", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView itemCenterName;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView itemFacilityName;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView itemAddress;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView itemPhoneNumber;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getItemCenterName() {
            return null;
        }
        
        public final void setItemCenterName(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getItemFacilityName() {
            return null;
        }
        
        public final void setItemFacilityName(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getItemAddress() {
            return null;
        }
        
        public final void setItemAddress(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getItemPhoneNumber() {
            return null;
        }
        
        public final void setItemPhoneNumber(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
    }
}