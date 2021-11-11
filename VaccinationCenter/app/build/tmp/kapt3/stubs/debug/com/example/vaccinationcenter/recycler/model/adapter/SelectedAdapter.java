package com.example.vaccinationcenter.recycler.model.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\u0015\u001a\u00020\r2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/vaccinationcenter/recycler/model/adapter/SelectedAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/vaccinationcenter/recycler/model/adapter/SelectedAdapter$ViewHolder;", "()V", "dList", "Ljava/util/ArrayList;", "Lcom/example/vaccinationcenter/recycler/model/model/SelectedModel;", "Lkotlin/collections/ArrayList;", "itemClickListener", "Lcom/example/vaccinationcenter/recycler/model/adapter/SelectedAdapter$ItemClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemClickListener", "setList", "list", "ItemClickListener", "ViewHolder", "app_debug"})
public final class SelectedAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.vaccinationcenter.recycler.model.adapter.SelectedAdapter.ViewHolder> {
    private java.util.ArrayList<com.example.vaccinationcenter.recycler.model.model.SelectedModel> dList;
    private com.example.vaccinationcenter.recycler.model.adapter.SelectedAdapter.ItemClickListener itemClickListener;
    
    public SelectedAdapter() {
        super();
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.vaccinationcenter.recycler.model.model.SelectedModel> list) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.vaccinationcenter.recycler.model.adapter.SelectedAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    public final void setItemClickListener(@org.jetbrains.annotations.NotNull()
    com.example.vaccinationcenter.recycler.model.adapter.SelectedAdapter.ItemClickListener itemClickListener) {
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.vaccinationcenter.recycler.model.adapter.SelectedAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/vaccinationcenter/recycler/model/adapter/SelectedAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Landroid/view/View;)V", "itemAddress", "Landroid/widget/TextView;", "getItemAddress", "()Landroid/widget/TextView;", "itemCenterName", "getItemCenterName", "itemFacilityName", "getItemFacilityName", "itemPhoneNumber", "getItemPhoneNumber", "view", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView itemCenterName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView itemFacilityName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView itemAddress = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView itemPhoneNumber = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getItemCenterName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getItemFacilityName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getItemAddress() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getItemPhoneNumber() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/vaccinationcenter/recycler/model/adapter/SelectedAdapter$ItemClickListener;", "", "onClick", "", "view", "Landroid/view/View;", "position", "", "app_debug"})
    public static abstract interface ItemClickListener {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        android.view.View view, int position);
    }
}