package com.example.vaccinationcenter.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J&\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006 "}, d2 = {"Lcom/example/vaccinationcenter/fragment/SelectedFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "()V", "cMap", "Lcom/google/android/gms/maps/GoogleMap;", "dAdapter", "Lcom/example/vaccinationcenter/recycler/model/adapter/SelectedAdapter;", "dDb", "Lcom/example/vaccinationcenter/database/SelectedDatabase;", "getDDb", "()Lcom/example/vaccinationcenter/database/SelectedDatabase;", "setDDb", "(Lcom/example/vaccinationcenter/database/SelectedDatabase;)V", "getList", "Ljava/util/ArrayList;", "Lcom/example/vaccinationcenter/recycler/model/model/SelectedModel;", "Lkotlin/collections/ArrayList;", "dList", "", "Lcom/example/vaccinationcenter/database/entity/Selected;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onMapReady", "", "googleMap", "app_debug"})
public final class SelectedFragment extends androidx.fragment.app.Fragment implements com.google.android.gms.maps.OnMapReadyCallback {
    private com.example.vaccinationcenter.recycler.model.adapter.SelectedAdapter dAdapter;
    public com.example.vaccinationcenter.database.SelectedDatabase dDb;
    private com.google.android.gms.maps.GoogleMap cMap;
    private java.util.HashMap _$_findViewCache;
    
    public SelectedFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.vaccinationcenter.database.SelectedDatabase getDDb() {
        return null;
    }
    
    public final void setDDb(@org.jetbrains.annotations.NotNull()
    com.example.vaccinationcenter.database.SelectedDatabase p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final java.util.ArrayList<com.example.vaccinationcenter.recycler.model.model.SelectedModel> getList(java.util.List<com.example.vaccinationcenter.database.entity.Selected> dList) {
        return null;
    }
    
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap googleMap) {
    }
}