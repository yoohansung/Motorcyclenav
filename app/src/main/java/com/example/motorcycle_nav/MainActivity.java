package com.example.motorcycle_nav;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.overlay.OverlayImage;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static NaverMap naverMap;

    //마커 변수 선언 및 초기화
    private Marker marker1 = new Marker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btnfrangment);
        Button btnMark1 = (Button) findViewById(R.id.btnmark1);

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavFragment navFragment = new NavFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, navFragment).commit();

            }
        });


        btnMark1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMarker(marker1, 33.2712, 126.5354, R.drawable.ic_baseline_place_24, 0);
                marker1.setOnClickListener(new Overlay.OnClickListener() {
                    @Override
                    public boolean onClick(@NonNull Overlay overlay) {
                        Toast.makeText(getApplication(), "마커1 클릭", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
            }
        });
    }

    private void setMarker(Marker marker, double lat, double lng, int resourceID, int zIndex) {

        marker.setIconPerspectiveEnabled(true);
        marker.setIcon(OverlayImage.fromResource(resourceID));
        marker.setAlpha(0.8f);
        marker.setPosition(new LatLng(lat, lng));
        marker.setZIndex(zIndex);
        marker.setMap(naverMap);
    }


    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        this.naverMap = naverMap;

        //배경 지도 선택
        naverMap.setLayerGroupEnabled(naverMap.LAYER_GROUP_BUILDING, true);
        //위치 및 각도 조정
        CameraPosition cameraPosition = new CameraPosition(
                new LatLng(33.38, 126.55),
                9,
                45,
                0
        );
        naverMap.setCameraPosition(cameraPosition);
    }
}


