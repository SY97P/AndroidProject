package com.example.autobahnrestpoints.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0018\u0019B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\tJ\u001e\u0010\u0016\u001a\u00020\r2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/autobahnrestpoints/adapter/RestPointAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/autobahnrestpoints/adapter/RestPointAdapter$ViewHolder;", "()V", "mList", "Ljava/util/ArrayList;", "Lcom/example/autobahnrestpoints/model/RestPointModel;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lcom/example/autobahnrestpoints/adapter/RestPointAdapter$OnItemClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemClickListener", "itemClickListener", "setList", "list", "OnItemClickListener", "ViewHolder", "app_debug"})
public final class RestPointAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.autobahnrestpoints.adapter.RestPointAdapter.ViewHolder> {
    private java.util.ArrayList<com.example.autobahnrestpoints.model.RestPointModel> mList;
    private com.example.autobahnrestpoints.adapter.RestPointAdapter.OnItemClickListener onItemClickListener;
    
    public RestPointAdapter() {
        super();
    }
    
    public final void setItemClickListener(@org.jetbrains.annotations.NotNull()
    com.example.autobahnrestpoints.adapter.RestPointAdapter.OnItemClickListener itemClickListener) {
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.autobahnrestpoints.model.RestPointModel> list) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.autobahnrestpoints.adapter.RestPointAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.autobahnrestpoints.adapter.RestPointAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/autobahnrestpoints/adapter/RestPointAdapter$OnItemClickListener;", "", "onClick", "", "view", "Landroid/view/View;", "position", "", "app_debug"})
    public static abstract interface OnItemClickListener {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        android.view.View view, int position);
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/example/autobahnrestpoints/adapter/RestPointAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/example/autobahnrestpoints/adapter/RestPointAdapter;Landroid/view/View;)V", "itemAddrName", "Landroid/widget/TextView;", "getItemAddrName", "()Landroid/widget/TextView;", "itemDetail", "getItemDetail", "itemTemper", "getItemTemper", "itemUnitName", "getItemUnitName", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView itemUnitName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView itemAddrName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView itemTemper = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView itemDetail = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getItemUnitName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getItemAddrName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getItemTemper() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getItemDetail() {
            return null;
        }
    }
}