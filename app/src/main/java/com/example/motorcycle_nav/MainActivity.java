package com.example.motorcycle_nav;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private MapView mapView;
    private static NaverMap naverMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* 네이버 지도 */
        mapView=(MapView) findViewById(R.id.map_view);
                mapView.onCreate(savedInstanceState);
                        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        this.naverMap =naverMap;
        //배경 지도 바꾸기
        naverMap.setMapType(NaverMap.MapType.Navi);
        //건물,실시간 교통정보 표시
        naverMap.setLayerGroupEnabled(naverMap.LAYER_GROUP_BUILDING,true);
        naverMap.setLayerGroupEnabled(naverMap.LAYER_GROUP_TRAFFIC,true);
        //야간 모드
        naverMap.setNightModeEnabled(true);
        CameraPosition cameraPosition = new CameraPosition(new LatLng(33.38,126.55),9,45,45);
naverMap.setCameraPosition(cameraPosition);
    }


    @Override
    public void onStart()
    {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop()
    {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory()
    {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}