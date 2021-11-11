package com.example.autobahnrestpoints.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0014J$\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001f0#j\b\u0012\u0004\u0012\u00020\u001f`$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/example/autobahnrestpoints/activity/MapsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "()V", "binding", "Lcom/example/autobahnrestpoints/databinding/ActivityMapsBinding;", "daySpinner", "Landroid/widget/Spinner;", "hourSpinner", "mAdapter", "Lcom/example/autobahnrestpoints/adapter/RestPointAdapter;", "mMap", "Lcom/google/android/gms/maps/GoogleMap;", "monthSpinner", "routeName", "Landroid/widget/TextView;", "searchButton", "Landroid/widget/ImageButton;", "searchText", "Landroid/widget/EditText;", "yearSpinner", "loadAdapter", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMapReady", "googleMap", "onStart", "searchRestPoint", "route", "", "date", "hour", "spinnerTask", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_debug"})
public final class MapsActivity extends androidx.appcompat.app.AppCompatActivity implements com.google.android.gms.maps.OnMapReadyCallback {
    private com.google.android.gms.maps.GoogleMap mMap;
    private com.example.autobahnrestpoints.databinding.ActivityMapsBinding binding;
    private com.example.autobahnrestpoints.adapter.RestPointAdapter mAdapter;
    private android.widget.EditText searchText;
    private android.widget.ImageButton searchButton;
    private android.widget.Spinner yearSpinner;
    private android.widget.Spinner monthSpinner;
    private android.widget.Spinner daySpinner;
    private android.widget.Spinner hourSpinner;
    private android.widget.TextView routeName;
    
    public MapsActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    private final java.util.ArrayList<java.lang.String> spinnerTask() {
        return null;
    }
    
    private final void loadAdapter() {
    }
    
    private final void searchRestPoint(java.lang.String route, java.lang.String date, java.lang.String hour) {
    }
    
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap googleMap) {
    }
}